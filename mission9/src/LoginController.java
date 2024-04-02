import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Text loginMessageText;

    private final LoginDAO loginDAO;

    public LoginController() {
        loginDAO = new LoginDAO();
    }

    
    /** 
     * @param event
     */
    @FXML
    private void loginButtonOnAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
        String encryptPassword = encrypt(password);
        System.out.println("Password : " + encryptPassword);
        if (loginDAO.checkLogin(username, encryptPassword)) {
            // Si l'authentification est réussie, charger une nouvelle scène
            try {
                Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
                Scene scene = new Scene(root, 600, 400);
                
                // Obtenir la référence à la fenêtre actuelle
                Stage stage = (Stage) loginButton.getScene().getWindow();
                
                // Changer la scène actuelle avec la nouvelle scène
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Afficher un message d'erreur si l'authentification échoue
            loginMessageText.setText("Identifiant ou mot de passe incorrect");
        }
    }

    
    /** 
     * @param input
     * @return String
     */
    public String encrypt(String input) {
        String crypte = "";
        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i) ^ 48; // Effectuer une opération XOR avec 48
            crypte += (char) c; // Ajouter le caractère crypté à la chaîne cryptée
        }
        return crypte;
    }

    
    /** 
     * @param event
     */
    @FXML
    private void cancelButtonOnAction(ActionEvent event) {
        // Effacer les champs de saisie et le message d'erreur
        usernameTextField.clear();
        passwordPasswordField.clear();
        loginMessageText.setText("");
    }
}
