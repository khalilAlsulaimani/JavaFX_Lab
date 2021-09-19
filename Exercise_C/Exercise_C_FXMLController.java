/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_C;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author alsul
 */
public class Exercise_C_FXMLController implements Initializable {
    
    private boolean stroke;
    
    @FXML
    private Rectangle Rectangle;
    @FXML
    private ComboBox ComboBox;
    @FXML
    private TextField width;
    @FXML
    private TextField hight;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList<String> list = FXCollections.observableArrayList("RED","GREEN","BLUE","BLACK");
       ComboBox.setItems(list);
    }

    @FXML
    private void MouseClickHandler(MouseEvent event) {
        Rectangle.setWidth(Rectangle.getWidth()+5);
    }

    @FXML
    private void changeWidth(ActionEvent event) {
        double widths = Rectangle.getWidth();
        try{
            widths = Double.parseDouble(width.getText());
            
        }catch(Exception e){
            System.out.println(e);
        }
        Rectangle.setWidth(widths);
    }

    @FXML
    private void changeHight(ActionEvent event) {
        double hights = Rectangle.getArcHeight();
        try{
         hights = Double.parseDouble(hight.getText());
        }catch(Exception e){
            System.out.println(e);
        }
        Rectangle.setHeight(hights);
    }

    @FXML
    private void changeColor(ActionEvent event) {
        Rectangle.setFill(Paint.valueOf(ComboBox.getSelectionModel().getSelectedItem().toString()));
        
    }

    @FXML
    private void stroke(ActionEvent event) {
        stroke = true;
        
    }

    @FXML
    private void stroke1(ActionEvent event) {
        if(stroke){
            Rectangle.setStrokeWidth(1);
        }
        

    }

    @FXML
    private void stroke2(ActionEvent event) {
       if(stroke){
            Rectangle.setStrokeWidth(2);
        }

    }

    @FXML
    private void stroke3(ActionEvent event) {
        if(stroke){
            Rectangle.setStrokeWidth(3);
        }
    }

}
