package se.iths.jhl.laboration3.Controller;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import se.iths.jhl.laboration3.Model.*;

import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DrawingProgramController {

    public static GraphicsContext context;
    @FXML
    public Canvas canvas;


    @FXML
    public RadioButton cirkleButton;

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

    public ShapeModel shapeModel = new ShapeModel();
    String name = "shape";
    int number = 0;

    public void initialize() {
        context = canvas.getGraphicsContext2D();
        rectangleButton.setSelected(true);
        Shape.getShapes().addListener(this::listChanged);

    }

    @FXML
    public void onCanvasClicked(MouseEvent mouseEvent) {

        if (selectModeButton.isSelected()) {
            Shape.alterShape(mouseEvent, colorPicker.getValue());
            return;
        }

            Shape.listOfShapeObjects.add(wichMode(mouseEvent));

    }

    private void listChanged(Observable observable) {
        var context = canvas.getGraphicsContext2D();
        for (Shape shape : Shape.getShapes()) {
            shape.drawShape(context);
        }
    }


   /* @FXML
    public void setSize(ActionEvent event) {
        String chosenSize = choiceBox.getValue();
        sizeSide = 0;

        if (chosenSize.equals("Small"))
            sizeSide = 20;
        else if (chosenSize.equals("Medium"))
            sizeSide = 40;
        else if (chosenSize.equals("Large"))
            sizeSide = 60;

    }*/


   /* public void alterShape(MouseEvent mouseEvent) {
        for (Shape shape : Shape.listOfShapeObjects) {
            double xCo = mouseEvent.getX();
            double yCo = mouseEvent.getY();
            if (shape.isSelected(xCo, yCo)) {
                System.out.println("Found a match");*/
                /*double size = Double.parseDouble(pickSize.getText());
               Rectangle rectangle = new Rectangle(colorPicker.getValue(), size, size, mouseEvent.getX()-10, mouseEvent.getY()-10);
               context.setFill(colorPicker.getValue());
               context.fillRect(mouseEvent.getX()-10, mouseEvent.getY() - 10, size, size);*/
    // }
// Får nog sätta den i en till loop så att den inte bara tar sista musklicket
    //}
        /*for (int i = 0; i < ShapeModel.listOfShapeObjects.size(); i++) {
            double xCo = mouseEvent.getX();
            double yCo = mouseEvent.getY();

            if (Rectangle.isSelected(xCo, yCo)) {
                System.out.println("Found a match");
                //double x = ShapeModel.listOfShapeObjects.get(i).xCoordinate;
                ShapeModel.listOfShapeObjects.get(i).changeColor(colorPicker.getValue());
            }
        }*/
    // }


    private Shape wichMode(MouseEvent mouseEvent) {
        String nameOf = shapeName(name);
        if (cirkleButton.isSelected())
            return Shape.createCirkle(colorPicker.getValue(), mouseEvent.getX(), mouseEvent.getY());
        else
            return Shape.createRectangle(colorPicker.getValue(), mouseEvent.getX(), mouseEvent.getY());
    }

    public String shapeName(String name){
        number = number +1;
        return name+number;
    }


  /* @FXML
    public void drawShape(GraphicsContext context) {
        Color color = colorPicker.getValue();
        double size = Double.parseDouble(pickSize.getText());
        shapeModel.createRectangleObject(color, mouseEvent.getX(), mouseEvent.getY());

        context.setFill(color);
        context.fillRect(mouseEvent.getX() - 10, mouseEvent.getY() - 10, size, size);
    }

    @FXML
    public void drawCirkle(MouseEvent mouseEvent) {
        Color color = colorPicker.getValue();
        double size = Double.parseDouble(pickSize.getText());
        shapeModel.createCirkleObject(color, size);
        context.setFill(colorPicker.getValue());
        context.fillOval(mouseEvent.getX() - 10, mouseEvent.getY() - 10, size, size);
    }*/

    /*public void changeColor() {
        Color color = colorPicker.getValue();


    }*/

    public void undoButtonClicked() {
        undoButton.isCancelButton();
    }

    public void onSaveAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG", "*.svg"));
        fileChooser.setInitialFileName("yourShapes");
        //File file = fileChooser.showSaveDialog(stage);
        File filePath = fileChooser.showSaveDialog(stage);
        //Path filePath = Path.of(fileChooser.showSaveDialog(new Stage()).getPath());

        if (filePath != null) { // file istället för filepath
           // shapeModel.saveToFile(file);
            //java.nio.file.Path path = java.nio.file.Path.of(filePath.toURI());
            shapeModel.saveToFile(filePath.toPath());
        }// Kanske inte shapemodel // Eventuellt file.toPath() * för då använder vi nåt nytt
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //Todo: Lägg till Undo funktionen
    // Todo: Lägg till funktion för att ändra storlek
    // Todo: Lägg till funktion för att ändra färg

    //Todo: Klick på canvas - selection mode? altershape
    //Todo: Overrida rita ut metoden?
    //Todo: Lägg till en riktig rektangel
    //Todo:Tredje tillfälligt listobjekt när du ersätter ett objekt i listan
    //Todo: Vilken cirkel importeras? Shapetype enum?
    //Todo:


}
