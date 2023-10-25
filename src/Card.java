public class Card {

    private int rank;
    private int suit;
    private int value;


    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;


        if (rank == 10 || rank == 11 || rank == 12 || rank == 13) {
            this.value = 10;
        } else if (rank == 1) {
            this.value = 1;
        } else {
            this.value = rank;
        }
    }



    public int getValue() {
        return value;
    }


    // --- Override int into string

    public String toString() {
        String[] ranks = {"", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"", "Hearts", "Diamonds", "Clubs", "Spades"};


        String rankStr = ranks[rank];
        String suitStr = suits[suit];

        return rankStr + " of " + suitStr + " - Value: " + value;
    }
}
