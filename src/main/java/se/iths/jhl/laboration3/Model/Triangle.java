package se.iths.jhl.laboration3.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Triangle extends Polygon{

    public double[] base;
    public double[] height;

    public Color color;


    public Triangle(double[] base, double[] height, Color color){
        this.base = base;
        this.height = height;
        this.color = color;
    }

}
