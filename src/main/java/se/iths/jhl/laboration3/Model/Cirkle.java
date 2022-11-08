package se.iths.jhl.laboration3.Model;


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

        double rx = getWidth()/2;
        double ry = getHeight()/2;
        double cx = xCoordinate-(getWidth()/2) + rx;
        double cy = yCoordinate-(getHeight()/2) + ry;
        return (ry * (x - cx)) * (ry * (x - cx)) + (rx * (y - cy)) * (rx * (y - cy)) <= rx * rx * ry * ry;


    }

    public String svgString() {
        String color = "#" + getColor().toString().substring(2, 10);
        double coordinateX = xCoordinate-(getWidth()/2);
        double coordinateY = yCoordinate-(getHeight()/2);
        return "<cirkle xCoordinate= \""+ coordinateX + "\"" + " yCoordinate= \"" + coordinateY + "\"" +
                " width= \"" + getWidth() + "\" height= \"" + getHeight() + "\" fill= \"" + color + "\" />";

    }
}
