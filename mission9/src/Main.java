import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
    
    /** 
     * @param args[]
     */
    public static void main(String args[]) {
        launch(args);
    }

    
    /** 
     * @param panel
     * @throws Exception
     */
    @Override
    public void start(Stage panel) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root, 600, 400);
        panel.setTitle("EasyLine");
        panel.setScene(scene);
        panel.show();
    }
}
