/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_A;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class Exercise_A_FXMLController implements Initializable {
    
    private double raduis;

    @FXML
    private Pane drawingPane;
    @FXML
    private TextField YPostion;
    @FXML
    private TextField Xpostion;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Slider radiusSlider;
    
    private Circle circle(double x,double y,double radius){
        Circle circle = new Circle();
        try{
            circle.setCenterX(x);
            circle.setCenterY(y);
            circle.setRadius(raduis);
        }catch (Exception e){
            System.err.println(e);
        }
        return circle;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radiusSlider.valueProperty().addListener(new ChangeListener<Number> (){
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                raduis =  radiusSlider.getValue();
            }
            
        }
        );
        
        ObservableList<String> list = FXCollections.observableArrayList("White","Gray","Blue");
        comboBox.setItems(list);
        
    }    

    @FXML
    private void drawCircleOnClick(MouseEvent event) {
        Circle circle = circle(event.getX(),event.getY(),20);
        drawingPane.getChildren().add(circle);
    }

    @FXML
    private void draw(ActionEvent event) {
        Circle circle = circle(Double.parseDouble(Xpostion.getText()),Double.parseDouble(YPostion.getText()),raduis);
        drawingPane.getChildren().add(circle);
        
        
    }

    @FXML
    private void clear(ActionEvent event) {
        drawingPane.getChildren().clear();
    }

    @FXML
    
    private void backgroundColor(ActionEvent event) {
        Paint paint = Paint.valueOf(comboBox.getSelectionModel().getSelectedItem().toString());
        drawingPane.setBackground(new Background(new BackgroundFill(paint,CornerRadii.EMPTY ,Insets.EMPTY)));
        
    }
       
    
}
