import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] symbols = {"Cherry", "Lemon", "Orange", "Plum", "Bell", "Bar", "Seven"};
        int[] payouts = {2, 3, 4, 5, 6, 8, 10}; // Payout multipliers for each symbol

        System.out.println("Welcome to the Slot Machine!");
        System.out.println("Press Enter to spin. Q to quit.");

        while (true) {
            System.in.read(); // Wait for Enter key press

            // Check if user wants to quit
            if (scanner.hasNextLine() && scanner.nextLine().equalsIgnoreCase("Q")) {
                break;
            }

            // Spin the slot machine
            String[] result = new String[3];
            int totalPayout = 0;

            for (int i = 0; i < 3; i++) {
                int randomIndex = random.nextInt(symbols.length);
                result[i] = symbols[randomIndex];
                totalPayout += payouts[randomIndex];
            }

            // Display the result
            System.out.println("[" + result[0] + "] [" + result[1] + "] [" + result[2] + "]");

            if (totalPayout > 0) {
                System.out.println("Congratulations! You won " + totalPayout + " coins!");
            } else {
                System.out.println("Better luck next time!");
            }

            System.out.println("Press Enter to spin again. Q to quit.");
        }

        System.out.println("Thank you for playing!");
    }
}
