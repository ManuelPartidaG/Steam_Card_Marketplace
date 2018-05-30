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
public class Card
{
    int price;
    int numOfListings;
    String name;
    String hashName;
    String iconUrl;
    String priceText;
    
    public Card()
    {
        this(0, 0, "", "", "", "");
    }
    public Card(int price, int numOfListings, String name, String hashName, String priceText, String iconUrl)
    {
        this.price = price;
        this.numOfListings = numOfListings;
        this.name = name;
        this.hashName = hashName;
        this.priceText = priceText;
        this.iconUrl = iconUrl;
    }
    public int getPrice()
    {
        return this.price;
    }
    public int getNumOfListings()
    {
        return this.numOfListings;
    }
    public String getName()
    {
        return this.name;
    }
    public String getPriceText()
    {
        return this.priceText;
    }
    public String getIconUrl()
    {
        return this.iconUrl;
    }
    public String getHashName()
    {
        return this.hashName;
    }
}
