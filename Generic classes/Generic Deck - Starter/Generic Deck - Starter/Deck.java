
//TODO: Create the Deck class so that it works with a collection of
//      generic card types that realize the ICard interface.
import java.util.*;

public class Deck<T extends ICard> {
    private List<T> cards;
    private Random random;
    private List<T> dealtCards;
    private String description;

    /**
     * The constructor for the Deck class.
     * @param cards the full list of cards to be added to the deck.
     * @param descrption a description of the deck.
     */
    public Deck(List<T> cards, String descrption) {
        this.cards = new ArrayList<>(cards);
        this.random = new Random();
        this.dealtCards = new ArrayList<>();
        this.description = descrption;
    }

    /**
     * shuffle the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards, random);
    }

    /**
     * Deal a specified number of cards from the deck.
     * @param numberOfCards the number of cards to deal.
     * @return a list of dealt cards.
     */
    public List<T> deal(int numberOfCards) {
        if (numberOfCards > cards.size()) {
            throw new IllegalArgumentException("Not enough cards in the deck to deal " + numberOfCards + " cards.");
        }
        List<T> hand = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            T card = cards.remove(0);
            hand.add(card);
            dealtCards.add(card);
        }
        return hand;
    }

    /**
     * Draw a single card from the deck.
     * @return NoSuchElementException if the deck is empty.
     */
    public T draw() {
        if (cards.isEmpty()) {
            throw new NoSuchElementException("No cards left in the deck.");
        }
        return cards.remove(0);
    }



    /**
     * Get the number of remaining cards in the deck.
     * @return the number of remaining cards.
     */
    public int size() {
        return cards.size();
    }

    /**
     * Reset the deck to its original state by returning all dealt cards
     * back to the deck and shuffling it.
     */
    public void resetDeck() {
        cards = new ArrayList<>(dealtCards);
        shuffle();
    }

    /**
     * Returns the desciption of the deck
     * @return desciption
     */
    public String getDescription(){
        return description;
    }


}
