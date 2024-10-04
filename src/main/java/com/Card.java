/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package com;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @modifier Cayla 
 * 
 */
public abstract class Card {
    //default modifier for child classes
    
    //adding card suit and rank enums
    public enum CardSuit {
        CLUBS, SPADES, HEARTS, DIAMONDS
    }

    public enum CardRank {
        ACE(11), KING(10), QUEEN(10), JACK(10), TEN(10), NINE(9), 
        EIGHT(8), SEVEN(7), SIX(6), FIVE(5), FOUR(4), THREE(3), TWO(2);

        private int rankValue;

        CardRank(int rankValue){
            this.rankValue = rankValue;
        }

        public int getValue(){
            return rankValue;
        }
    }

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();

}