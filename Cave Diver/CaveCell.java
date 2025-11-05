//Ari Kinney
//Cave Diver GUI/Recusive Application
/**
 * CaveCell class represents a single cell in the cave grid.
 * "Your solution must include classes Cave and CaveCell"
*/
public class CaveCell {

private int row;
private int col;
private int depth;
private boolean onPath; //check if diver is on path

/**
 * "Each cave cell should store its row-column location, its depth"
 *  depth is an integer from 1 to 10
 * @param r row of the cave cell
 * @param c column of the cave cell
 * @param d depth of the cave cell
 */ 
public CaveCell(int r, int c, int d) {
    this.row = r;
    this.col = c;
    this.depth = d;
    this.onPath = false;
}
/**
 * @return row of the cave cell
 */
public int getRow() {
    return row;
}

/**
 * @return column of the cave cell
 */
public int getCol() {
    return col;
}

/**
 * @return depth of the cave cell
 */
public int getDepth() {
    return depth;
}

/**
 * @return whether the cell is on the diver's path
 */
public boolean isOnPath() {
    return onPath;
}

/**
 * Sets whether the cell is on the diver's path
 * @param onPath true if the cell is on the path, false otherwise
 */
public void setOnPath(boolean onPath) {
    this.onPath = onPath;
}


}





/**
 * Links used:
 * Java doc https://www.baeldung.com/javadoc
 * recusion using grid https://www.youtube.com/watch?v=mcXc8Mva2bA
 * method keywords https://www.geeksforgeeks.org/java/final-keyword-in-java/
 * action listener https://www.youtube.com/watch?v=ObVnyA8ar6Q&t=14s
 * 
 */

