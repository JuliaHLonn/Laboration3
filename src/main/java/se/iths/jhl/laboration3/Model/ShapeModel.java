package se.iths.jhl.laboration3.Model;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;



public class ShapeModel {

    @FXML
    public Circle circle; // Har definierat som klassen cirkle förut vilken extendar shape

    public Rectangle rectangle;

    public Color color;
    public static List<ShapeModel> listOfShapeObjects = new ArrayList<>();


    public ShapeModel(){}
    public ShapeModel(Color color){
        this.color = color;
    }
    public void printList(){
        for (var shape: listOfShapeObjects
        ) {
            System.out.println(shape);

        }
    }


    public void setColor(Color color){
        this.color = color;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public void createCirkleObject(Color color, double radius) {
        listOfShapeObjects.add(new CirkleModel(color, radius));
    }
    public void createRectangleObject(Color color, double x, double y) {
        listOfShapeObjects.add(new RectangleModel(color, x, y));
    }



    public static List<ShapeModel> createListOfShapeObjects() {
        return new ArrayList<>();
    }

}
