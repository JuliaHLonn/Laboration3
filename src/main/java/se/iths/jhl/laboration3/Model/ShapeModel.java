package se.iths.jhl.laboration3.Model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class ShapeModel {

    @FXML
    public Circle circle; // Har definierat som klassen cirkle förut vilken extendar shape

    public javafx.scene.shape.Rectangle rectangle;

    //public Color color;



    public ShapeModel() {
    }

    // public ShapeModel(Color color){this.color = color;}
    public void printList() {
        for (var shape : Shape.listOfShapeObjects
        ) {
            System.out.println(shape);

        }
    }


    // public void setColor(Color color){this.color = color;}

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }





    public void createTriangleObject(double[] base, double[] height, Color color) {
        //  listOfShapeObjects.add(new Triangle(base,height, color));
    }




    public void saveToFile(Path path) { // Eventuellt Path file *
        // Kod för att omvandla en bild antar jag till en fil
        StringBuffer stringBuffer = new StringBuffer();
        List<String> svgList = new ArrayList<>();
        String startSVG = "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"700\" height=\"800\">";
        svgList.add(startSVG);

        for (Shape shape : Shape.listOfShapeObjects) {
            svgList.add(shape.svgString());


           /* outPut.append(p.getProductName());
            outPut.append(",");
            outPut.append(p.getEanCode());
            outPut.append(",");
            outPut.append(p.getPrice());
            outPut.append(",");
            outPut.append(p.getCategory().getCategoryName());
            outPut.append("\n");*/
        }
        svgList.add("</svg>");
        try {
            Files.write(path, svgList);//writeString, toString()
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String string:svgList
             ) {
            System.out.println(string);
        }
    /*    <svg version="1.1"
        width="300" height="200"
        xmlns="http://www.w3.org/2000/svg">

  <rect width="100%" height="100%" fill="red" />

  <circle cx="150" cy="100" r="80" fill="green" />

  <text x="150" y="125" font-size="60" text-anchor="middle" fill="white">SVG</text>

</svg>*/
    }
}
