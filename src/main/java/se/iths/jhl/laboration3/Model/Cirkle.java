package se.iths.jhl.laboration3.Model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cirkle extends Shape {





    public Cirkle(double size, Color color, double xCoordinate, double yCoordinate) {
        super(size,color,xCoordinate,yCoordinate);




    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(xCoordinate-(getWidth()/2), yCoordinate-(getHeight()/ 2), getWidth(), getHeight());
    }


    @Override
    public boolean isSelected(double x, double y) {

        double areaX = getWidth() - x;
        double areaY = getHeight() - y;
        double distance = Math.sqrt((areaX * areaX) + (areaY * areaY));
        return distance <= getWidth()/2;

    }

    public String svgString() {
        String color = "#" + getColor().toString().substring(2, 10);
        return "<cirkle xCoordinate= \""+ getXCoordinate() + "\"" + " yCoordinate= \"" + getYCoordinate() + "\"" +
                " width= \"" + getWidth() + "\" height= \"" + getHeight() + "\" fill= \"" + color + "\" />";

    }
}
