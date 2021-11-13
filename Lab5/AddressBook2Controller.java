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

    private ObservableList<People> people = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<People> peoples = personQuries.getAllPeople();
        for (int i = 0; i < peoples.size(); i++) {
            people.add(peoples.get(i));
            ContactNameList.getItems().add(peoples.get(i).fullName());
            mobileList.getItems().add(String.valueOf(peoples.get(i).getPhoneNumber()));

        }
    }

    @FXML
    private void addEntry() {
        String fullName = firstName.getText() + " " + lastName.getText();
        emptyFeildMessgae.setText("");
        invalidNumber.setText("");
        alreadyAdded.setText("");
        if (firstName.getText().equals("") || lastName.getText().equals("") || mobileNumber.getText().equals("")) {
            emptyFeildMessgae.setText("Empty Textfeild Detected ");

        } else if (mobileNumber.getText().length() != 10) {
            invalidNumber.setText("Invalid Number , Number Of Digits Must Be 10");

        } else if (personQuries.isInDB(Integer.parseInt(mobileNumber.getText()))) {
            alreadyAdded.setText("Invalid Contact Already Added Into List");
        } else {
            personQuries.addPeople(firstName.getText(), lastName.getText(), Integer.parseInt(mobileNumber.getText()));
            ContactNameList.getItems().add(fullName);
            mobileList.getItems().add(mobileNumber.getText());

        }

    }

    @FXML
    private void deleteEntry(ActionEvent event) {
        int contactIndex = ContactNameList.getSelectionModel().getSelectedIndex();
        int NumberIndex = mobileList.getSelectionModel().getSelectedIndex();

        if (contactIndex > -1 && NumberIndex > -1) {
            ContactNameList.getItems().remove(contactIndex);

            personQuries.deletePeople(Integer.parseInt(mobileList.getItems().get(NumberIndex)));
            mobileList.getItems().remove(NumberIndex);
        }

    }

    @FXML
    private void search(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Search2.fxml"));
        ((Node) event.getSource()).getScene().getWindow().hide();

        Parent root = loader.load();
        

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
