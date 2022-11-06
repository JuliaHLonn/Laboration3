package se.iths.jhl.laboration3.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Rectangle extends Shape {


    public Rectangle(Color color, double xCoordinate, double yCoordinate) {
        super(color, xCoordinate, yCoordinate);

    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(xCoordinate - (width / 2), yCoordinate - (height / 2), width, height);
    }

    public boolean isSelected(double x, double y) {

        double x1 = xCoordinate - 11;
        double x2 = xCoordinate + 11;
        double y1 = yCoordinate - 11;
        double y2 = yCoordinate + 11;
        return x1 < x && x < x2 && y1 < y && y < y2;

    }

    @Override
    public String svgString() {
        return "<rect xCoordinate= \""+ getXCoordinate() + "\"" + " yCoordinate= \"" + getYCoordinate() + "\"" +
                " width= \"" + getWidth() + "\" height= \"" + getHeight() + "\" fill= \"" + color + "\" />";

    }
}







