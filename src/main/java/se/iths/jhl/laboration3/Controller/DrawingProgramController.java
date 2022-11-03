package se.iths.jhl.laboration3.Controller;

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
import se.iths.jhl.laboration3.Model.MyShapes;
import se.iths.jhl.laboration3.Model.Rectangle;
import se.iths.jhl.laboration3.Model.Shape;
import se.iths.jhl.laboration3.Model.ShapeModel;

import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
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

    @FXML Button saveButton;

    @FXML
    public TextField pickSize;

    public Stage stage;

    public ShapeModel shapeModel = new ShapeModel();
    //
    public Rectangle rectangle = new Rectangle();

    public void initialize() {
        context = canvas.getGraphicsContext2D();



    }

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // Todo: Jag lär väl inte behöva två?
        choiceBox.getItems().addAll(sizes);
        choiceBox.setOnAction(this::setSize);
    }*/

    @FXML
    public void onCanvasClicked(MouseEvent mouseEvent) {

        wichMode(mouseEvent);

       // shapeModel.printList();
        //changeColor();
       // alterShape(mouseEvent);
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


    public void alterShape(MouseEvent mouseEvent) {
        for (Shape shape : ShapeModel.listOfShapeObjects) {
            double xCo = mouseEvent.getX();
            double yCo = mouseEvent.getY();
            if (shape.isSelected(xCo, yCo)) {
                System.out.println("Found a match");
                /*double size = Double.parseDouble(pickSize.getText());
               Rectangle rectangle = new Rectangle(colorPicker.getValue(), size, size, mouseEvent.getX()-10, mouseEvent.getY()-10);
               context.setFill(colorPicker.getValue());
               context.fillRect(mouseEvent.getX()-10, mouseEvent.getY() - 10, size, size);*/
            }
// Får nog sätta den i en till loop så att den inte bara tar sista musklicket
        }
        /*for (int i = 0; i < ShapeModel.listOfShapeObjects.size(); i++) {
            double xCo = mouseEvent.getX();
            double yCo = mouseEvent.getY();

            if (Rectangle.isSelected(xCo, yCo)) {
                System.out.println("Found a match");
                //double x = ShapeModel.listOfShapeObjects.get(i).xCoordinate;
                ShapeModel.listOfShapeObjects.get(i).changeColor(colorPicker.getValue());
            }
        }*/
    }


    private void wichMode(MouseEvent mouseEvent) {
        if (cirkleButton.isSelected())
            drawCirkle(mouseEvent);
        else if (rectangleButton.isSelected())                // Är detta en factory metod?
            drawRectangle(mouseEvent);
        else if (selectModeButton.isSelected()) {
            alterShape(mouseEvent);
        }
    }


   @FXML
    public void drawRectangle(MouseEvent mouseEvent) {
        Color color = colorPicker.getValue();
        double size = Double.parseDouble(pickSize.getText());
        shapeModel.createRectangleObject(color, size, size, mouseEvent.getX(), mouseEvent.getY());

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
    }

    /*public void changeColor() {
        Color color = colorPicker.getValue();


    }*/

    public void undoButtonClicked() {
        undoButton.isCancelButton();
    }

    public void onSaveAction(ActionEvent actionEvent){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV", "*.csv"));

        File file = fileChooser.showSaveDialog(stage);
        if(file!=null)
        { shapeModel.saveToFile(file); }// Kanske inte shapemodel // Eventuellt file.toPath() * för då använder vi nåt nytt
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
