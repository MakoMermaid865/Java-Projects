//Ari Kinney
//Shapes/shapes01.java

import java.awt.*; //take in Graphics and point and color

/**
 * abstraction for passing varibles and methods and work better with draw (graphic g)
 * @author Ari Kinney
 * @version 1.0
 */

public abstract class Shape {
    /**
     * First point will define the shape
     */
    private Point point1;

    /**
     * Second will define the shape
     */
    private Point point2;

    /**
     * color of shapes red, green, blue
     */
    private String color;

    /**
     * creats the new shape the made by the two points
     * @param point1 point 1
     * @param point2 point 2
     * @param color which color to use
     */
    public Shape(Point point1, Point point2, String color) {
        //consider if no point is there
        if (point1 == null || point2 == null){
            throw new IllegalArgumentException("Points need to be there!");
        }
        this.point1 = new Point(point1);
        this.point2 = new Point(point2);
        this.color = (color == null) ? "black" : color.trim(); //changed this so it can work better

    }

    /**
     * @return a new point with cordinate as point1
     */
    public Point getPoint1(){
        return new Point(point1);
    }

    /**
     * set point1 to copy the point the point from user
     * @param p new point value
     */
    public void setPoint1(Point p) {
        if (p == null){
            throw new IllegalArgumentException("Points need to be there!");
        }
        this.point1 = new Point(p) ;
    }

    /**
     * returns copy of point2
     * @return a new point with like point 2
     */
    public Point getPoint2(){
        return new Point(point2);
    }

    /**
     * set point 2 of the given point
     * @param p the new point2 value
     */
    public void setPoint2(Point p) {
        if (p == null){
            throw new IllegalArgumentException("Points need to be there!");
        }
        this.point2 = new Point(p) ;
    }

    /**
     * @return what the colore is set to
     */
    public String getColor(){
        return color;
    }

    /**
     * Sets the color when drawing
     * @param color the color is black
     */
    public void setColor(String color) {
        this.color = (color == null) ? "black" : color.trim();
    }

/**
 * Draws the shape using Graphic calls
 * @param g used for drawing
 */
public abstract void draw(Graphics g);

/**
 * @return a that matches the color it was set to
 */
public Color useColor(){
        String c = color.trim();
        if (color == null){
            return Color.BLACK;
        }
        if (c.equalsIgnoreCase("red")){
            return Color.RED;
        }
        if(c.equalsIgnoreCase("green")){
            return Color.GREEN;
        }
        if(c.equalsIgnoreCase("blue")){
            return Color.BLUE;
        }
        else {
            return Color.BLACK;
        }

    }

}



/**
 * Used links:
 * https://www.delftstack.com/howto/java/resolve-illegalargumentexception-in-java/ understand more about exception errors in codes
 * https://www.youtube.com/watch?v=t2PcC-FYFmI better version of if else
 * https://www.tutorialspoint.com/difference-between-equals-vs-equalsignorecase-in-java equals vs ignorecaseing
 * https://www.youtube.com/watch?v=HvPlEJ3LHgE working with abstraction class
 * https://www.youtube.com/watch?v=IUqKuGNasdM more with object and classes
 * https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html Java doc layout
 */