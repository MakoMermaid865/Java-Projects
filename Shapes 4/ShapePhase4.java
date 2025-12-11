/**
 * Aurthor: Ari Kinner
 * Project: Shapes phase 4
 * shape program that draws shapes on a frame using serialization (ObjectOutputStream and ObjectInputStream) and Jfilechooser (to save or restore the drawings made)
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ShapePhase4 extends JFrame implements KeyListener{

    //List all shapes currently drawn on the screen, I am using serialization to save and restore the shapes
    private List<MyShapes> shapes = new ArrayList<>();

    public ShapePhase4(){
        super("Shape Phase 4");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Key listener to press keys to add shapes, save, and restore
        addKeyListener(this);
        //Start with a couple shapes already drawn
        shapes.add(new RectShape(100, 100,200, 150, Color.RED));
        shapes.add(new Oval(400, 300,150, 200, Color.BLUE));
        setVisible(true);
    }
    /**
     * The paint method to draw all shapes in the shapes list, when repaint is called it will call this method
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (MyShapes shape : shapes){
            shape.draw(g);
        }
    }

    /**
     * The keyTyped method to handle key presses
     * - Press 'A' to add a new rectangle
     * - Press 'S' to save the current shapes to a file
     * - Press 'R' to restore shapes from a file
     */
    @Override
    public void keyTyped(KeyEvent e){
        char c = e.getKeyChar();

        switch (c){
            case 'a': //Add
            case 'A':
                shapes.add(new RectShape(50, 50, 100, 75, Color.RED));
                repaint();
                break;

            case 's': //Save
            case 'S':
                saveShapes();
                break;
            
            case 'r': //Restore
            case 'R':
                loadShapes();
                repaint();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Not used if deleted will cause errors and not complile
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used if deleted will cause errors and not complile
    }

    /**
     * Save method to save the current shapes list to a file using serialization
     * 
     * - Opens a JFileChooser to select the save location
     * - Uses ObjectOutputStream to write the shapes list to the selected file and to binary file
     */
    private void saveShapes(){
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);

        //Check if user approved the save dialog
        if (userSelection == JFileChooser.APPROVE_OPTION){
            File fileToSave = fileChooser.getSelectedFile();

            //write the shapes list to binary file and using file exception handling
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileToSave))){
                out.writeObject(shapes);
                System.out.println("Shapes saved successfully to " + fileToSave.getAbsolutePath());
            } catch (IOException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving shapes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Load method to open dialog to select a file and load the shapes list from that file using serialization
     * 
     * - Opens a JFileChooser to select the file to load from
     * - Uses ObjectInputStream to read the shapes list from the selected file
     * - Repaints the frame to show the loaded shapes
     * - readObject exception handling
     */
    @SuppressWarnings("unchecked")
    private void loadShapes(){
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(this); //open dialog to select file

        //Check if user selcted a file to open
        if (userSelection == JFileChooser.APPROVE_OPTION){
            File fileToOpen = fileChooser.getSelectedFile(); //get filename from choose dialog

            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileToOpen))){
                //read shapes list from binary file and cast it back to List<MyShapes> and repaint after loading
                Object obj = in.readObject();
                shapes = (List<MyShapes>) obj;
                repaint();
                System.out.println("Shapes loaded successfully from " + fileToOpen.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Shapes loaded successfully from " + fileToOpen.getAbsolutePath(), "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ClassNotFoundException e){
                //Handle exceptions during file reading and object casting
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading shapes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Base shape class implementing Serializable for saving and restoring
     * abstract draw method to be implemented by subclasses
     */
    private static abstract class MyShapes implements Serializable {
        int x, y, width, height;
        Color color;

        public MyShapes(int x, int y, int width, int height, Color color){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        public abstract void draw(Graphics g);
    }

    /**
     * Rectangle shape class extending MyShapes
     * Draws a filled rectangle
     */
    private static class RectShape extends MyShapes {
        public RectShape(int x, int y, int width, int height, Color color){
            super(x, y, width, height, color);
        }

        @Override
        public void draw(Graphics g){
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    /**
     * Oval shape class extending MyShapes
     * Draws a filled oval
     */
    private static class Oval extends MyShapes {
        public Oval(int x, int y, int width, int height, Color color){
            super(x, y, width, height, color);
        }

        @Override
        public void draw(Graphics g){
            g.setColor(color);
            g.fillOval(x, y, width, height);
        }
    }

    public static void main(String[] args){
        new ShapePhase4();
    }
}
/**
 * Links used for this: A few from shapes project
 * https://www.youtube.com/watch?v=DfbFTVNfkeI
 */
