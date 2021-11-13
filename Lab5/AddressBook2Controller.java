/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.sql.ResultSet;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class AddressBook2Controller implements Initializable {

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
    @FXML
    private Label emptyFeildMessgae;
    @FXML
    private Label alreadyAdded;
    @FXML
    private Label invalidNumber;

    private final PeopleQuries personQuries = new PeopleQuries();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }

    @FXML
    private void addEntry() {
        emptyFeildMessgae.setText("");
        invalidNumber.setText("");
        alreadyAdded.setText("");

        if (firstName.getText().equals("") || lastName.getText().equals("") || mobileNumber.getText().equals("")) {
            emptyFeildMessgae.setText("empty textfeild detected ");

        } else if (mobileNumber.getText().length() + 1 != 10) {
            invalidNumber.setText("invalid number , number of digits must be 10");

        } else if (personQuries.isInDB(Integer.parseInt(mobileNumber.getText()))) {
            alreadyAdded.setText("invalid contact already added into list");
        } else {
            personQuries.addPeople(firstName.getText(), lastName.getText(), Integer.parseInt(mobileNumber.getText()));
            

        }

    }

    @FXML
    private void deleteEntry(ActionEvent event) {
        int contactIndex = ContactNameList.getSelectionModel().getSelectedIndex();
        int NumberIndex = mobileList.getSelectionModel().getSelectedIndex();

        if (contactIndex > -1 && NumberIndex > -1) {
            ContactNameList.getItems().remove(contactIndex);
            mobileList.getItems().remove(NumberIndex);
        }

    }

    @FXML
    private void search(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Search.fxml"));
        ((Node) event.getSource()).getScene().getWindow().hide();

        Parent root = loader.load();
        SearchController scene2contr = loader.getController();
        scene2contr.getListView(ContactNameList, mobileList);

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

  
}
