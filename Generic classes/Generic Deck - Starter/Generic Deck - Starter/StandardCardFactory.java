import java.util.ArrayList;
import java.util.List;

public class StandardCardFactory {

    /**
     * Create a list of StandardCard objects that are found in a standard
     * deck of playing cards.
     * 
     * @return a list of StandardCard objects found in a standard deck of playing
     *         cards.
     */
    public static List<StandardCard> createFullDeck() {

        // TODO: Complete the createFullDeck method.
\        List<StandardCard> deck = new ArrayList<>();
        for (StandardCard.Suit suit : StandardCard.Suit.values()) {
            for (StandardCard.Rank rank : StandardCard.Rank.values()) {
                deck.add(new StandardCard(suit, rank));
            }
        }
        return deck;            
    }
}
