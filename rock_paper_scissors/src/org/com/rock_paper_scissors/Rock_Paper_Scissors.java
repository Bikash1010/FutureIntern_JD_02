package org.com.rock_paper_scissors;

import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissors {

	public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Create a Random object to generate random computer moves
        Random random = new Random();

        // Options for the game
        String[] options = {"rock", "paper", "scissors"};
        
        // Variable to track if the user wants to continue playing
        boolean playAgain = true;
        
        // Game loop
        while (playAgain) {
            // Ask the user for their choice
            System.out.println("Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            // Validate user input
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice, please choose rock, paper, or scissors.");
                continue;
            }

            // Computer randomly selects a choice
            int computerChoiceIndex = random.nextInt(3);
            String computerChoice = options[computerChoiceIndex];
            System.out.println("Computer's choice: " + computerChoice);

            // Determine the winner
            String result = determineWinner(userChoice, computerChoice);

            // Display the result
            System.out.println(result);

            // Ask if the user wants to play again
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();
            if (playAgainResponse.equals("no")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Method to determine the winner based on the choices
    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if (
            (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
            (userChoice.equals("paper") && computerChoice.equals("rock"))
        ) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
	
}



