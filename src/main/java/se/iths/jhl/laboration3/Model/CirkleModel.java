package se.iths.jhl.laboration3.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CirkleModel extends ShapeModel {


    public double radius;


    public CirkleModel(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    public void setRadius(double newRadius){
        radius = newRadius;
    }
}
