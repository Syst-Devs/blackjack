package com.systdevs.deliverable1;

import java.util.Scanner;

public class applyGame extends Game {

    // Declaring the player and dealer objects, and the deck of cards
    private Player player;
    private Player dealer;
    private GroupOfCards deck;

    // Constructor for the game
    public applyGame(String name) {
        super(name);
        
        // Creating a new deck of cards and shuffling it
        deck = new GroupOfCards(52);
        deck.createDeckOfCards();
        deck.shuffle();

        // Creating the player and dealer objects with their respective names (Can change to allow player to input their name)
        this.player = new applyPlayer("Player 1");
        this.dealer = new applyPlayer("Dealer");
    }

    // 
    @Override   
    public void play() {
        Scanner scanner = new Scanner(System.in);
        // For future reference if we need to initialize multiple players
        // System.out.println("How many players are playing?");
        // int numOfPlayers = scanner.nextInt();
        // for (int i = 0; i < numOfPlayers; i++){
        //     System.out.println("Enter the name for player " + (i + 1) + ": ");
        //     String nameOfPlayer = scanner.nextLine();
        //     addPlayer(new applyPlayer(nameOfPlayer));
        // }

        // Dealing 2 cards to both the player and dealer
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        // Displaying the cards and scores of the player and dealer
        System.out.println("Player has: " + player.getHand() + " Score " + player.getScore());
        System.out.println("Dealer has: " + dealer.getHand() + " Score " + dealer.getScore());
        
        // Player's turn
        while (true) {
            // Asking the player if they want to hit or stand
            System.out.println("Do you want to hit or stand? (h/s)");
            String action = scanner.nextLine();

            // If the player chooses to hit, they will be dealt a card and their score will be updated
            if (action.equals("h")) {
                player.addCard(deck.dealCard());
                System.out.println("Player's hand: " + player.getHand() + " (Score: " + player.getScore() + ")");
                
                // If the player busts, the dealer wins
                if (player.isBust()) {
                    System.out.println("Player busted! Dealer wins.");
                    return;
                }
            } else {
                break;
            }
        }

        // Dealer's turn
        // The dealer will keep hitting until their score is 17 or higher (like a real blackjack dealer would do)
        while (dealer.getScore() < 17) {
            dealer.addCard(deck.dealCard());
        }
        // Displaying the dealer's hand and score after the dealer is done playing
        System.out.println("Dealer's hand: " + dealer.getHand() + " (Score: " + dealer.getScore() + ")");

        // Declaring the winner of the game
        declareWinner();

        // Closing the scanner
        scanner.close();
    }

    // Method to declare the winner of the game
    @Override
    public void declareWinner() {
        if (dealer.isBust() || player.getScore() > dealer.getScore()) {
            System.out.println("Player wins! With score of: " + player.getScore());
        } else if (dealer.getScore() > player.getScore()) {
            System.out.println("Dealer wins! With score of: " + dealer.getScore());
        } else {
            System.out.println("It's a tie!");
        }
    }
    
}
