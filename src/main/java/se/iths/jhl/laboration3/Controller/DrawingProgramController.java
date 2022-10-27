package se.iths.jhl.laboration3.Controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.jhl.laboration3.Model.ShapeModel;

import java.util.ArrayList;
import java.util.List;


public class DrawingProgramController {
    @FXML
    public Label welcomeText;

    public GraphicsContext context;
    @FXML
    public Canvas canvas;


    @FXML
    public RadioButton cirkleButton;

    @FXML
    public RadioButton rectangleButton;

    @FXML
    public ColorPicker colorPicker;

    public ShapeModel shapeModel = new ShapeModel();

    public void initialize() {

    }

    @FXML
    public void onCanvasClicked(MouseEvent mouseEvent) {
        context = canvas.getGraphicsContext2D();
        if (cirkleButton.isSelected())
            drawCirkle(mouseEvent);
        else if (rectangleButton.isSelected())
            drawRectangle(mouseEvent);
       shapeModel.printList();
    }

    public void drawRectangle(MouseEvent mouseEvent) {
        Color color = colorPicker.getValue();
        shapeModel.createRectangleObject(color, 20, 20);
        context.setFill(colorPicker.getValue());
        context.fillRect(mouseEvent.getX() - 10, mouseEvent.getY() - 10, 20, 20);
    }

    public void drawCirkle(MouseEvent mouseEvent) {
        Color color = colorPicker.getValue();
        shapeModel.createCirkleObject(color, 20);
        context.setFill(colorPicker.getValue());
        context.fillOval(mouseEvent.getX() - 10, mouseEvent.getY() - 10, 20, 20);
    }

/*public void changeColor(MouseEvent mouseEvent){

    System.out.println(mouseEvent.getSource());

}*/

    //Todo: Lägg till Undo funktionen
    // Todo: Lägg till funktion för att ändra storlek
    // Todo: Lägg till funktion för att ändra färg


}
