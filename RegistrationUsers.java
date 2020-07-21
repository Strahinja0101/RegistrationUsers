package registrationusers;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Strahinja
 */
public class RegistrationUsers extends Application {
    
     public static void main(String[] args) {
        launch(args);
    }
     
   @Override
    public void start(Stage stage) throws Exception {
       
        URL fxml = getClass().getClassLoader().getResource("view/SalesView.fxml");//referenca na fxml
        GridPane root = FXMLLoader.<GridPane>load(fxml);
        Scene scene = new Scene (root);
        scene.getStylesheets().add("view/salesview.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    
 }


