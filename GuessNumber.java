
import java.util.*;

public class GuessNumber {
    public static void main(String[] args) {
        boolean retry = true;
        Scanner sc = new Scanner(System.in); // Moved Scanner outside the loop to avoid repeated creation

        while (retry) {
            Random rand = new Random();
            int randNum = rand.nextInt(100); // Generates a random number between 0 and 99

            int noOfGuesses = 0;
            boolean hasWon = false;

            System.out.println("\n*** New Game Started ***\n");

            while (noOfGuesses < 5) {
                System.out.print("@ Enter guess number: ");
                int userInput = sc.nextInt();
                noOfGuesses++;

                if (userInput < randNum) {
                    System.out.println("--> Guessed number is less than the actual number.");
                } else if (userInput > randNum) {
                    System.out.println("--> Guessed number is greater than the actual number.");
                } else {
                    hasWon = true;
                    break;
                }

                System.out.println("$ You have " + (5 - noOfGuesses) + " guesses left.");
            }

            if (hasWon) {
                System.out.println("--> Congratulations, You Won!");
                System.out.printf("## The actual number was: %d%n", randNum);
            } else {
                System.out.println("$ Sorry, you've run out of guesses.");
                System.out.printf("## The actual number was: %d%n", randNum);
            }

            // Ask if the user wants to retry or exit
            System.out.println("Enter 1 for retry and 0 for exit: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    retry = false;
                    break; // Exit the game
                case 1:
                    retry = true;
                    break; // Retry the game
                default:
                    System.out.println("Invalid choice, exiting the game.");
                    retry = false;
                    break;
            }
        }

        System.out.println("You exited the game.");
        sc.close(); // Close Scanner after the game ends
    }
}
