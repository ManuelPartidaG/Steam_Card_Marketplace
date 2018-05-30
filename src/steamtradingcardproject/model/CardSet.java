/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.model;

/**
 *
 * @author admin
 */
public class CardSet
{
    Card[] cardsInSet;
    int setPrice;
    String gameName;
    
    public CardSet()
    {
        cardsInSet = new Card[0];
        setPrice = 0;
        gameName = "";
    }
    public CardSet(Card[] cards, String name)
    {
        cardsInSet = cards;
        for (Card card : cards) {
            setPrice += card.getPrice();
        }
        gameName = name;
    }
    public int getSetPrice()
    {
        return this.setPrice;
    }
    public String getGameName()
    {
        return this.gameName;
    }
    public Card[] getCards()
    {
        return this.cardsInSet;
    }
}
