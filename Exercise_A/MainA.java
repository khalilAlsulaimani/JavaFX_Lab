/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_A;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author alsul
 */
public class MainA extends Application{
     @Override
    public void start(Stage stage) throws Exception {
     Parent root = FXMLLoader.load(getClass().getResource("Exercise_A_FXML.fxml"));
     Scene scene = new Scene(root);
     stage.setTitle("Exercise A");
     stage.setScene(scene);
     stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
        
    }
    
}
