import java.awt.*;

public class Oval extends Shape {

/**
 * @param p1 first corner of the bending rectangle
 * @param p2 second corner of the bending rectangle
 * @param color blue
 */
public Oval(Point p1, Point p2, String color){
    super(p1, p2, color);
}
@Override

/**
 * Draws oval outline
 */
public void draw(Graphics g){
    if (g == null){
        return; 
    }
        g.setColor(useColor());
        int x = Math.min(getPoint1().x, getPoint2().x); //left x value
        int y = Math.min(getPoint1().y, getPoint2().y); //top y
        int w = Math.abs(getPoint1().x - getPoint2().x); //width
        int h = Math.abs(getPoint1().y - getPoint2().y); //height

        g.drawOval(x, y, w, h);
}
}
