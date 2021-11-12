/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;
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
import javafx.scene.control.Label;
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

    private ObservableList<String> names = FXCollections.observableArrayList();
    private ObservableList<String> numbers = FXCollections.observableArrayList();
    @FXML
    private Label empryFeild;

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

    }

    @FXML
    private void Search(ActionEvent event) throws IOException {
        if (searchName.getText().equals("")) {
            empryFeild.setText("empty feild detacted");
        } else {
            if (names.contains(searchName.getText())) {
                for (int i = 0; i < names.size(); i++) {
                    System.out.println(names.get(i));
                    if (names.get(i).equalsIgnoreCase(searchName.getText())) {

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FoundWindow.fxml"));
                        Parent root = loader.load();
                        FoundWindowController foundWindow = loader.getController();
                        foundWindow.getInfo(names.get(i), numbers.get(i));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    }
                }
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NotFoundWindow.fxml"));
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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddressBook.fxml"));
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent root = loader.load();
        AddressBookController scene1contr = loader.getController();

        scene1contr.getInfo(names, numbers);

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
