//Ari Kinney
//Cave Diver GUI/Recusive Application

import javax.swing.*;
import java.awt.*; // Using AWT layouts like graphic    
import java.awt.event.*; //Using Action Listener for button clicks

/**
 * Design class sets up the GUI for the Cave Diver application.
 * "10x10 grid of cave cells" "50x50 pixels each" "Blue color gradient based on depth" "Red color for escape route"
 */ 
public class Design {
    private static Cave cave;
    private static CavePanel cavePanel;
    public static void main(String[] args) {
        //
        cave = new Cave();
        JFrame frame = new JFrame("Cave Diver - Find an Escape Route");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        cavePanel = new CavePanel(cave);
        //Area
        frame.add(cavePanel, BorderLayout.CENTER);

        //Top of chart like the video demo
        JPanel north = new JPanel(new GridLayout(2, 1));
        
        JLabel top = new JLabel ( "The diver begins in the upper-left corner and escapes by reaching the lower right corner! ", SwingConstants.CENTER);
        north.add(top);
        frame.add(north, BorderLayout.NORTH);


        //Control Panel
        JPanel south = new JPanel(new FlowLayout());
        JTextField depthField = new JTextField(3);
        JButton escapeButton = new JButton("Escape");
        JButton newCaveButton = new JButton("New Cave");
        south.add(new JLabel("Enter the diver's Depth:"));
        south.add(depthField);
        south.add(escapeButton);
        south.add(newCaveButton);
        frame.add(south, BorderLayout.SOUTH);

//Action listen for button
escapeButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Integer diverDepth = Design.parseDepth(depthField, frame);
        if (diverDepth == null){
            return;
        }
        cave.clearPath();
        boolean found = cave.findEscapeRoute(0, 0, Cave.airTank, diverDepth);
        if (found) {
            JOptionPane.showMessageDialog(frame, "Escape route found!");
        } else {
            JOptionPane.showMessageDialog(frame, "Escape route not found!");
        }
        cavePanel.repaint();
    }
});

//make a new grid
    newCaveButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            cave.generateCave();
            cave.clearPath();
            cavePanel.repaint();
        }
    });

        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
    /** 
     * @param field JTextFeild has user input
     * @param parent error messages to user
     * @return depth as an interger is it right
     */
    private static Integer parseDepth(JTextField field, Component parent) {
        String text = field.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Please enter an integer depth.");
            return null;
        }
        try {
            int d = Integer.parseInt(text);
            if (d < 1 || d > 10) {
                JOptionPane.showMessageDialog(parent, "Please enter a number between 1 and 10");
                return null;
            }
            return d;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(parent, "Invalid depth. Enter an integer.");
            return null;
        }
    }
    }

