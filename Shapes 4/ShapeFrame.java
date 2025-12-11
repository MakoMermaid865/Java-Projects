import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class ShapeFrame extends JFrame {
    private List<Shape> shapes;

    public ShapeFrame(List<Shape> shapes) {
        this.shapes = new ArrayList<>(shapes);
        setTitle("Shape Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    //add saveshapes and loadshapes methods later
    private void saveShapes(String filename) {
        // Implementation for saving shapes to a file
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FiletoSave))) {
                out.writeObject(shapes);
                System.out.println("Shapes saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving shapes: " + e.getMessage());
            }
        }
    }
    @SuppressWarnings("unchecked")
    private void loadShapes(String filename) {
        // Implementation for loading shapes from a file
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();

            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileToOpen))) {
                shapes = (List<Shape>) in.readObject();
                repaint();
                System.out.println("Shapes loaded successfully.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading shapes: " + e.getMessage());
            }
        }
    }

/**
 * Links used for this:
 * https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
 * 
 */
