/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_B;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class Exercise_B_FXMLController implements Initializable {

    @FXML
    private Rectangle square = new Rectangle();
    @FXML
    private Rectangle rectangle = new Rectangle();
    @FXML
    private Circle circle = new Circle();

    @FXML
    private Pane Pane;
    @FXML
    private ComboBox ShapeChoice;
    @FXML
    private TextField strokeWidth;
    @FXML
    private CheckBox backgroundColor;
    @FXML
    private ToggleGroup color;

    public String checkShape() {
        String shapes = ShapeChoice.getSelectionModel().getSelectedItem().toString();

        return shapes;

    }

    public void changeStroke(String shape, double stroke) {
        switch (shape) {
            case "Square":
                square.setStrokeWidth(stroke);
                break;
            case "Circle":
                circle.setStrokeWidth(stroke);
                break;
            case "Rectangle":
                rectangle.setStrokeWidth(stroke);
        }
    }

    public void changeColor(String shape, String color) {
        Paint paint = Paint.valueOf(color);
        switch (shape) {
            case "Square":
                square.setFill(paint);
                break;
            case "Circle":
                circle.setFill(paint);
                break;
            case "Rectangle":
                rectangle.setFill(paint);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Circle", "Square", "Rectangle");
        ShapeChoice.setItems(list);
        ShapeChoice.getSelectionModel().selectFirst();

        Pane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                changeColor("Square", "black");
                changeColor("Circle", "black");
                changeColor("Rectangle", "black");
            }

        });

    }

    @FXML
    private void colorBlue(ActionEvent event) {
        changeColor(checkShape(), "blue");
    }

    @FXML
    private void ColorGreen(ActionEvent event) {
        changeColor(checkShape(), "green");
    }

    @FXML
    private void colorRed(ActionEvent event) {
        changeColor(checkShape(), "red");

    }

    @FXML
    private void strokeWidth(ActionEvent event) {
        changeStroke(checkShape(),Double.parseDouble(strokeWidth.getText().toString()));
    }
        
    
    

    @FXML
    private void backgroundColor(ActionEvent event) {
       if(backgroundColor.isSelected()){
           Pane.setBackground(new Background(new BackgroundFill(Paint.valueOf("yellow"), CornerRadii.EMPTY, Insets.EMPTY)));
       }else{
           Pane.setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), CornerRadii.EMPTY, Insets.EMPTY)));
       }
               

    }

   
}
    
