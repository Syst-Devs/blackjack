/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package com;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Cayla Quesnelle - oct 4, 2024
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cardDeck;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        cardDeck = new ArrayList<>();
        int numOfCards = 0;

        for (Card.CardSuit cardSuit : Card.CardSuit.values()) {
            for (Card.CardRank cardRank : Card.CardRank.values()){
                if(numOfCards < size) {
                    cardDeck.add(new BlackjackCards(cardSuit, cardRank));
                    numOfCards++;
                } 
                else {
                    break;
                }
            }
            if (numOfCards >= numOfCards){
                break;
            }
        }
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cardDeck;
    }

    public void shuffle() {
        Collections.shuffle(cardDeck);
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

}//end class
