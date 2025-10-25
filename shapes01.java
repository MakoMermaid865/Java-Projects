public class shapes01 {

}
  public static void main(String[] args) {
        Shape shape1 = new Shape("Circle", 5);
        Shape shape2 = new Shape("Square", 4);
        
        System.out.println("Shape 1: " + shape1.getName() + ", Sides: " + shape1.getSides());
        System.out.println("Shape 2: " + shape2.getName() + ", Sides: " + shape2.getSides());
    }
}
