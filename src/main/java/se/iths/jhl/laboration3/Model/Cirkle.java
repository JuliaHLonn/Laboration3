package se.iths.jhl.laboration3.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cirkle extends Shape {





    public Cirkle(Color color, double xCoordinate, double yCoordinate) {
        super(color,xCoordinate,yCoordinate);
        width = 30;
        height = 30;



    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(xCoordinate-(width/2), yCoordinate-(height/2), width, height);
    }


    @Override
    public boolean isSelected(double x, double y) {
        double xRadius = width/2;
        double yRadius = height/2;
        double xCo =  xCoordinate+ xRadius;
        double yCo = yCoordinate + yRadius;
        return ( (yRadius*(x-xCo))*(yRadius*(x-xCo)) + (xRadius*(y-yCo))*(xRadius*(y-yCo)) <= xRadius*xRadius*yRadius*yRadius );
    }

    public String svgString() {
        return "<cirkle xCoordinate= \""+ getXCoordinate() + "\"" + " yCoordinate= \"" + getYCoordinate() + "\"" +
                " width= \"" + getWidth() + "\" height= \"" + getHeight() + "\" fill= \"" + color + "\" />";

    }
}
