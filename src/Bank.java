import java.util.ArrayList;
import java.util.Random;

public class Bank {

    // --- ArrayList für Handkarten der Bank ---
    //
    ArrayList<Card> handCardBank = new ArrayList<>();

    // --- ArrayList für Cardpile zum Nachziehen ---
    //
    ArrayList<Card> cardPile = new ArrayList<>();


    //--------------------------------------------------------------------------------------
    //          Nachziehstabel wird erstellt
    //--------------------------------------------------------------------------------------

    public void shuffle() {
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                Card card = new Card(i, j);
                cardPile.add(card);
            }
        }

       /* for (Card card : cardPile) {
            System.out.println(card);
        }  */

        int numberOfCards = cardPile.size();
        System.out.println("Kartenanzahl im Nachziehstabel: " + numberOfCards);

        Random random = new Random();
        int pileSize = cardPile.size();


        //--------------------------------------------------------------------------------------
        //          Zwei Handkarten für die Bank
        //--------------------------------------------------------------------------------------

        if (pileSize >= 2) {
            int index1 = random.nextInt(pileSize);
            int index2;
            do {
                index2 = random.nextInt(pileSize);
            } while (index2 == index1);

            handCardBank.add(cardPile.get(index1));
            handCardBank.add(cardPile.get(index2));

            cardPile.remove(index2);
            cardPile.remove(index1);

            System.out.println(handCardBank);

        } else {
            System.out.println("Nicht genug Karten im Kartenstapel!");
        }


        //--------------------------------------------------------------------------------------
        //          Zwei Handkarten für den Spieler
        //--------------------------------------------------------------------------------------

/*        if (pileSize >= 2) {
            int index3 = random.nextInt(pileSize);
            int index4;
            do {
                index4 = random.nextInt(pileSize);
            } while (index3 == index4);

            handCardPlayer.add(cardPile.get(index3));
            handCardPlayer.add(cardPile.get(index4));

            cardPile.remove(index3);
            cardPile.remove(index4);

            System.out.println(handCardPlayer);

        } else {
            System.out.println("Nicht genug Karten im Kartenstapel!");
        }
*/
    }


}
