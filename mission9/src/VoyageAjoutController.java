import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.time.LocalDate;

public class VoyageAjoutController {
    @FXML
    private TextField destinationField;
    @FXML
    private DatePicker dateDepartPicker;
    @FXML
    private DatePicker dateRetourPicker;
    @FXML
    private TextField descriptionField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button confirmButton;
    @FXML
    private Text alertText;
    

    public void clearFields() {
        destinationField.setText("");
        dateDepartPicker.setValue(null);
        dateRetourPicker.setValue(null);
        descriptionField.setText("");
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
        if (destinationField.getText().isEmpty() || dateDepartPicker.getValue() == null ||
                dateRetourPicker.getValue() == null || descriptionField.getText().isEmpty()) {
            alertText.setStyle("-fx-fill: red");
            alertText.setText("Veuillez remplir tous les champs");
            return;
        }

        // Créer un objet Voyage avec les valeurs des champs
        String destination = destinationField.getText();
        LocalDate dateDepart = dateDepartPicker.getValue();
        LocalDate dateRetour = dateRetourPicker.getValue();
        String description = descriptionField.getText();
        Voyage nouveauVoyage = new Voyage(destination, dateDepart, dateRetour, description);

        // Insérer le nouveau voyage dans la base de données
        VoyageDAO voyageDAO = new VoyageDAO();
        voyageDAO.insert(nouveauVoyage);

        // Afficher un message de confirmation
        alertText.setStyle("-fx-fill: green");
        alertText.setText("Voyage ajouté avec succès");

        // Effacer les champs
        clearFields();
    }
}
