package se.iths.jhl.laboration3.Controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import se.iths.jhl.laboration3.Model.Rectangle;
import se.iths.jhl.laboration3.Model.ShapeModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class DrawingProgramController {

    public GraphicsContext context;
    @FXML
    public Canvas canvas;


    @FXML
    public RadioButton cirkleButton;

    @FXML
    public RadioButton rectangleButton;

    @FXML
    public RadioButton triangleButton;
    @FXML
    public RadioButton selectModeButton;
    @FXML
    public ColorPicker colorPicker;

    @FXML
    public Button undoButton;

    public ShapeModel shapeModel = new ShapeModel();
    //public Rectangle rectangle = new Rectangle();

    public void initialize() {
        context = canvas.getGraphicsContext2D();

    }

    @FXML
    public void onCanvasClicked(MouseEvent mouseEvent) {

        wichMode(mouseEvent);

        shapeModel.printList();
        changeColor(mouseEvent);
        alterShape(mouseEvent);
    }
    public void handleMouseEvent(MouseEvent mouseEvent){

    }

    public void alterShape(MouseEvent mouseEvent){
        double xCo = mouseEvent.getX();
        double yCo = mouseEvent.getY();
        System.out.println("Is this true? "+ Rectangle.isSelected(xCo,yCo));
        for (Shape shape:shapeModel.listOfShapeObjects
        ) {
            System.out.println(shape.getId());
            //Rectangle.isSelected(shape.getxCoordinate(), shape.getyCoordinate())

        }
    }

    public void tina(){
        for (var shape: ShapeModel.listOfShapeObjects
             ) {
//            System.out.println(shape.getId());
//            if(shape.getId().equals("cirkle")){
//
//            }
//            else if (shape.getId().equals("rectangle")) {
//
//            }
           // Rectangle.isSelected(shape., shape.getyCoordinate())

        }
    }



    private void wichMode(MouseEvent mouseEvent) {
        if(cirkleButton.isSelected())
            drawCirkle(mouseEvent);
        else if (rectangleButton.isSelected())
            drawRectangle(mouseEvent);
        else if (selectModeButton.isSelected()) {
            alterShape(mouseEvent);
        }
    }


    @FXML
    public void drawRectangle(MouseEvent mouseEvent) {
        Color color = colorPicker.getValue();
        shapeModel.createRectangleObject(color, 20, 20, mouseEvent.getX(), mouseEvent.getY());
        context.setFill(colorPicker.getValue());
        context.fillRect(mouseEvent.getX() - 10, mouseEvent.getY() - 10, 20, 20);
    }
@FXML
    public void drawCirkle(MouseEvent mouseEvent) {
        Color color = colorPicker.getValue();
        shapeModel.createCirkleObject(color, 20);
        context.setFill(colorPicker.getValue());
        context.fillOval(mouseEvent.getX() - 10, mouseEvent.getY() - 10, 20, 20);
    }

    public void drawTriangle(MouseEvent mouseEvent){
        Color color = colorPicker.getValue();
        shapeModel.createTriangleObject(new double[]{100,150, 50}, new double[]{100, 150, 150},color);
        context.setFill(colorPicker.getValue());
        context.fillPolygon(new double[]{100,150, 50}, new double[]{100, 150, 150}, 15);
    }
    public void changeColor(MouseEvent mouseEvent) {
        Color color = colorPicker.getValue();
        if(mouseEvent.getSource() == shapeModel.rectangle){
            System.out.println("This is a rectangle");
        }
        System.out.println(mouseEvent.getSource());

    }

    public void undoButtonClicked(){
        undoButton.isCancelButton();
    }

    //Todo: Lägg till Undo funktionen
    // Todo: Lägg till funktion för att ändra storlek
    // Todo: Lägg till funktion för att ändra färg
    // Todo: Hur gör man en triangel??
    // Todo: Har just extendat Shapemodel på Shape, hoppas det fungerar, kolla det


}
