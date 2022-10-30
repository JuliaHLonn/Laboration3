package se.iths.jhl.laboration3.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Cirkle extends Shape {


    public double radius;

    public Color color;

    public int id;


    public Cirkle(Color color, double radius) {
        this.color = color;
        this.radius = radius;
        this.setId("cirkle");
    }

    public void setRadius(double newRadius){
        radius = newRadius;
    }
}
