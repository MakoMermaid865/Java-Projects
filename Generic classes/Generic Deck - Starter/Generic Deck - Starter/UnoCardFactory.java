import java.util.ArrayList;
import java.util.List;

public class UnoCardFactory {

    /**
     * Create a list of UnoCard objects that are found in an Uno deck.
     * 
     * @return a list of UnoCard objects found in an Uno deck.
     */
    public static List<UnoCard> createFullDeck() {

        // TODO: Complete the createFullDeck method.
        List<UnoCard> deck = new ArrayList<>();
        // Add number cards (0-9) for each color
        for (UnoCard.Color color : UnoCard.Color.values()) {
            if (color != UnoCard.Color.WILD) {
                for (int i = 0; i <= 9; i++) {
                    UnoCard.Value value = UnoCard.Value.values()[i];
                    deck.add(new UnoCard(color, value));
                    if (i != 0) { // Add a second copy for numbers 1-9
                        deck.add(new UnoCard(color, value));
                    }
                }
                // Add action cards: SKIP, REVERSE, DRAW_TWO
                deck.add(new UnoCard(color, UnoCard.Value.SKIP));
                deck.add(new UnoCard(color, UnoCard.Value.REVERSE));
                deck.add(new UnoCard(color, UnoCard.Value.DRAW_TWO));

                return deck;
            }
        }
}
}
