
package risk;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ABD-ELRAHMAN
 */
public class IntroController implements Initializable {
   @FXML
   ImageView background;
   @FXML
   ImageView playbutton;
   
     @FXML
    private void changeButtonStyle(){
        playbutton.setImage(new Image(getClass().getResource("/assets2/button2.png").toString()));
       
    }
      @FXML
    private void returnButtonStyle(){
        playbutton.setImage(new Image(getClass().getResource("/assets2/button1.png").toString()));
       
    }
     @FXML
    private void switchScene() throws IOException{
        Parent mapRoot = FXMLLoader.load(getClass().getResource("map.fxml"));        
        Scene scene = new Scene(mapRoot); 
        Stage stage = (Stage) playbutton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setBackGround();
        
    }
    
    public void setBackGround(){
    background.setImage(new Image(getClass().getResource("/assets2/intro.png").toString()));
    playbutton.setImage(new Image(getClass().getResource("/assets2/button1.png").toString()));
    }
    
}
