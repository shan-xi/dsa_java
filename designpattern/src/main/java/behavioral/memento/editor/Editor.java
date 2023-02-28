package behavioral.memento.editor;

import behavioral.memento.commands.Command;
import behavioral.memento.history.History;
import behavioral.memento.history.Memento;
import behavioral.memento.shapes.CompoundShape;
import behavioral.memento.shapes.Shape;

import javax.swing.*;
import java.io.*;
import java.util.Base64;

public class Editor extends JComponent {
    private final Canvas canvas;
    private CompoundShape allShapes = new CompoundShape();
    private final History history;

    public Editor() {
        canvas = new Canvas(this);
        history = new History();
    }

    public void loadShapes(Shape... shapes) {
        allShapes.clear();
        allShapes.add(shapes);
        canvas.refresh();
    }

    public void undo() {
        if (history.undo()) {
            canvas.repaint();
        }
    }

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.allShapes);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            this.allShapes = (CompoundShape) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException occurred.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ClassNotFoundException occurred.");
        }
    }

    public void redo() {
        if (history.redo()) {
            canvas.repaint();
        }
    }

    public CompoundShape getShapes() {
        return allShapes;
    }

    public void execute(Command c) {
        history.push(c, new Memento(this));
        c.execute();
    }
}
