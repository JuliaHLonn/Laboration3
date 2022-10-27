package se.iths.jhl.laboration3.Controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;


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


    @FXML
    public void onCanvasClicked(MouseEvent mouseEvent){
        context = canvas.getGraphicsContext2D();
        if(cirkleButton.isSelected())
            drawCirkle(mouseEvent);
        else if(rectangleButton.isSelected())
            drawRectangle(mouseEvent);


    }

    private void drawRectangle(MouseEvent mouseEvent) {
        context.setFill(colorPicker.getValue());
        context.fillRect(mouseEvent.getX()-10, mouseEvent.getY()-10,20,20);
    }

    private void drawCirkle(MouseEvent mouseEvent) {
        context.setFill(colorPicker.getValue());
        context.fillOval(mouseEvent.getX()-10, mouseEvent.getY()-10,20,20);
    }


}
