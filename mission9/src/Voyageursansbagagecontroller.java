import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class Voyageursansbagagecontroller implements Initializable {
    @FXML
    private TextField Input;
    @FXML
    private Button button;
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
    private TableColumn<AdressePostale, String> adresse;
    ObservableList<Voyageur> data = FXCollections.observableArrayList();
    
    
    /** 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<Voyageur, Long>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Voyageur, String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<Voyageur, Integer>("age"));
        adresse.setCellValueFactory(new PropertyValueFactory<AdressePostale, String>("address"));

        // Fetch and display all voyageurs sans bagage initially
        updateTableWithVoyageursSansBagage();
    }

    
    /** 
     * @param event
     */
    @FXML
    private void handleButtonPress(ActionEvent event) {
        String inputText = Input.getText().trim();

        if (inputText.isEmpty()) {
            // If input is empty, fetch and display all voyageurs sans bagage
            updateTableWithVoyageursSansBagage();
        } else {
            // If input is not empty, perform the search by ID
            long idToSearch;
            try {
                idToSearch = Long.parseLong(inputText);
                alertText.setText("");
            } catch (NumberFormatException e) {
                alertText.setText("Veuillez entrer un ID valide.");
                return;
            }

            VoyageurDAO voyageurDAO = new VoyageurDAO();
            Voyageur voyageur = voyageurDAO.select(idToSearch);

            if (voyageur != null) {
                // Mettre à jour le TableView avec le résultat
                ObservableList<Voyageur> data = FXCollections.observableArrayList(voyageur);
                table.setItems(data);
                alertText.setText("");
            } else {
                // Afficher une alerte si l'ID n'existe pas
                alertText.setText("Aucun voyageur trouvé avec l'ID " + idToSearch);
            }
        }
    }

    private void updateTableWithVoyageursSansBagage() {
        VoyageurDAO voyageurDAO = new VoyageurDAO();
        data.clear();
        data.addAll(voyageurDAO.selectVoyageursSansBagage());
        table.setItems(data);
    }
}
