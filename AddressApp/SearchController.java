/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class SearchController implements Initializable {

    @FXML
    private TextField searchName;
    
   
   @FXML
    private ObservableList<String> names = FXCollections.observableArrayList();
   @FXML
    private ObservableList<String> numbers = FXCollections.observableArrayList();
    
   
    
    
    
    
    public void getListView(ListView contactNameLists, ListView mobileLists){
         
            names.addAll(contactNameLists.getItems().toString());
            numbers.addAll(mobileLists.getItems().toString());
            System.out.println(names.toString());

        
       
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
    }    

    @FXML
    private void Search(ActionEvent event) throws IOException {

        if(names.contains(searchName)){
            for(int i=0;i<names.size();i++){
                if(names.get(i).equals(searchName)){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FoundWindow.fxml"));
                    Parent root = loader.load();
                    FoundWindowController foundWindow = loader.getController();
                    foundWindow.getInfo(names.get(i) , numbers.get(i));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    
                    
                }
            }
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NotFoundWindow.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
            
        }
        
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        
       FXMLLoader loader = new FXMLLoader(getClass().getResource("AddressBook.fxml"));
       ((Node)event.getSource()).getScene().getWindow().hide();
       
        AddressBookController scene1contr = loader.getController();
        
        if((names.isEmpty() & numbers.isEmpty())){
            scene1contr.getInfo(names, numbers);
        }
        
       
        Parent root = loader.load();
       
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
       
    }
    
}
