package se.iths.jhl.laboration3.Model;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.lang.reflect.Array;
import java.util.List;

public class Rectangle extends Shape {

    public double sizeX;
    public double sizeY;

    public static double xCoordinate;

    public static double yCoordinate;

    public Color color;

    public int id;


    public Rectangle(Color color, double sizeX, double sizeY, double xCoordinate, double yCoordinate) {
        this.color = color;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        Rectangle.xCoordinate = xCoordinate;
        Rectangle.yCoordinate = yCoordinate;
        this.setId("rectangle");

    }

  /*  public static void ifClicked(List<Shape> list, MouseEvent mouseEvent) {
        String target = String.valueOf(mouseEvent.getSource());
        System.out.println(target + "Det här objektet");
        double xCo = mouseEvent.getX();
        double yCo = mouseEvent.getY();
        //for (int i = 0; i < list.size(); i++) {

        //    if(list.get(i).getX()==xCo){
//                System.out.println("Found the right rectangle!");
//            }
//        }
//        for (Shape object:list) {
//if(object.equals(mouseEvent.getSource()))
//    System.out.println("Found the right Rectangle!");
//        }
        for (Shape object : list) {
            if (object==mouseEvent.getSource())
                System.out.println("Found the right Rectangle!");
        }


    }*/

    public void setSize(double x, double y) {

    }

    public static double getxCoordinate() {
        return xCoordinate;
    }

    public static double getyCoordinate() {
        return yCoordinate;
    }

    public static double[] getPosition(MouseEvent mouseEvent) {
        double[] position = new double[]{mouseEvent.getX(), mouseEvent.getY()};
        return position;


    }

    public static boolean isSelected(double x, double y) {
//        boolean bool = false;
//        double x1 = x - 10;
//        double x2 = x + 10;
//        double y1 = x - 10;
//        double y2 = x + 10;
//        if (x1 < x && x < x2) {
//            if (y1 < y && y < y2)
//                bool = true;
//        }
//        return bool;
       // public static void isSelected(double x, double y) {
            double x1 = xCoordinate - 10;
            double x2 = xCoordinate + 10;
            double y1 = yCoordinate - 10;
            double y2 = yCoordinate + 10;
            return x1 < x && x < x2 && y1 < y && y < y2;


    }



}







