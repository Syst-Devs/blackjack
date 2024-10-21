/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package com.systdevs.deliverable1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {
    
    // Declaring a cards variable of type array list and the size of the group of cards
    private ArrayList<Card> cards;
    private int size;

    // Constructor that initializes the size and creates an empty ArrayList for cards
    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>();
    }

    // Getter method for the cards
    public ArrayList<Card> getCards() {
        return cards;
    }

    // Setter method for the cards
    public void setCards(ArrayList<Card> cards){
        this.cards = cards;
    }

    // Method to shuffle the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to deal (delete) a card from the deck
    public Card dealCard(){
        return (cards.remove(0));
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    // Method to create a deck of cards, filling the ArrayList cards with all the cards in a standard deck, 
    // inluding suits, ranks, and interger values for every card
    public void createDeckOfCards(){
        String[] suits = {"Clubs","Hearts","Spades","Diamonds"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for (int i = 0; i < suits.length; i++){
            for (int x = 0; x < ranks.length; x++){
                cards.add(new applyCard(suits[i], ranks[x], values[x]));
            }
        }
    }

}
