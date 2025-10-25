import java.awt.*;

public class Box extends Shape{

    /**
     * 
     * @param p1 first conner
     * @param p2 bottom corner
     * @param color green
     */
    public Box(Point p1, Point p2, String color){
    super(p1, p2, color);
}
@Override

/**
 * Draws the rectangle outline
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

        g.drawRect(x, y, w, h);

    }
}

/**
 * Links used:
 * https://www.geeksforgeeks.org/javascript/javascript-math-min-method/ how math min works
 */