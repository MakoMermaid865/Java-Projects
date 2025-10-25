
import java.awt.*;

/**
 * Useing point1 and point2 from the parent from shape (parent class)
 */

public class Line extends Shape {

/**
 * 
 * @param p1 first point
 * @param p2 second point
 * @param color red
 */
public Line(Point p1, Point p2, String color){
    super(p1, p2, color);
}

/** 
 * Draws the line using graphics
 * @param g the graphics context
 */
@Override
public void draw(Graphics g){
    if (g == null){
        return;
    }
        g.setColor(useColor());
        Point p1 = getPoint1();
        Point p2 = getPoint2();
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}
/**Links to use 
 * https://www.youtube.com/watch?v=E-0MMeNi5Cw refresher on override
 * https://www.youtube.com/watch?v=eboNNUADeIc
 * https://www.geeksforgeeks.org/java/encapsulation-in-java/
 */