import java.util.ArrayList;

public class Bank {


    // ---
    // --- ArrayList für Handkarten der Bank ---
    // ---
    ArrayList<Card> handCardBank = new ArrayList<>();



    public void countBank() {
        int numberOfCardsBank = handCardBank.size();
        System.out.println("Du zählst die Anzahl an Handkarten der Bank");
        System.out.println(numberOfCardsBank);
    }

    public void viewRevealedBankCard() {
        System.out.println("[" + handCardBank.get(0) + "] - Die aufgedeckte Karte der Bank");
    }
}
