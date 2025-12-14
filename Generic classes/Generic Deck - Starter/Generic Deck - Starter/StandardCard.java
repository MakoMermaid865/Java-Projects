//TODO: Complete the StandardCard class.
/**
A StandardCard object must be able to tell us its suit and rank.  It must also implement the 
display method to satisfy the requirement established by the ICard interface. 

how and why we use enum types in Java. 
 */


public class StandardCard {

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
    public StandardCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public Suit getSuit() {
        return suit;
    }
    public Rank getRank() {
        return rank;
    }
    @Override
    public String display() {
        return rank + " of " + suit;

}
}
//make final b/c we don't want other classes to inherit from it or be able to change it
// https://www.youtube.com/watch?v=wq9SJb8VeyM