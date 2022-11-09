package se.iths.jhl.laboration3.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class SaveSVG {


    public SaveSVG() {
    }

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

    public void saveToFile(Path path) {

        List<String> svgList = new ArrayList<>();
        String startSVG = "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"700\" height=\"800\">";
        svgList.add(startSVG);

        for (Shape shape : Shape.listOfShapeObjects) {
            svgList.add(shape.svgString());

        }
        svgList.add("</svg>");
        try {
            Files.write(path, svgList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
