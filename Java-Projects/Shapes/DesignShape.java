
import java.awt.*; 
import javax.swing.*;

/**
 * not need but helps me see the shape and design
 * most was copy from midterms project and dimension were retested to size
 */
public class DesignShape{

public static void main(String[] args) {
    Shape s1 = new Line(new Point(80,60), new Point (520,60), "red");
    Shape s2  = new Box(new Point(120,120), new Point (520,320), "green");
    Shape s3 = new Oval(new Point(160,360), new Point (480, 450), "blue");

    

    //Panel
    JPanel art = new JPanel() {
    
    @Override
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            setBackground(Color.WHITE);
            s1.draw(g);
            s2.draw(g);
            s3.draw(g);
        }
        @Override
        public Dimension getPreferredSize(){
            return new Dimension (700, 600);
        }
    };

    //Window to draw c+p midterem frame code
    JFrame frame = new JFrame("Shape");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    frame.setContentPane(art);
    frame.pack();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);

}
}