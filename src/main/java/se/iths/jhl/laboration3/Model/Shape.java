package se.iths.jhl.laboration3.Model;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.jhl.laboration3.Command;

import java.util.*;


public abstract class Shape {

    public double xCoordinate, yCoordinate;

    public ObjectProperty<Color> color = new SimpleObjectProperty<>();
    public ObjectProperty<Double> width = new SimpleObjectProperty<>();
    public ObjectProperty<Double> height = new SimpleObjectProperty<>();


    public static ObservableList<Shape> listOfShapeObjects = FXCollections.observableArrayList(param -> new Observable[]{param.colorProperty(), param.heightProperty(), param.widthProperty()});

    public static ObservableList<? extends Shape> getShapes() {
        return listOfShapeObjects;
    }

    public static Deque<Command> undoStack = new ArrayDeque<>();

    public Shape(double size, Color newColor, double xCoordinate, double yCoordinate) {

        color.set(newColor);
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

    public ObjectProperty<Double> widthProperty() {
        return width;
    }

    public ObjectProperty<Double> heightProperty() {
        return height;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public Color getColor() {
        return color.get();
    }

    public static Shape createCircle(double size, Color color, double x, double y) {

        return new Circle(size, color, x, y);
    }

    public static Shape createRectangle(double size, Color color, double x, double y) {
        return new Square(size, color, x, y);

    }
    public void setSize(double width, double height){
        setWidth(width);
        setHeight(height);
    }

    public abstract void drawShape(GraphicsContext context);

    public abstract boolean isSelected(double x, double y);

    public static void alterShape(Double size, MouseEvent mouseEvent, Color color) {
        for (Shape shape : listOfShapeObjects) {
            double xCo = mouseEvent.getX();
            double yCo = mouseEvent.getY();
            if (shape.isSelected(xCo, yCo)) {
                changeSize(size, shape);
                changeColor(color, shape);
            }
        }
    }

    public static void changeSize(Double size, Shape shape) {
        double oldWidth = shape.getWidth();
        double oldHeight = shape.getHeight();
        shape.setWidth(size);
        shape.setHeight(size);
        if(shape.getWidth() == oldWidth && shape.getHeight() == oldHeight)
            return;
        Command undo1 = ()-> shape.setSize(oldWidth, oldHeight);
        undoStack.push(undo1);
    }

    public static void changeColor(Color color, Shape shape) {
        Color oldColor = shape.getColor();
        shape.setColor(color);
        pushColorToUndoStack(shape, oldColor);
    }

    public static void pushColorToUndoStack(Shape shape, Color oldColor) {
        Command undo2 = () -> shape.setColor(oldColor);
        undoStack.push(undo2);
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
