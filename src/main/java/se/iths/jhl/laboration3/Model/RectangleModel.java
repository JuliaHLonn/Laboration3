package se.iths.jhl.laboration3.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleModel extends ShapeModel{

    public double sizeX;
    public double sizeY;


    public RectangleModel(Color color, double x, double y) {
        super(color);
        this.sizeX = x;
        this.sizeY = y;

    }



    public void setSize(double x, double y) {

    }


}
