package se.iths.jhl.laboration3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.iths.jhl.laboration3.Controller.DrawingProgramController;

import java.io.IOException;

public class DrawingProgramApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DrawingProgramApplication.class.getResource("drawing_program.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        DrawingProgramController controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setTitle("Draw it!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}