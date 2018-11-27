import java.util.ArrayList;

public class DeckOfCards {
    private final String[] cardSuits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    private final String[] cardTypes =
            {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    private final int[] cardPoints = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1};

    private ArrayList <Card> deck;

    public DeckOfCards() {
        deck = new ArrayList <Card>();
        for(int k = 0; k < cardSuits.length; k++) {
            for(int j = 0; j < cardTypes.length; j++) {
                deck.add(new Card(cardTypes[j], cardSuits[k], cardPoints[j]));
            }
        }
    }

    public ArrayList getDeck() {
        return deck;
    }

    public ArrayList drawHand(int numberOfCards) {
        ArrayList<Card> tempDeck = this.deck;
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i<numberOfCards; i++) {
            int n = (int)(Math.random()*tempDeck.size());
            hand.add(tempDeck.get(n));
            tempDeck.remove(n);
        }
        return hand;
    }

    public void printHand(ArrayList<Card> hand) {
        for (Card c : hand) System.out.println(c);
    }

    public static void main(String[] args) {
        DeckOfCards d = new DeckOfCards();
        int n = (int)(Math.random()*52)+1;
        System.out.println("The deck has " + n + " cards.");
        ArrayList<Card> h = d.drawHand(n);
        d.printHand(h);
    }

}