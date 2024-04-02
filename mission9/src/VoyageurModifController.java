import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class VoyageurModifController {

    @FXML
    private TextField voyageurNom;

    @FXML
    private TextField voyageurAge;

    @FXML
    private TextField voyageurRue;

    @FXML
    private TextField voyageurVille;

    @FXML
    private TextField voyageurAdressePostale;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button supprimerButton;

    @FXML
    private Text alertText;

    @FXML
    private TableView<Voyageur> table;

    @FXML
    private TableColumn<Voyageur, Long> id;

    @FXML
    private TableColumn<Voyageur, String> nom;

    @FXML
    private TableColumn<Voyageur, Integer> age;

    @FXML
    private TableColumn<Voyageur, String> adresse;

    @FXML
    private TableColumn<Voyageur, String> bagage;

    @FXML
    private TableColumn<Voyageur, String> destination;

    private ObservableList<Voyageur> voyageursList = FXCollections.observableArrayList();

    private VoyageurDAO voyageurDAO = new VoyageurDAO();

    private VoyageDAO voyageDAO = new VoyageDAO();

    @FXML
    private void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
        bagage.setCellValueFactory(new PropertyValueFactory<>("bagage"));
        destination.setCellValueFactory(new PropertyValueFactory<>("voyage"));

        voyageursList.addAll(voyageurDAO.selectAll());
        table.setItems(voyageursList);

        // Charger les destinations disponibles dans la ChoiceBox au démarrage de l'application
        List<String> destinations = voyageDAO.getAllDestinations();
        if (destinations != null) {
            choiceBox.setItems(FXCollections.observableArrayList(destinations));
        }

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                displayVoyageurDetails(newSelection);
            }
        });
    }

    @FXML
    private void confirmButton() {
        Voyageur selectedVoyageur = table.getSelectionModel().getSelectedItem();
        if (selectedVoyageur != null) {
            selectedVoyageur.setName(voyageurNom.getText());
            selectedVoyageur.setAge(Integer.parseInt(voyageurAge.getText()));
            selectedVoyageur.getAddress().setStreet(voyageurRue.getText());
            selectedVoyageur.getAddress().setCity(voyageurVille.getText());
            selectedVoyageur.getAddress().setPostalCode(Integer.parseInt(voyageurAdressePostale.getText()));

            // Mettre à jour la destination du voyage seulement si elle est sélectionnée
            if (choiceBox.getValue() != null) {
                selectedVoyageur.setVoyageId(voyageDAO.getVoyageIdByDestination(choiceBox.getValue()));
            } else {
                selectedVoyageur.setVoyageId(0); // Aucun voyage sélectionné
            }

            // Mettre à jour le voyageur dans la base de données
            if (voyageurDAO.update(selectedVoyageur)) {
                alertText.setText("Voyageur mis à jour avec succès.");
                voyageursList.clear();
                voyageursList.addAll(voyageurDAO.selectAll());
                table.refresh();
            } else {
                alertText.setText("Erreur lors de la mise à jour du voyageur.");
            }
        } else {
            alertText.setText("Veuillez sélectionner un voyageur dans la liste.");
        }
    }

    @FXML
    private void cancelButton() {
        voyageurNom.clear();
        voyageurAge.clear();
        voyageurRue.clear();
        voyageurVille.clear();
        voyageurAdressePostale.clear();
        choiceBox.getSelectionModel().clearSelection();
        alertText.setText("");
    }

    @FXML
    private void supprimerButton() {
        Voyageur selectedVoyageur = table.getSelectionModel().getSelectedItem();
        if (selectedVoyageur != null) {
            if (voyageurDAO.delete(selectedVoyageur.getId())) {
                voyageursList.remove(selectedVoyageur);
                alertText.setText("Voyageur supprimé avec succès.");
            } else {
                alertText.setText("Erreur lors de la suppression du voyageur.");
            }
        } else {
            alertText.setText("Veuillez sélectionner un voyageur dans la liste.");
        }
    }

    private void displayVoyageurDetails(Voyageur voyageur) {
        voyageurNom.setText(voyageur.getName());
        voyageurAge.setText(String.valueOf(voyageur.getAge()));
        voyageurRue.setText(voyageur.getAddress().getStreet());
        voyageurVille.setText(voyageur.getAddress().getCity());
        voyageurAdressePostale.setText(String.valueOf(voyageur.getAddress().getPostalCode()));

        // Afficher la destination du voyageur s'il a un voyage associé
        if (voyageur.getVoyage() != null) {
            choiceBox.setValue(voyageur.getVoyage().getDestination());
        } else {
            choiceBox.getSelectionModel().clearSelection();
        }
    }
}
