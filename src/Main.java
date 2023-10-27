import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean isRunning = true;


        //------------------------------------------------------------------
        //                 Objekte erstellen
        //------------------------------------------------------------------


        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Bank bank = new Bank();
        Random random = new Random();


        System.out.println("Geben Sie den Spielernamen ein: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);
        System.out.println("Spielername: " + player.getName());
        System.out.println();


        // --- Methode Game start
        gameStart(scanner, random, bank, player);


        while (isRunning) {

            player.printOptions();
            int input = scanner.nextInt();

            // --- Card draw
            if (input == 1) {
                player.drawCard(random, cardPile, bank.handCardBank);
                isRunning = player.checkScore(player.handCardPlayer, bank.handCardBank, isRunning);
            }

            // --- View hand cards
            if (input == 2) {
                player.viewHand();
            }

            // --- View revealed Bank card
            if (input == 3) {
                bank.viewRevealedBankCard();
            }

            // --- Count Bank cards
            if (input == 4) {
                bank.countBank();
            }

            // --- Count Player cards
            if (input == 5) {
                player.countHandCards();
            }

            // --- Count cards in Cardpile
            if (input == 6) {
                countCardPile();
            }

            // --- Close Game
            if (input == 0) {
                isRunning = false;
                scanner.close();
            }
        }

        //ToDo hier Restart einfügen

    }



    private static void gameStart(Scanner scanner, Random random, Bank bank, Player player) {

        boolean gameStartLoop = true;

        while (gameStartLoop) {
            System.out.println("[1] = Game start");
            System.out.println("Kartendeck mischen und zwei Karten für den Spieler und die Bank austeilen");

            int input = scanner.nextInt();

            if (input == 1) {

                shuffle(random, bank.handCardBank, player.handCardPlayer);

                gameStartLoop = false;
            } else {
                System.out.println("Wrong input! Press [1] to start!");
            }
        }
    }

    private static void countCardPile() {
        System.out.println("Kartenanzahl im Nachziehstabel: " + cardPile.size());
    }

    // ---
    // --- ArrayList für Cardpile zum Nachziehen ---
    // ---
    static ArrayList<Card> cardPile = new ArrayList<>();


    //--------------------------------------------------------------------------------------
    //          Nachziehstabel wird erstellt
    //--------------------------------------------------------------------------------------

    public static void shuffle(Random random, ArrayList<Card> handCardBank, ArrayList<Card> handCardPlayer) {
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                Card card = new Card(i, j);
                cardPile.add(card);
            }
        }

        countCardPile();

        //--------------------------------------------------------------------------------------
        //          Zwei Handkarten für die Bank
        //--------------------------------------------------------------------------------------

        if (cardPile.size() >= 2) {
            int index1 = random.nextInt(cardPile.size());
            int index2;
            do {
                index2 = random.nextInt(cardPile.size());
            } while (index2 == index1);

            handCardBank.add(cardPile.get(index1));
            handCardBank.add(cardPile.get(index2));

            cardPile.remove(index2);
            cardPile.remove(index1);

            System.out.println();
            System.out.println("[" + handCardBank.get(0) + "] - Die aufgedeckte Karte der Bank. Die zweite Karte bleibt verdeckt!");

        } else {
            System.out.println("Nicht genug Karten im Kartenstapel!");
        }


        //--------------------------------------------------------------------------------------
        //          Zwei Handkarten für den Spieler
        //--------------------------------------------------------------------------------------

        if (cardPile.size() >= 2) {
            int index3 = random.nextInt(cardPile.size());
            int index4;
            do {
                index4 = random.nextInt(cardPile.size());
            } while (index3 == index4);

            handCardPlayer.add(cardPile.get(index3));
            handCardPlayer.add(cardPile.get(index4));

            cardPile.remove(index3);
            cardPile.remove(index4);

            System.out.println();
            System.out.println(handCardPlayer);

        } else {
            System.out.println("Nicht genug Karten im Kartenstapel!");
        }
    }
}


