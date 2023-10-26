import java.util.ArrayList;

public class Player {

    // --- ArrayList für Handkarten des Spielers ---
    //
    ArrayList<Card> handCardPlayer = new ArrayList<>();

    // --- Instanzvariablen ---

    private String name;
    private int score;


    // --- Konstruktor ---

    public Player() {
        this.name = "";
        this.score = 0;
    }


    // --- Methoden ---

    public int getScore() {
        return score;
    }

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
        System.out.println("[3] = Count hand cards of the Bank");
        System.out.println("[0] = Close game");
        System.out.println();
    }


    public void drawCard() {
        System.out.println("Du ziehst eine Karte vom Stapel");
    }

    public void viewHand() {
        System.out.println("Du schaust dir deine Handkarten an");
        System.out.println(handCardPlayer);
    }

    public void countBank() {
        System.out.println("Du zählst die Anzahl an Handkarten der Bank");
    }
}
