import javax.swing.*; //gives acces to JOPtionPan class
import java.awt.*;
    
/**
 * CavePanel class is responsible for rendering the cave grid
 * "10x10 grid of cave cells" "50x50 pixels each" "Blue color gradient based on depth" "Red color for escape route"
 */
public class CavePanel extends JPanel {
    public static int CaveCell_SIZE = 50;
    private Cave cave;

    public CavePanel(Cave cave) {
        this.cave = cave;
        setPreferredSize(new Dimension(Cave.mycol * CaveCell_SIZE, Cave.myrow * CaveCell_SIZE));
    }

    /**
     * @param depth the depth of the cave cell
     * @return Color object representing the blue shade based on depth
     */
    private Color depthBlue(int depth) {
        int blueValue = 255 - (depth - 1) * 25;
        if (blueValue < 50) blueValue = 50;
        return new Color(0, 0, blueValue);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call superclass method to clear the panel-in Youtube link
        CaveCell[][] grid = cave.getGrid();
        for (int r = 0; r < Cave.myrow; r++) {
            for (int c = 0; c < Cave.mycol; c++) {
                CaveCell cell = grid[r][c];

                int x = c * CaveCell_SIZE;
                int y = r * CaveCell_SIZE;

                if (cell.isOnPath()) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(depthBlue(cell.getDepth()));
                }
                g.fillRect(x, y, CaveCell_SIZE, CaveCell_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CaveCell_SIZE, CaveCell_SIZE);
                g.setColor(Color.WHITE);
                g.drawString(String.valueOf(cell.getDepth()), x + 15, y + 25);
            }
        }
    }

}


/**
 * Links used:
 * https://www.youtube.com/watch?v=rWCnZKF-U3Q&t=18s intro to swing components
 * https://www.geeksforgeeks.org/java/introduction-to-java-swing/ more details on swing components
 * https://quarkphysics.ca/ICS4U1/unit4-graphics/paintComponent.html paintComponent method explanation
 * https://www.youtube.com/watch?v=u5WFob2KjpQ recursion maze solver layout-concept/ideas
 * https://www.youtube.com/watch?v=dyrvXiMumXc recursion maze solver implementation
 */