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

        System.out.println("Geben Sie den Spielernamen ein: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);
        System.out.println("Spielername: " + player.getName());


        // --- Methode Game start
        gameStart(scanner);



        while (isRunning) {

            player.printOptions();
            int input = scanner.nextInt();

            // --- Card draw
            if (input == 1) {
                player.drawCard();
            }

            // --- View hand cards
            if (input == 2) {
                player.viewHand();
            }

            // --- Count Bank cards
            if (input == 3) {
                bank.countBank();
            }

            // --- Count Player cards
            if (input == 4) {
                player.countHandCards();
            }

            // --- Close Game
            if (input == 0) {
                isRunning = false;
                scanner.close();
            }
        }
    }

    private static void gameStart(Scanner scanner) {

        boolean gameStartLoop = true;

        while (gameStartLoop) {
            System.out.println("[1] = Game start");
            System.out.println("Kartendeck mischen und zwei Karten für den Spieler und die Bank austeilen");

            int input = scanner.nextInt();

            if (input == 1) {
                shuffle(Bank.handCardBank, Player.handCardPlayer);
                gameStartLoop = false;
            } else {
                System.out.println("Wrong input! Press [1] to start!");
            }
        }
    }


    // ---
    // --- ArrayList für Cardpile zum Nachziehen ---
    // ---
    static ArrayList<Card> cardPile = new ArrayList<>();


    //--------------------------------------------------------------------------------------
    //          Nachziehstabel wird erstellt
    //--------------------------------------------------------------------------------------

    public static void shuffle(ArrayList<Card> handCardBank, ArrayList<Card> handCardPlayer) {
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                Card card = new Card(i, j);
                cardPile.add(card);
            }
        }


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

        if (pileSize >= 2) {
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
    }
}







