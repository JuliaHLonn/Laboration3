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

    public int width, height;
    public double xCoordinate, yCoordinate;

public ObjectProperty<Color> color = new SimpleObjectProperty<>();
    //public Color color;

    public static ObservableList<Shape> listOfShapeObjects = FXCollections.observableArrayList(param -> new Observable[]{param.colorProperty() });
    //public static List<Shape> listOfShapeObjects = new ArrayList<>();

    static Deque<Command> undoStack = new ArrayDeque<>();

    public Shape(Color newColor, double xCoordinate, double yCoordinate) {

        color.set(newColor);
        this.width = 30;
        this.height = 20;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    ;

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
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

    public static Shape createCirkle(Color color, double x, double y) {
        return new Cirkle(color, x, y);
    }

    public static Shape createRectangle(Color color, double x, double y) {
        return new Rectangle(color, x, y);

    }

    public abstract void drawShape(GraphicsContext context);

    public abstract boolean isSelected(double x, double y);

    public static void alterShape(MouseEvent mouseEvent, Color color) {
        for (Shape shape : listOfShapeObjects) {
            double xCo = mouseEvent.getX();
            double yCo = mouseEvent.getY();
            if (shape.isSelected(xCo, yCo) || shape.isSelected(xCo, yCo)) {
                System.out.println("Found a match");
                shape.setColor(color);
                System.out.println(shape.getColor());
            }
        }
    }

    public abstract String svgString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.height, height) == 0 && color.equals(rectangle.color);
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
