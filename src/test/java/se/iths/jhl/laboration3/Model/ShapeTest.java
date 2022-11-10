package se.iths.jhl.laboration3.Model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import se.iths.jhl.laboration3.Command;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {
    Shape shape = new Square(20, Color.AQUA, 113, 164);
    public static Deque<Command> undoStack = new ArrayDeque<>();

    Color color = Color.YELLOW;

    Command command;
    @Test
    void checkIfColorIsChanged(){

        shape.setColor(color);
        assertEquals(color, shape.getColor());
    }

    @Test
    void checkIfColorChangeHasBeenPushedToUndoStack(){
        shape.changeColor(color, shape);
        int expectedSize = 1;
        var actual = undoStack.size();

        assertEquals(expectedSize, actual);
    }
}