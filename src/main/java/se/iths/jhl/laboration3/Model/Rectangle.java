package se.iths.jhl.laboration3.Model;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Rectangle extends Shape {

    public double sizeX;
    public double sizeY;

    public double xCoordinate;

    public double yCoordinate;

    public Color color;


    //public ShapeModel shapeModel = new ShapeModel();






    public Rectangle(Color color, double sizeX, double sizeY, double xCoordinate, double yCoordinate) {

        this.color = color;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;


    }

    public Rectangle(){};

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
  /*public void drawRectangle(MouseEvent mouseEvent) {
      Color color = DrawingProgramController.colorPicker.getValue();
      double size = Double.parseDouble(DrawingProgramController.pickSize.getText());
      shapeModel.createRectangleObject(color, size, size, mouseEvent.getX(), mouseEvent.getY());
      DrawingProgramController.context.setFill(color);
      DrawingProgramController.context.fillRect(mouseEvent.getX() - 10, mouseEvent.getY() - 10, size, size);
  }*/


    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void changeColor(Color color){
        this.color = color;
    }


    public static double[] getPosition(MouseEvent mouseEvent) {
        double[] position = new double[]{mouseEvent.getX(), mouseEvent.getY()};
        return position;


    }

    public boolean isSelected(double x, double y) {

            double x1 = xCoordinate - 11;
            double x2 = xCoordinate + 11;
            double y1 = yCoordinate - 11;
            double y2 = yCoordinate + 11;
            return x1 < x && x < x2 && y1 < y && y < y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return Double.compare(rectangle.sizeX, sizeX) == 0 && Double.compare(rectangle.sizeY, sizeY) == 0 && color.equals(rectangle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeX, sizeY, color);
    }


}







