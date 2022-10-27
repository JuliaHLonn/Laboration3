package se.iths.jhl.laboration3.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleModel extends ShapeModel{

    public Color color;


    public RectangleModel(Color color) {
        this.color = color;

    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setSize(double x, double y) {

    }


}
