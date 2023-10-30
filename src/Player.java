import java.util.ArrayList;
import java.util.Random;

public class Player {

    // --- ToDo: privat machen! & getter mit setter
    // --- ToDo Wenn Spiel beendet wurde, option zum Restart aber mit Spielernamen behalten



    // --- ArrayList für Handkarten des Spielers ---
    // ---
    ArrayList<Card> handCardPlayer = new ArrayList<>();

    // --- Instanzvariablen ---

    private String name;



    // --- Konstruktor ---

    public Player() {
        this.name = "";
    }


    // --- Methoden ---


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printOptions() {
        System.out.println();
        System.out.println("[1] = Draw a card");
        System.out.println("[2] = View hand cards");
        System.out.println("[3] = View revealed Bank card");
        System.out.println("[4] = Count hand cards of the Bank");
        System.out.println("[5] = Count your hand cards");
        System.out.println("[6] = Count cards in Cardpile");
        System.out.println("[7] = Check turn");
        System.out.println("[0] = Close game");
        System.out.println();
    }


    public void drawCard(Random random, ArrayList<Card> cardPile, ArrayList<Card> handCardBank) {
        System.out.println("Du ziehst eine Karte vom Stapel");

        if (cardPile.size() >= 2) {
            int index5 = random.nextInt(cardPile.size());
            int index6;
            do {
                index6 = random.nextInt(cardPile.size());
            } while (index6 == index5);

            handCardPlayer.add(cardPile.get(index5));
            handCardBank.add(cardPile.get(index6));

            cardPile.remove(index6);
            cardPile.remove(index5);

            System.out.println(handCardPlayer);

        } else {
            System.out.println("Nicht genug Karten im Kartenstapel!");
        }


    }

    public void viewHand() {
        System.out.println("Du schaust dir deine Handkarten an");
        System.out.println(handCardPlayer);
    }

    public void countHandCards() {
        int numberOfCardsPlayer = handCardPlayer.size();
        System.out.println("Du zählst die Anzahl deiner Handkarten");
        System.out.println(numberOfCardsPlayer);
    }


    public boolean checkScore(ArrayList<Card> handCardPlayer, ArrayList<Card> handCardBank) {
        int scorePlayer = 0;
        int scoreBank = 0;

        for (Card card : handCardPlayer) {
            scorePlayer += card.getValue();
        }
        for (Card card : handCardBank) {
            scoreBank += card.getValue();
        }

        System.out.println(scorePlayer + " = Score Player");    // TODO sout entf.------------------------------
        System.out.println(scoreBank + " = Score Bank");      // TODO sout entf.--------------------------------

        boolean winConBoolean = checkWinCon(scorePlayer, scoreBank);

        return winConBoolean;
    }

    private boolean checkWinCon(int scorePlayer, int scoreBank) {

        if (scorePlayer == 21 && scoreBank != 21) {
            System.out.println("Gewonnen! " + name + " kommt auf genau 21!");

        } else if (scoreBank > 21 && scorePlayer <= 21) {
            System.out.println("Gewonnen! Die Bank ist über 21!");

        } else if (scorePlayer > 21 && scoreBank <= 21) {
            System.out.println("Verloren! " + name + " ist über 21!");

        } else if (scoreBank == 21 && scorePlayer <= 21) {
            System.out.println("Verloren! Die Bank kommt auf genau 21!");

        } else if (scorePlayer == 21 && scoreBank == 21) {
            System.out.println("Unentschieden! " + name + " und die Bank sind beide auf genau 21!");

        } else if (scorePlayer > 21 && scoreBank > 21) {
            System.out.println("Unentschieden! " + name + " und die Bank sind über 21!");

        } else {
            return true; // Keine Gewinn- oder Verlustbedingung erfüllt
        }
        return false; // Eine Gewinn- oder Verlustbedingung ist erfüllt
    }

    public void checkTurn(ArrayList<Card> handCardPlayer, ArrayList<Card> handCardBank) {
        int scorePlayer = 0;
        int scoreBank = 0;

        for (Card card : handCardPlayer) {
            scorePlayer += card.getValue();
        }
        for (Card card : handCardBank) {
            scoreBank += card.getValue();
        }

        System.out.println(scorePlayer + " = Score Player");    // TODO sout entf.----------------------------
        System.out.println(scoreBank + " = Score Bank");      // TODO sout entf. -----------------------------


        int diffPlayer = Math.abs(21 - scorePlayer);
        int diffBank = Math.abs(21 - scoreBank);

        if (diffPlayer < diffBank) {
            System.out.println("Gewonnen! " + name + " ist näher an 21!");
        } else if (diffBank < diffPlayer) {
            System.out.println("Verloren! Die Bank ist näher an 21!");
        } else {
            System.out.println("Unentschieden! " + name + " und die Bank sind gleich nah an 21!");
        }
    }
}


























