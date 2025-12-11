/**
 * Aurthor: Ari Kinner
 * Project: Shapes phase 4
 * shape program that draws shapes on a frame using serialization and Jfilechooser
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ShapePhase4 extends JFrame implements KeyListener{
    private List<MyShapes> shapes = new ArrayList<>();

    public ShapePhase4(){
        super("Shape Phase 4");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        shapes.add(new Rectangle(100, 100,200, 150, Color.RED));
        shapes.add(new Oval(400, 300,150, 200, Color.BLUE));
        setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (MyShapes shape : shapes){
            shape.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e){
        char c = e.getKeyChar();

        switch (c){
            case 'a':
            case 'A':
                shapes.add(new Rectangle(50, 50, 100, 75, Color.RED));
                repaint();
                break;

            case 's':
            case 'S':
                saveShapes();
                break;
            
            case 'l':
            case 'L':
                loadShapes();
                repaint();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    private void saveShapes(){
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION){
            File fileToSave = fileChooser.getSelectedFile();

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileToSave))){
                out.writeObject(shapes);
                System.out.println("Shapes saved successfully to " + fileToSave.getAbsolutePath());
            } catch (IOException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving shapes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    @SuppressWarnings("unchecked")
    private void loadShapes(){
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION){
            File fileToOpen = fileChooser.getSelectedFile();

            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileToOpen))){
                Object obj = in.readObject();
                shapes = (List<MyShapes>) obj;
                repaint();
                System.out.println("Shapes loaded successfully from " + fileToOpen.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Shapes loaded successfully from " + fileToOpen.getAbsolutePath(), "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading shapes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
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
    private static class Rectangle extends MyShapes {
        public Rectangle(int x, int y, int width, int height, Color color){
            super(x, y, width, height, color);
        }

        @Override
        public void draw(Graphics g){
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

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
 * Links used for this: A few from shapes shapes project
 * https://www.youtube.com/watch?v=DfbFTVNfkeI
 */
