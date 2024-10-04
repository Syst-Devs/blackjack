package com;

public class BlackjackCards extends Card {

    private CardSuit cardSuit;
    private CardRank cardRank;

    public BlackjackCards(CardSuit cardSuit, CardRank cardRank){
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public CardSuit getCardSuit(){
        return cardSuit;
    }

    public CardRank getCardRank(){
        return cardRank;
    }
    
    
    @Override
    public String toString() {
        return "The " + cardRank + " of " + cardSuit;
    }
    

}
