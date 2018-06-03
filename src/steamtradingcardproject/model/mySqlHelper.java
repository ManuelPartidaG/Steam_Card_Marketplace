/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elliot1
 */
public class mySqlHelper 
{
    //Driver name & db URL
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    private final String DB_URL = "jdbc:mysql://evillalpandodb.cfuraxh162ie.us-west-1.rds.amazonaws.com:3306/steamTradingCards?useSSL=false";
    //Database credentials
    private static final String USER = "evillalpando22";
    private static final String PASS = "2wsxXDR%";
    Connection conn = null;
    Statement stmt = null;
    boolean isConnected = false;
    
    public mySqlHelper()
    {
        try 
        {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
        }
        catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    
    public void openHelper()
    {
        try
        {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            isConnected = true;
        }
        catch(SQLException se)
        {
            Logger.getLogger(mySqlHelper.class.getName()).log(Level.SEVERE, null, se);
        }
    }
    
    public void closeHelper()
    {
        try
        {
            stmt.close();
            conn.close();
            isConnected = false;
        }
        catch(SQLException se)
        {
            Logger.getLogger(mySqlHelper.class.getName()).log(Level.SEVERE,null,se);
        }
    }
    
    public int getAppId(String gameName)
    {
        int appId = 0;
        if (isConnected == false)
        {
            this.openHelper();
        }
        try
        {
            String sql;
            sql = "SELECT AppId FROM steamTradingCards.games WHERE GameName = " + gameName;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                appId = rs.getInt("AppId");
            }
            rs.close();
        }
        catch(SQLException se)
        {
            Logger.getLogger(mySqlHelper.class.getName()).log(Level.SEVERE,null,se);
        }
        return appId;
    }
    
    public void updateSet(int numCards, int setPrice, int appId)
    {
        if (isConnected == false)
        {
            this.openHelper();
        }
        try
        {
            String sql;
            sql = "UPDATE steamTradingCards.games SET NumCards = " + numCards + ", SetPrice = " + setPrice + " WHERE AppId = " + appId;
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //pass the function zeros for the field not being used 
    //i.e. we want all sets with 4-8 cards but don't care about price, pass it (4, 8, 0, 0)
    public Game[] filterNumCards(int lowNumCards, int upNumCards, int lowPrice, int upPrice)
    {
        if (isConnected == false)
        {
            this.openHelper();
        }
        
        if (lowPrice == 0 && upPrice ==0)
        {
            try
         {
             String sql;
             sql = "SELECT COUNT(*) FROM steamTradingCards.games WHERE NumCards >= " + lowNumCards + " AND NumCards <= " + upNumCards;
             ResultSet rs = stmt.executeQuery(sql);
             rs.next();
             int setCount = rs.getInt("COUNT(*)");
             Game[] gameResults = new Game[setCount+1];
             sql = "SELECT GameName, AppId FROM steamTradingCards.games WHERE NumCards >= " + lowNumCards + " AND NumCards <= " + upNumCards;
             rs = stmt.executeQuery(sql);
             int i = 0;
             while(rs.next())
             {
                 String gameName = rs.getString("GameName");
                 int appId = rs.getInt("AppId");
                 gameResults[i] = new Game(gameName, appId);
                 i++;
                 //debugging
                 System.out.println(gameName);
                 System.out.println(appId);
             }
             rs.close();
             return gameResults;
         }
         catch(SQLException se)
         {
             Logger.getLogger(mySqlHelper.class.getName()).log(Level.SEVERE,null,se);
         } 
        }
        
        if (lowNumCards == 0 && upNumCards ==0)
        {
            try
         {
             String sql;
             sql = "SELECT COUNT(*) FROM steamTradingCards.games WHERE SetPrice >= " + lowPrice + " AND SetPrice <= " + upPrice;
             ResultSet rs = stmt.executeQuery(sql);
             rs.next();
             int setCount = rs.getInt("COUNT(*)");
             Game[] gameResults = new Game[setCount+1];
             sql = "SELECT GameName, AppId FROM steamTradingCards.games WHERE SetPrice >= " + lowPrice + " AND SetPrice <= " + upPrice;
             rs = stmt.executeQuery(sql);
             int i = 0;
             while(rs.next())
             {
                 String gameName = rs.getString("GameName");
                 int appId = rs.getInt("AppId");
                 gameResults[i] = new Game(gameName, appId);
                 i++;
                 //debugging
                 System.out.println(gameName);
                 System.out.println(appId);
             }
             rs.close();
             return gameResults;
         }
         catch(SQLException se)
         {
             Logger.getLogger(mySqlHelper.class.getName()).log(Level.SEVERE,null,se);
         } 
        }
        
        else
        {
            try
         {
             String sql;
             sql = "SELECT COUNT(*) FROM steamTradingCards.games WHERE NumCards >= " + lowNumCards + " AND NumCards <= " + upNumCards 
                     + " AND SetPrice >= " + lowPrice + " AND SetPrice <= " + upPrice;
             ResultSet rs = stmt.executeQuery(sql);
             rs.next();
             int setCount = rs.getInt("COUNT(*)");
             Game[] gameResults = new Game[setCount+1];
             sql = "SELECT GameName, AppId FROM steamTradingCards.games WHERE NumCards >= " + lowNumCards + " AND NumCards <= " + upNumCards 
                     + " AND SetPrice >= " + lowPrice + " AND SetPrice <= " + upPrice;
             rs = stmt.executeQuery(sql);
             int i = 0;
             while(rs.next())
             {
                 String gameName = rs.getString("GameName");
                 int appId = rs.getInt("AppId");
                 gameResults[i] = new Game(gameName, appId);
                 i++;
                 //debugging
                 System.out.println(gameName);
                 System.out.println(appId);
             }
             rs.close();
             return gameResults;
         }
         catch(SQLException se)
         {
             Logger.getLogger(mySqlHelper.class.getName()).log(Level.SEVERE,null,se);
         } 
        }
        
        return null;
    }
    
    public void sortGameName()
    {
        if (isConnected == false)
        {
            this.openHelper();
        }
        try
        {
            String sql;
            sql = "SELECT * FROM steamTradingCards.games ORDER BY GameName";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String gameName = rs.getString("GameName");
                int appId = rs.getInt("AppId");
                int setPrice = rs.getInt("SetPrice");
                int numCards = rs.getInt("NumCards");
            }
            rs.close();
        }
        catch(SQLException se)
        {
            Logger.getLogger(mySqlHelper.class.getName()).log(Level.SEVERE,null,se);
        }
    }
    
}
