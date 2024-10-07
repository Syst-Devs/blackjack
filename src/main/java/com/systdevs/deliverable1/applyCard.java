package com.systdevs.deliverable1;

public class applyCard extends Card {
    public applyCard(String suit, String rank, int value) {
        super(suit, rank, value);
    }

    @Override
    public String toString() {
        return (getRank() + " of " + getSuit());
    }
    
}
