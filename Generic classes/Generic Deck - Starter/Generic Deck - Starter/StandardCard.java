//TODO: Complete the StandardCard class.
/**
A StandardCard object must be able to tell us its suit and rank.  It must also implement the 
display method to satisfy the requirement established by the ICard interface. 
 */


public class StandardCard implements ICard {

    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    public enum Rank {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN, 
        EIGHT,
        NINE, 
        TEN, 
        JACK, 
        QUEEN, 
        KING, 
        ACE
    }
    private final Suit suit;
    private final Rank rank;

    /**
     * gives specific suit and rank
     * @param suit of card
     * @param rank of card
     */
    public StandardCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * @return suit of of card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return rank of card 
     */
    public Rank getRank() {
        return rank;
    }
    @Override

    /**
     * @return card desrption
     */
    public String display() {
        return rank + " of " + suit;

}
}
//make final b/c we don't want other classes to inherit from it or be able to change it
// https://www.youtube.com/watch?v=wq9SJb8VeyM