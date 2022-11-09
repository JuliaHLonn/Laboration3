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

    Command command;
    @Test
    void checkIfColorIsChanged(){
        var color = Color.YELLOW;
        shape.setColor(color);
        assertEquals(color, shape.getColor());
    }

    @Test
    void checkIfColorChangeHasBeenPushedToUndoStack(){
        Color oldColor = shape.getColor();
        Command undo2 = () -> shape.setColor(oldColor);
        undoStack.push(undo2);
        int expectedSize = 1;
        var actual = undoStack.size();

        assertEquals(expectedSize, actual);
    }
}