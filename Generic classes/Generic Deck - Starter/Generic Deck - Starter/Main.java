import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nTesting the generic deck implementation.");

        // DO NOT change the calls to testDeck.
        testDeck(StandardCardFactory.createFullDeck(), "standard", 5);

        testDeck(UnoCardFactory.createFullDeck(), "Uno", 7);
    }

    // TODO: Create the private static generic void method testDeck.
    // param1 = generic list containing all the Card objects to be added to the
    //     deck.
    // param2 = a description of the deck.
    // param3 = the number of cards to be dealt for an initial hand of cards.
    // The method should create a generic deck of cards, shuffle the deck,
    // deal the correct number of cards into a generic list, and display the cards.
    // Then draw and display a card from the deck.

    /**
     * https://www.youtube.com/watch?v=H9vc4gTtGGA
     * https://www.geeksforgeeks.org/java/different-ways-create-objects-java/
     * 
     * Test the deck of card 
     * @param <T> card implements the ICard
     * @param cardList list of card used
     * @param desprition of the deck
     * @param handSize number of card to deal 
     */
    private static <T extends ICard> void testDeck(List<T> cardList, String description, int handSize){
    Deck<T> deck = new Deck<>(cardList, description);
    System.out.println("\nCreated a " + deck.getDescription() + " Deck. ");

    deck.shuffle();
    System.out.println("The deck is shuffled.");

    List<T> hand = deck.deal(handSize);
    System.out.println("Dealt " + handSize + " cards:");

    for (T card : hand){
        System.out.println(" " + card.display());

    }

    T drawCard = deck.draw();
    System.out.println(" Drew a card: " + drawCard.display());

    System.out.println("Cards remaining in deck: " + deck.size());

    }
    }



