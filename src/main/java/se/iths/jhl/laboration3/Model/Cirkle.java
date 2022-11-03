package se.iths.jhl.laboration3.Model;

import javafx.scene.paint.Color;

public class Cirkle extends Shape {


    public double radius;

    public Color color;

    public int id;


    public Cirkle(Color color, double radius) {
        this.color = color;
        this.radius = radius;

    }



    public void setRadius(double newRadius){
        radius = newRadius;
    }

    @Override
    public boolean isSelected(double x, double y) {
        return false;
    }
}
