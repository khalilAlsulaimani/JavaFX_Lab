/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class SearchController2 implements Initializable {

    @FXML
    private TextField searchName;

    private ObservableList<String> names = FXCollections.observableArrayList();
    private ObservableList<String> numbers = FXCollections.observableArrayList();
    @FXML
    private Label empryFeild;
    
    private final PeopleQuries personQuries = new PeopleQuries();
    private ObservableList<People> people = FXCollections.observableArrayList();

    public void getListView(ListView contactNameLists, ListView mobileLists) {

        names.addAll(contactNameLists.getItems().toString().replace("[", "").replace("]", ""));
        numbers.addAll(mobileLists.getItems().toString().replace("[", "").replace("]", ""));
        System.out.println(names.get(0));
        System.out.println(numbers.get(0));

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          List<People> peoples = personQuries.getAllPeople();
        for (int i = 0; i < peoples.size(); i++) {
            people.add(peoples.get(i));
            names.add(people.get(i).fullName() );
            numbers.add(String.valueOf(people.get(i).getPhoneNumber()));

        }

    }

    @FXML
    private void Search(ActionEvent event) throws IOException {
        if (searchName.getText().equals("")) {
            empryFeild.setText("Empty Field Detacted");
        } else {
            if (names.contains(searchName.getText())) {
                for (int i = 0; i < names.size(); i++) {
                    System.out.println(names.get(i));
                    if (names.get(i).equalsIgnoreCase(searchName.getText())) {

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FoundWindow2.fxml"));
                        Parent root = loader.load();
                        FoundWindowController2 foundWindow = loader.getController();
                        foundWindow.getInfo(names.get(i), numbers.get(i));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    }
                }
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NotFoundWindow2.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
        }

    }

    @FXML
    private void back(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddressBook2.fxml"));
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
