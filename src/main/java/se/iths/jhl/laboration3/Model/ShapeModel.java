package se.iths.jhl.laboration3.Model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;


public class ShapeModel {

    @FXML
    public Circle circle; // Har definierat som klassen cirkle förut vilken extendar shape

    public javafx.scene.shape.Rectangle rectangle;

    //public Color color;
    public static List<Shape> listOfShapeObjects = new ArrayList<>();


    public ShapeModel() {
    }

    // public ShapeModel(Color color){this.color = color;}
    public void printList() {
        for (var shape : listOfShapeObjects
        ) {
            System.out.println(shape);

        }
    }


    // public void setColor(Color color){this.color = color;}

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
        listOfShapeObjects.add(new Cirkle(color, radius));
    }

    public void createRectangleObject(Color color, double x, double y, double xCoordinate, double yCoordinate) {
        listOfShapeObjects.add(new Rectangle(color, x, y, xCoordinate, yCoordinate));
    }

    public void createTriangleObject(double[] base, double[] height, Color color) {
        //  listOfShapeObjects.add(new Triangle(base,height, color));
    }


    public static List<ShapeModel> createListOfShapeObjects() {
        return new ArrayList<>();
    }

}
