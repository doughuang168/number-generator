package com.doughuang;

import java.util.ArrayList;

public class DeckOfCard implements Deck
{
    private Card[] cards;
    private int topCard;

    public DeckOfCard() {
        cards = new Card[52];
    }

    public void create( int numberOfSuits, int numberOfRanks ){
        for (int i = 0; i < cards.length; i++)
            cards[i] = new Card(i);
    }

    public void shuffle() {

        topCard = 0;

        for (int i = 0; i < 1000; i++) {
            int j = (int)(Math.random()*52);
            int k = (int)(Math.random()*52);
            Card tmpCard = cards[j];
            cards[j] = cards[k];
            cards[k] = tmpCard;
        }
    }

    public Card deal() {
        Card theCard;
        if (topCard < cards.length) {
            theCard = cards[topCard];
            topCard++;
        }
        else
            theCard = null;

        return theCard;
    }

}
