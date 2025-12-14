//TODO: Complete the UnoCard class

/**
 * Each card will have a color and value showing the cards used in Uno
 */
public class UnoCard implements ICard{
    public enum Color {
        RED, 
        BLUE, 
        GREEN, 
        YELLOW, 
        WILD
    }

    public enum Value {
        ZERO, 
        ONE, 
        TWO, 
        THREE, 
        FOUR, 
        FIVE, 
        SIX, 
        SEVEN, 
        EIGHT, 
        NINE,
        SKIP, 
        REVERSE, 
        DRAW_TWO, 
        WILD, 
        WILD_DRAW_FOUR
    }
    private final Color color;
    private final Value value;

    /**
     * Uno card with color and value
     * @param color of card
     * @param value of card
     */
    public UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }


    /**
     * @return color of card
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return value of card
     */
    public Value getValue() {
        return value;
    }
    @Override
    
    /**
     * @return desciption of card
     */
    public String display() {
        return color + " " + value;
    }


}
