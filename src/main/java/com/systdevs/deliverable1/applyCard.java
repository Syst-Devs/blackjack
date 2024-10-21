package com.systdevs.deliverable1;

// This class extends the Card class and is used to create a card object for every card in the deck
public class applyCard extends Card {

    // Constructor for passing suit, rank, and value to Card.java
    public applyCard(String suit, String rank, int value) {
        super(suit, rank, value);
    }

    // Overriding the toString method to return the rank and suit of the card
    @Override
    public String toString() {
        return (getRank() + " of " + getSuit());
    }
    
}
