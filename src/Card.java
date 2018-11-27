public class Card {
    private String cardType;
    private String cardSuit;
    private int cardPoint;

    public Card(String type, String suit, int point) {
        cardType = type;
        cardSuit = suit;
        cardPoint = point;
    }

    public String getType() {
        return cardType;
    }

    public String getSuit() {
        return cardSuit;
    }

    public int getPoint() {
        return cardPoint;
    }

    public String toString() {
        return getType() + " of " + getSuit();
    }
}