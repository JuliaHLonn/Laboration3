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

        double rx = getWidth()/2;   // horizontal radius of ellipse
        double ry = getHeight()/2;  // vertical radius of ellipse
        double cx = xCoordinate-(getWidth()/2) + rx;   // x-coord of center of ellipse
        double cy = yCoordinate-(getHeight()/2) + ry;    // y-coord of center of ellipse
        if ( (ry*(x-cx))*(ry*(x-cx)) + (rx*(y-cy))*(rx*(y-cy)) <= rx*rx*ry*ry )
            return true;
        else
            return false;


    }

    public String svgString() {
        String color = "#" + getColor().toString().substring(2, 10);
        return "<cirkle xCoordinate= \""+ getXCoordinate() + "\"" + " yCoordinate= \"" + getYCoordinate() + "\"" +
                " width= \"" + getWidth() + "\" height= \"" + getHeight() + "\" fill= \"" + color + "\" />";

    }
}
