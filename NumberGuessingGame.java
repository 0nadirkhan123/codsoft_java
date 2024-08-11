import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int low = 1;
    int high = 100;
    int no_Attempts =0;
    int secretNumber = random.nextInt(high - low+ 1) + low;

    System.out.println("Welcome to the Number Guessing Game!");
    System.out.println("A secret number has been picked between 1 and 100 . Can you guess it?");
    System.out.println("You get 5 attempts to find the number");
    System.out.println("------------------------------------------------------------");
    while (true && no_Attempts<5) {
            System.out.print("Enter your guess (type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for playing! Goodbye!");
                break;
            }

            int guess;
            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                continue;
            }

            no_Attempts++;

            if (guess < secretNumber) {
                System.out.println("Your guess is low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Your guess is high! Try again.");
            } else {
                System.out.println("Well done! You've guessed the correct number " + secretNumber + " in " + no_Attempts + " attempts!");
                break;
         }
        }
        if(no_Attempts>=5){System.out.println("GAME OVER!");}

        scanner.close();
    }
}
