package se.iths.jhl.laboration3.Model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cirkle extends Shape {





    public Cirkle(Color color, double xCoordinate, double yCoordinate) {
        super(color,xCoordinate,yCoordinate);




    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(xCoordinate-(width/2), yCoordinate-(height/2), width, height);
    }


    @Override
    public boolean isSelected(double x, double y) {
//        double xRadius = width/2;
//        double yRadius = height/2;
//        double xCo =  xCoordinate+ xRadius;
//        double yCo = yCoordinate + yRadius;
//        return ( (yRadius*(x-xCo))*(yRadius*(x-xCo)) + (xRadius*(y-yCo))*(xRadius*(y-yCo)) <= xRadius*xRadius*yRadius*yRadius );
//        double xRadius = width/2;
//        double yRadius = height/2;
//        double xCo =  xCoordinate+ xRadius;
//        double yCo = yCoordinate + yRadius;
//        return ( (yRadius*(x-xCo))*(yRadius*(x-xCo)) + (xRadius*(y-yCo))*(xRadius*(y-yCo)) <= xRadius*xRadius*yRadius*yRadius );
        double areaX = x - getWidth();
        double areaY = y - getHeight();
        double distance = Math.sqrt((areaX * areaX) + (areaY * areaY));
        return distance <= getWidth()/2;



    }

    public String svgString() {
        String color = "#" + getColor().toString().substring(2, 10);
        return "<cirkle xCoordinate= \""+ getXCoordinate() + "\"" + " yCoordinate= \"" + getYCoordinate() + "\"" +
                " width= \"" + getWidth() + "\" height= \"" + getHeight() + "\" fill= \"" + color + "\" />";

    }
}
