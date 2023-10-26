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
        gameStart(scanner, bank);



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
                player.countBank();
            }

            // --- Close Game
            if (input == 0) {
                isRunning = false;
                scanner.close();
            }
        }
    }

    private static void gameStart(Scanner scanner, Bank bank) {

        boolean gameStartLoop = true;

        while (gameStartLoop) {
            System.out.println("[1] = Game start");
            System.out.println("Kartendeck mischen und zwei Karten für den Spieler und die Bank austeilen");
            int input = scanner.nextInt();

            if (input == 1) {
                bank.shuffle();
                gameStartLoop = false;
            } else {
                System.out.println("Wrong input! Press [1] to start!");
            }
        }
    }
}







