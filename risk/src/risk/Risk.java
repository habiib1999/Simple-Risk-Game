
package risk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ABD-ELRAHMAN
 */
public class Risk extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // Initially Start first scene which will be the intro scene
        Parent root = FXMLLoader.load(getClass().getResource("intro.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
