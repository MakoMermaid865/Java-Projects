import java.util.Random;

/**
 * had 10x10 grid of cave cells with random depth values between 1 and 10
 * "Your solution must include classes Cave and CaveCell"
 * Recursive algorithm to find an escape route.  Once an escape route is discovered, mark
 */
public class Cave {
    public static int myrow = 10;
    public static int mycol = 10;
    public static int airTank = 20;

    private CaveCell[][] grid = new CaveCell[myrow][mycol];
    private Random rand = new Random();

    /**
     * @param rows Number of rows in the cave grid
     * @param cols Number of columns in the cave grid
     */
    public Cave() {
        generateCave(); //not needed
    }

    /**
     * Generates a new cave with random depths for each cell 1 to 10
     */
    public void generateCave() {
        for (int r = 0; r < myrow; r++) {
            for (int c = 0; c < mycol; c++) {
                int cellDepth = rand.nextInt(10) + 1;    // Depth between 1 and 10
                grid[r][c] = new CaveCell(r, c, cellDepth);
            }
        }
}

    /**
     * Clears the current path markings in the cave cells 
     */
    public void clearPath() {
        for (int r = 0; r < myrow; r++) {
            for (int c = 0; c < mycol; c++) {
                grid[r][c].setOnPath(false);
            }
        }
    }

    /**
     * Marks a cell as being on the diver's path
     * @param r
     * @param c
     * recursion when making the path
     */
    public void setOnPath(int r, int c) {
        grid[r][c].setOnPath(true); //not needed
    }

    /**
     * @return the cave grid
     */
    public CaveCell[][] getGrid() {
        return grid;
    }
 /**
  *  Move Down or Right only, each move costs 1 air, cannot exceed diver's depth limit
    * @param airLeft remaining air in the tank
    * @param r current row
    * @param c current column
    * @param diverDepth maximum depth the diver can go
    * @return true if an escape route is found, false otherwise
https://www.geeksforgeeks.org/dsa/rat-in-a-maze/
*/

public boolean findEscapeRoute(int r, int c, int airLeft, int diverDepth) {
    // row and column bounds check
    if (r < 0 || r >= myrow || c < 0 || c >= mycol) {
        return false; // Out of bounds
    }
    // Get the current cell
    if(grid[r][c].getDepth() > diverDepth) {
        return false; // Cell depth exceeds diver's depth limit
    }
    // Air check
    if (airLeft < 0) {
        return false; // No air left
    }

    if (r == myrow - 1 && c == mycol - 1) {
        grid[r][c].setOnPath(true); // Mark the exit cell
        return true; // Reached the exit
    }

//Making a new way
int rightDepth;
if (c+1 < mycol) {
rightDepth = grid[r][c+1].getDepth();
}else{
    rightDepth=Integer.MAX_VALUE;
}

int downDepth;
if(r+1<myrow){
    downDepth=grid [r+1][c].getDepth();
}else{
    downDepth=Integer.MAX_VALUE;
}

int first;
int second;

if (rightDepth <= downDepth){
    first =0; //right first
    second = 1;
}else{
    first =1;
    second=0;
}

int[] dr = {0,1};
int [] dc = {1,0};


int nextrow = r + dr[first];
int nextcolumn= c+ dc [first];
if (findEscapeRoute(nextrow, nextcolumn, airLeft-1, diverDepth )) { 
        grid[r][c].setOnPath(true);
        return true;

} 
nextrow = r + dr[second];
nextcolumn= c+ dc [second];
    if (findEscapeRoute(nextrow, nextcolumn, airLeft-1, diverDepth )) {
        grid[r][c].setOnPath(true);
        return true;
    }
    return false;

}

}
