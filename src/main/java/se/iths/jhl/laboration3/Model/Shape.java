package se.iths.jhl.laboration3.Model;

import javafx.scene.paint.Color;


public abstract class Shape {

    public Color color;

    public void changeColor(Color color){};

    public abstract boolean isSelected(double x, double y);
}
