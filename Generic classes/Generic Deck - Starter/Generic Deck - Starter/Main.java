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
    

}
