//TODO: Complete the UnoCard class

public class UnoCard {
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
     * 
     * @param color
     * @param value
     */
    public UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }


    /**
     * 
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * 
     * @return
     */
    public Value getValue() {
        return value;
    }
    @Override
    public String display() {
        return color + " " + value;
    }


}
