/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.URL;
import java.io.InputStreamReader;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import steamtradingcardproject.model.Card;
import steamtradingcardproject.model.CardSet;
import steamtradingcardproject.model.Game;
import steamtradingcardproject.model.mySqlHelper;
/**
 *
 * @author admin
 */
public class SteamAPI
{
    JsonParser jp;
    mySqlHelper sql;
    public SteamAPI()
    {
        jp = new JsonParser();
        sql = new mySqlHelper();
    }
    public CardSet getCardSet(int appid) throws Exception
    {
        URL url = new URL("https://steamcommunity.com/market/search/render?category_753_Game[]=tag_app_" + appid + "&category_753_cardborder[]=tag_cardborder_0&category_753_item_class[]=tag_item_class_2&appid=753&start=0&count=15&format=json&norender=1");
        URLConnection request = url.openConnection();
        request.setConnectTimeout(5000);
        request.connect();
        // Convert to a JSON object to print data
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
        int count = rootobj.get("total_count").getAsInt();
        JsonArray results = rootobj.get("results").getAsJsonArray();
        Card[] resultCards = new Card[count];
        int setPrice = 0;
        for(int i = 0; i < count; i++)
        {
            JsonObject listing = results.get(i).getAsJsonObject();
            //JsonObject listing = temp.getAsJsonObject();
            String name = listing.get("name").getAsString();
            String hashname = listing.get("hash_name").getAsString();
            int numOfListings = listing.get("sell_listings").getAsInt();
            int price = listing.get("sell_price").getAsInt();
            setPrice += price;
            String priceText = listing.get("sell_price_text").getAsString();
            //JsonObject asset = listing.get("asset_description").getAsJsonObject();
            String icon_url = listing.get("asset_description").getAsJsonObject().get("icon_url").getAsString();
            resultCards[i] = new Card(price, numOfListings, name, hashname, priceText, icon_url);
            //System.out.println("name: " + name + "hashname: " + hashname + "\tprice: " + price + "numOfListings: " + numOfListings + "\ticon_url: " + icon_url);
        }
        sql.openHelper();
        sql.updateSet(count, setPrice, appid);
        sql.closeHelper();
        return new CardSet(resultCards, "");
    }
    public Game[] getGamesWithCardsSteam() throws Exception
    {
        URL url = new URL("https://steamcommunity.com/market/appfilters/753");
        URLConnection request = url.openConnection();
        request.connect();
        JsonObject root = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();
        if(!root.get("success").getAsBoolean())
        {
            throw new Exception();
        }
        JsonObject result = root.get("facets").getAsJsonObject().get("753_Game").getAsJsonObject().get("tags").getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = result.entrySet();
        Game[] games = new Game[entries.size()];
        int i = 0;
        for (Map.Entry<String, JsonElement> entry: entries){
            //System.out.println(entry.getKey().substring(4) + " " + entry.getValue().getAsJsonObject().get("localized_name").getAsString());
            games[i] =  new Game(entry.getValue().getAsJsonObject().get("localized_name").getAsString(), Integer.parseInt(entry.getKey().substring(4)));
            i++;
        }
        Arrays.sort(games, (Game o1, Game o2) -> o1.name.compareTo(o2.name));
        return games;
    }
}