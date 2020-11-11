package com.rockpaperscissors;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Let's play Rock, Paper, Scissors!");
        int playerScore = 0;
        int computerScore = 0;
        int winScore = 0;

        winScore = getWinScore(input, winScore);

        while (true) {
            if (playerScore == winScore || computerScore == winScore) {
                System.out.println();
                System.out.println("Player Score: " + playerScore);
                System.out.println("Computer Score: " + computerScore);
                if (playerScore > computerScore) {
                    System.out.println("You Win!");
                } else if (computerScore > playerScore) {
                    System.out.println("You Lose!");
                }
                System.out.print("Play again? (y) or (n): ");
                String playAgain = input.nextLine().trim();
                if (playAgain.toLowerCase().equals("y")) {
                    playerScore = 0;
                    computerScore = 0;
                    winScore = getWinScore(input, winScore);
                    continue;
                } else if (playAgain.toLowerCase().equals("n")) {
                    System.out.println("Thank you for playing!");
                    break;
                } else {
                    System.out.println("Invalid input");
                }
            }
            System.out.println();
            System.out.println("Player Score: " + playerScore);
            System.out.println("Computer Score: " + computerScore);
            String computerChoice = computerChoice();
            System.out.print("Enter your choice: ");
            String playerChoice = input.nextLine();
            playerChoice = playerChoice.toLowerCase().trim();
            if (playerChoice.equals(computerChoice)) {
                System.out.println("The computer chose " + computerChoice + ", it's a draw!");
            } else if (playerChoice.equals("rock")) {
                if (computerChoice.equals("paper")) {
                    computerScore++;
                    System.out.println("The computer chose " + computerChoice + ", you lose this round!");
                } else {
                    playerScore++;
                    System.out.println("The computer chose " + computerChoice + ", you win this round!");
                }
            } else if (playerChoice.equals("paper")) {
                if (computerChoice.equals("scissors")) {
                    computerScore++;
                    System.out.println("The computer chose " + computerChoice + ", you lose this round!");
                } else {
                    playerScore++;
                    System.out.println("The computer chose " + computerChoice + ", you win this round!");
                }
            } else if (playerChoice.equals("scissors")) {
                if (computerChoice.equals("rock")) {
                    computerScore++;
                    System.out.println("The computer chose " + computerChoice + ", you lose this round!");
                } else {
                    playerScore++;
                    System.out.println("The computer chose " + computerChoice + ", you win this round!");
                }
            } else {
                System.out.println("Invalid input");
            }
        }

    }

    private static int getWinScore(Scanner input, int winScore) {
        boolean validScore = false;
        while (!validScore) {
            try {
                System.out.print("Enter the score you want to play to: ");
                int playScore = input.nextInt();
                input.nextLine();
                if (playScore > 0) {
                    winScore = playScore;
                    validScore = true;
                } else {
                    System.out.println("Invalid core");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Score");
                input.nextLine();
            }
        }
        return winScore;
    }

    private static String computerChoice() {
        Random rand = new Random();
        String [] choices = {"rock", "paper", "scissors"};
        return choices[rand.nextInt(3)];
    }

}
