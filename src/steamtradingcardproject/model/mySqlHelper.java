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
    
    public int getAppId(mySqlHelper db, String gameName)
    {
        int appId = 0;
        if (isConnected == false)
        {
            db.openHelper();
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
    
    public void updateSetPrice(mySqlHelper db, int price, int appId)
    {
        if (isConnected == false)
        {
            db.openHelper();
        }
        try
        {
            String sql;
            sql = "UPDATE steamTradingCards.games SET SetPrice = " + price + " WHERE AppId = " + appId;
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void updateNumCards(mySqlHelper db, int numCards, int appId)
    {
        if (isConnected == false)
        {
            db.openHelper();
        }
        try
        {
            String sql;
            sql = "UPDATE steamTradingCards.games SET NumCards = " + numCards + " WHERE AppId = " + appId;
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void sortGameName(mySqlHelper db)
    {
        if (isConnected == false)
        {
            db.openHelper();
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
