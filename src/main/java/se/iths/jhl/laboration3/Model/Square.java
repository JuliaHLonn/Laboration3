package se.iths.jhl.laboration3.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {


    public Square(Color color, double xCoordinate, double yCoordinate) {
        super(color, xCoordinate, yCoordinate);

    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(xCoordinate - (width / 2), yCoordinate - (height / 2), width, height);
    }

    public boolean isSelected(double x, double y) {

        double x1 = xCoordinate - width/2;
        double x2 = xCoordinate + width/2;
        double y1 = yCoordinate - height/2;
        double y2 = yCoordinate + height/2;
        return x1 < x && x < x2 && y1 < y && y < y2;

    }

    @Override
    public String svgString() {
        String color = "#" + getColor().toString().substring(2, 10);
        return "<rect xCoordinate= \""+ getXCoordinate() + "\"" + " yCoordinate= \"" + getYCoordinate() + "\"" +
                " width= \"" + getWidth() + "\" height= \"" + getHeight() + "\" fill= \"" + color + "\" />";

    }
}







