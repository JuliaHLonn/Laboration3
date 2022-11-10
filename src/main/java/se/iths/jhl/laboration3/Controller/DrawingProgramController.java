package se.iths.jhl.laboration3.Controller;

import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import se.iths.jhl.laboration3.Command;
import se.iths.jhl.laboration3.Model.*;

import java.io.File;



public class DrawingProgramController {

    public static GraphicsContext context;
    @FXML
    public Canvas canvas;

    @FXML
    Label welcomeLabel;

    @FXML
    public RadioButton circleButton;

    @FXML
    public RadioButton rectangleButton;

    @FXML
    public RadioButton selectModeButton;
    @FXML
    public ColorPicker colorPicker;

    @FXML
    public Button undoButton;

    @FXML
    Button saveButton;

    @FXML
    public TextField pickSize;


    public Stage stage;

    public SaveSVG saveSVG = new SaveSVG();

    Command undo;
    Command undoToExecute;


    public void initialize() {
        context = canvas.getGraphicsContext2D();
        rectangleButton.setSelected(true);
        Shape.getShapes().addListener(this::listChanged);
        setWelcomeLabel();
    }

    @FXML
    public void onCanvasClicked(MouseEvent mouseEvent) {
        double size = Double.parseDouble(pickSize.getText());
        if (selectModeButton.isSelected()) {
            Shape.alterShape(size, mouseEvent, colorPicker.getValue());
            return;
        }

            Shape.listOfShapeObjects.add(wichMode(mouseEvent));
            pushAddToUndoStack();

    }

    private void pushAddToUndoStack() {
        undo = () -> Shape.listOfShapeObjects.remove(Shape.listOfShapeObjects.size() - 1);
        Shape.undoStack.push(undo);
    }

    @FXML
    public void undoButtonClicked() {
        undoToExecute = Shape.undoStack.pop();
        undoToExecute.execute();

    }

    private void listChanged(Observable observable) {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Shape shape : Shape.getShapes()) {
            shape.drawShape(context);
        }
    }


    private Shape wichMode(MouseEvent mouseEvent) {
        double size = Double.parseDouble(pickSize.getText());
        if (circleButton.isSelected())
            return Shape.createCircle(size, colorPicker.getValue(), mouseEvent.getX(), mouseEvent.getY());
        else
            return Shape.createRectangle(size, colorPicker.getValue(), mouseEvent.getX(), mouseEvent.getY());
    }

    public void setWelcomeLabel(){
        welcomeLabel.setText("Welcome to draw! Choose color and size above and create your masterpiece by clicking on the canvas");

    }


    public void onSaveAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG", "*.svg"));
        fileChooser.setInitialFileName("yourShapes");
        File filePath = fileChooser.showSaveDialog(stage);

        if (filePath != null) {
            saveSVG.saveToFile(filePath.toPath());
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


}
