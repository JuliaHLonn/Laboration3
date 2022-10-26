package se.iths.jhl.laboration3.Controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class DrawingProgramController {
    @FXML
    public Label welcomeText;

    public GraphicsContext context;
    @FXML
    public Canvas canvas;

    @FXML
    public Circle circle; // Har definierat som klassen cirkle förut vilken extendar shape

    public Rectangle rectangle;


    public void onRectangleClicked(MouseEvent mouseEvent) {
        context = canvas.getGraphicsContext2D();
        context.setFill(Color.web("C8DBBE"));

        double xPosition = mouseEvent.getSceneX();
        double yPosition = mouseEvent.getSceneY();
        createShape(context, xPosition,yPosition); // Storleken sist
    }

    private void createShape(GraphicsContext context, double x, double y) {
        context.fillRect(x,y,20,20);
    }


    @FXML
    public void drawCirkle(MouseEvent mouseEvent) {
        context.setFill(Color.web("C8DBBE"));
       // context.fillOval(mouseEvent.getScreenX(), mouseEvent.getScreenY(), 10,10);
        mouseEvent.clone();
    }

    @FXML
    public void drawRectangle(MouseEvent mouseEvent) {
       // double xPosition = mouseEvent.getScreenX();
        context.setFill(Color.web("C8DBBE"));
        context.fillRect(mouseEvent.getSceneX(), mouseEvent.getSceneY(), 0,0);

    }

    public void getClickPosition() {

    }


}
