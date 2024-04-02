import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.util.List;

public class VoyageurAjoutController {
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
    private Button cancelButton;
    @FXML
    private Button confirmButton;
    @FXML
    private ChoiceBox<String> choiceBox; // Ajout de la ChoiceBox pour la sélection du voyage
    @FXML
    private Text alertText;

    private VoyageDAO voyageDAO; // Ajout de l'instance de VoyageDAO

    public void initialize() {
        voyageDAO = new VoyageDAO();
        // Charger les destinations disponibles dans la ChoiceBox au démarrage de l'application
        choiceBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String destination) {
                return destination != null ? destination : "";
            }

            @Override
            public String fromString(String string) {
                throw new UnsupportedOperationException("Conversion from String to Destination not supported.");
            }
        });
        List<String> destinations = voyageDAO.getAllDestinations();
        if (destinations != null) {
            choiceBox.getItems().addAll(destinations);
        }
    }

    public void clearFields() {
        voyageurNom.setText("");
        voyageurAge.setText("");
        voyageurRue.setText("");
        voyageurVille.setText("");
        voyageurAdressePostale.setText("");
        choiceBox.setValue(null);
    }

    
    /** 
     * @param event
     */
    public void cancelButton(ActionEvent event) {
        clearFields();
    }

    
    /** 
     * @param event
     */
    public void confirmButton(ActionEvent event) {
        // Vérifier si tous les champs sont remplis
        if (voyageurNom.getText().isEmpty() || voyageurAge.getText().isEmpty() || voyageurRue.getText().isEmpty()
                || voyageurVille.getText().isEmpty() || voyageurAdressePostale.getText().isEmpty()) {
            alertText.setStyle("-fx-fill: red");
            alertText.setText("Veuillez remplir tous les champs");
            return;
        }

        // Vérifier si l'âge est un nombre entier
        try {
            Integer.parseInt(voyageurAge.getText());
        } catch (NumberFormatException e) {
            alertText.setStyle("-fx-fill: red");
            alertText.setText("L'âge doit être un nombre entier");
            return;
        }

        String selectedDestination = choiceBox.getValue();
        if (selectedDestination == null || selectedDestination.isEmpty()) {
            alertText.setStyle("-fx-fill: red");
            alertText.setText("Veuillez sélectionner une destination");
            return;
        }

        Voyageur v = new Voyageur(voyageurNom.getText(), Integer.parseInt(voyageurAge.getText()));
        AdressePostale a = new AdressePostale(voyageurRue.getText(), voyageurVille.getText(),
                Integer.parseInt(voyageurAdressePostale.getText()));

        // Utiliser l'ID du voyage sélectionné lors de l'insertion du voyageur
        int voyageId = voyageDAO.getVoyageIdByDestination(selectedDestination);
        if (voyageId == -1) {
            alertText.setStyle("-fx-fill: red");
            alertText.setText("Voyage non trouvé pour la destination sélectionnée");
            return;
        }

        VoyageurDAO vDao = new VoyageurDAO();
        vDao.insertVoyageurWithAdresse(v, a, voyageId);

        alertText.setStyle("-fx-fill: green");
        alertText.setText("Voyageur bien ajouté");

        clearFields();
    }
}
