import java.io.Serializable;

//This is the base class for serializable objects
public class serial implements Serializable {
//feilds like x, y, width, height, color
    private int x;
    private int y;
    private int width;
    private int height;
    private String color;

}
@Override
public keyTyped(KeyEvent e) {
    // Not used
    char c = e.getKeyChar();

    switch (c) {
        case 's':
        case 'S':
            saveShapes("shapes.dat");
            break;
        case 'l':
        case 'L':
            loadShapes("shapes.dat");
            break;
    }
}

/**
 * Links used:
 * https://www.youtube.com/watch?v=DfbFTVNfkeI
 * 
 */