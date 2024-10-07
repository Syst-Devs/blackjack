package com.systdevs.deliverable1;

import java.util.Scanner;

public class applyGame extends Game {
    private Player player;
    private Player dealer;
    private GroupOfCards deck;

    public applyGame(String name) {
        super(name);
        deck = new GroupOfCards(52);
        deck.createDeckOfCards();
        deck.shuffle();
        this.player = new applyPlayer("Player 1");
        this.dealer = new applyPlayer("Dealer");
    }

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

        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        System.out.println("Player has: " + player.getHand() + " Score " + player.getScore());
        System.out.println("Dealer has: " + dealer.getHand() + " Score " + dealer.getScore());
        
        while (true) {
            System.out.println("Do you want to hit or stand? (h/s)");
            String action = scanner.nextLine();
            if (action.equals("h")) {
                player.addCard(deck.dealCard());
                System.out.println("Player's hand: " + player.getHand() + " (Score: " + player.getScore() + ")");
                if (player.isBust()) {
                    System.out.println("Player busted! Dealer wins.");
                    return;
                }
            } else {
                break;
            }
        }

        while (dealer.getScore() < 17) {
            dealer.addCard(deck.dealCard());
        }

        System.out.println("Dealer's hand: " + dealer.getHand() + " (Score: " + dealer.getScore() + ")");
        declareWinner();

        scanner.close();
    }
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
