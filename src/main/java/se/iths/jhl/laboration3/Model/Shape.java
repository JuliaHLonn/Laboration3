package se.iths.jhl.laboration3.Model;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.*;


public abstract class Shape {

    //public double width, height;
    public double xCoordinate, yCoordinate;

public ObjectProperty<Color> color = new SimpleObjectProperty<>();
public ObjectProperty<Double> width = new SimpleObjectProperty<>();
public ObjectProperty<Double> height = new SimpleObjectProperty<>();
    //public Color color;

    public static ObservableList<Shape> listOfShapeObjects = FXCollections.observableArrayList(param -> new Observable[]{param.colorProperty(), param.heightProperty(), param.widthProperty() });
    //public static List<Shape> listOfShapeObjects = new ArrayList<>();
    public static ObservableList<? extends Shape> getShapes() {
        return listOfShapeObjects;
    }

    static Deque<Command> undoStack = new ArrayDeque<>();

    public Shape(double size, Color newColor, double xCoordinate, double yCoordinate) {

        color.set(newColor);
       // this.width = size;
        //this.height = size;
        width.set(size);
        height.set(size);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public void setWidth(Double width) {
        this.width.set(width);
    }

    public void setHeight(Double height) {
        this.height.set(height);
    }

    public double getWidth() {
        return width.get();
    }

    public double getHeight() {
        return height.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }
    public ObjectProperty<Double> widthProperty() {return width;}
    public ObjectProperty<Double> heightProperty() {return height;}


//    public void changeSize(){
//        if(width == 30 && height == 30)
//            setSize(50, 50);
//        else if (width == 50 && height == 50) {
//            setSize(65, 65);
//        } else if (width ==65 && height == 65) {
//            setSize(30,30);
//        }
//    }


    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public Color getColor() {
        return color.get();
    }

    public static Shape createCirkle(double size, Color color, double x, double y) {

        return new Cirkle(size,color, x, y);
    }

    public static Shape createRectangle(double size, Color color, double x, double y) {
        return new Square(size,color, x, y);

    }

    public abstract void drawShape(GraphicsContext context);

    public abstract boolean isSelected(double x, double y);

    public static void alterShape(Double size, MouseEvent mouseEvent, Color color) {
        for (Shape shape : listOfShapeObjects) {
            double xCo = mouseEvent.getX();
            double yCo = mouseEvent.getY();
            if (shape.isSelected(xCo, yCo)) {
                System.out.println("Found a match");
                shape.setColor(color);
                shape.setWidth(size);
                shape.setHeight(size);

            }
        }
    }

    public abstract String svgString();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, color);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
