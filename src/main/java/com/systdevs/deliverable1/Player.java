/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package com.systdevs.deliverable1;
import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
// 
public abstract class Player {

    // Declaring the unique name for the player, the hand of cards the player has, and the score of their hand
    private String name; 
    private ArrayList<Card> hand;
    private int score;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {

        // Initializing the player's name, empty hand, and score = 0
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    // Getter method for the player's hand
    public ArrayList<Card> getHand(){
        return hand;
    }
   
    // Getter method for the player's score
    public int getScore(){
        return score;
    }

    // Adds a card to the player's hand and updates the score
    public void addCard(Card card){
        hand.add(card);
        score += card.getValue();
    }

    // Resets the hand and score (Not Implemented but should)
    public void resetGame(){
        hand.clear();
        score = 0;
    }

    // Checks if the player's score is over 21 (Dosent work on first hand (Can implement easily if needed))
    public boolean isBust(){
        if (score > 21){
            return true;
        }

        else{
            return false;
        }
    }



    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();

}
