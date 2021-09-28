/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class AddressBookController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField mobileNumber;
    @FXML
    private ListView<String> ContactNameList;
    @FXML
    private ListView<String> mobileList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void getInfo(ObservableList ContactNameLists ,ObservableList mobileLists ){
        for(int i =0;i<ContactNameLists.size();i++){
            ContactNameList.getItems().add( ContactNameLists.get(i).toString() );
        }
             System.out.print(mobileLists.toString());
        for(int i =0;i<ContactNameLists.size();i++){
            mobileList.getItems().add(mobileLists.get(i).toString());
           
        }
               
    }

    @FXML
    private void addEntry() {
        String fullName = firstName.getText() +" "+ lastName.getText();
        ContactNameList.getItems().add(fullName);
        mobileList.getItems().add(mobileNumber.getText());
    }

    @FXML
    private void deleteEntry(ActionEvent event) {
        ContactNameList.getSelectionModel().clearSelection();
        mobileList.getSelectionModel().clearSelection();
    }

    @FXML
    private void search(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Search.fxml"));
        ((Node)event.getSource()).getScene().getWindow().hide();
        
        Parent root = loader.load();
        SearchController scene2contr = loader.getController();
        scene2contr.getListView(ContactNameList,mobileList);
        
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
}
