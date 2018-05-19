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
public class CardSets
{
    Card[] cardsInSet;
    int setPrice;
    String gameName;
    public void CardSets()
    {
        cardsInSet = new Card[0];
        setPrice = 0;
        gameName = "";
    }
    public void CardSets(Card[] cards, String name)
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
}
