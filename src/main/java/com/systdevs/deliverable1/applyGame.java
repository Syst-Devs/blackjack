package com.systdevs.deliverable1;

import java.util.Scanner;

public class applyGame extends Game {

    // Declaring the player and dealer objects, and the deck of cards
    private Player dealer;
    private GroupOfCards deck;
    private Scanner scanner;

    // Constructor for the game
    public applyGame(String name) {
        super(name);
        this.scanner = new Scanner(System.in); // Initialize the class-level scanner
    }

    public void initializeGame() {
        // Creating a new deck of cards and shuffling it
        deck = new GroupOfCards(52);
        deck.createDeckOfCards();
        deck.shuffle();

        // Asking for the number of players (up to 3)
        int numOfPlayers = 0;
        while (numOfPlayers < 1 || numOfPlayers > 3) {
            System.out.println("How many players are playing? (1-3)");
            numOfPlayers = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (numOfPlayers < 1 || numOfPlayers > 3) {
                System.out.println("Invalid number of players. Please enter a number between 1 and 3.");
            }
        }

        // Getting the names of the players
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter the name for player " + (i + 1) + ": ");
            String nameOfPlayer = scanner.nextLine();
            players.add(new applyPlayer(nameOfPlayer));
        }

        // Creating the dealer
        dealer = new applyPlayer("Dealer");

    }

    @Override
    public void play() {

        // Dealing 2 cards to both the player and dealer
        for (Player player : players) {
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
        }
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        // Displaying the cards and scores of the player and dealer
        for (Player player : players) {
            System.out.println(player.getName() + " has: " + player.getHand() + " Score " + player.getScore());
        }
        System.out.println("Dealer has: " + dealer.getHand() + " Score " + dealer.getScore());

        System.out.println("--------------------------------------------");
        // Player's turn
        for (Player player : players) {
            while (true) {
                System.out.println(player.getName() + ", do you want to hit or stand? (h/s)");
                String action = scanner.nextLine();

                switch (action) {
                    case "h" -> {
                        player.addCard(deck.dealCard());
                        System.out.println(player.getName() + "'s hand: " + player.getHand() + " (Score: " + player.getScore() + ")");
                        if (player.isBust()) {
                            System.out.println(player.getName() + " busted!");
                            break;
                        }
                    }
                    case "s" -> {
                        break;
                    }
                    default -> {
                        System.out.println("Invalid input.");
                    }
                }

                // Exit the loop if the player stands or busts
                if (action.equals("s") || player.isBust()) {
                    break;
                }
            }
        }

        // Dealer's turn
        // The dealer will keep hitting until their score is 17 or higher (like a real blackjack dealer would do)
        while (dealer.getScore() < 17) {
            dealer.addCard(deck.dealCard());
        }

        // Displaying the dealer's hand and score after the dealer is done playing
        System.out.println("Dealer's hand: " + dealer.getHand() + " (Score: " + dealer.getScore() + ")");

        // Declaring the winners of the game
        declareWinner(dealer);

        // Prompts user for if they want to do another game
        System.out.println("Do you want to play again? (y/n)");
        String choice = scanner.nextLine().trim().toLowerCase();
        while (true) {
            switch (choice) {
                case "y" -> {
                    // If yes, reset the game
                    resetGame();
                }
                case "n" -> {
                    // If no, close the scanner and exit the game
                    System.out.println("Thanks for playing!");
                    closeScanner();
                    System.exit(0);
                }
                default -> {
                    // If invalid input, prompt the user again
                    System.out.println("Invalid input. Please enter 'y' to play again or 'n' to exit.");
                }
            }
        }


    }

    // Method to declare the winner of the game
    @Override
    public void declareWinner(Player dealer) {

        System.out.println("--------------------------------------------");
        System.out.println("Dealer's final score: " + dealer.getScore());

        // Print out each player's name, score, and result
        for (Player player : players) {
            System.out.print(player.getName() + "'s final score: " + player.getScore() + " - ");
            if (player.isBust()) {
                System.out.println("Busted!");
            } else if (dealer.isBust() || player.getScore() > dealer.getScore()) {
                System.out.println("Wins against the dealer!");
            } else if (player.getScore() < dealer.getScore()) {
                System.out.println("Loses against the dealer.");
            } else {
                System.out.println("Ties with the dealer.");
            }
        }
    }

    // Method to reset the game
    public void resetGame() {
        // Clearing the hands of the player and dealer
        for (Player player : players) {
            player.resetGame();
        }
        dealer.resetGame();
        // Reseting the deck of cards and shuffling it
        deck = new GroupOfCards(52);
        deck.createDeckOfCards();
        deck.shuffle();
        // Restart the game
        play();
    }

    // Method to close the scanner
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
