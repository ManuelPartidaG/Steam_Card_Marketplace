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
        }
        catch(SQLException se)
        {
            Logger.getLogger(mySqlHelper.class.getName()).log(Level.SEVERE,null,se);
        }
    }
    
    public void testHelper()
    {
        try
        {
            String sql;
            sql = "SELECT AppId FROM games WHERE GameName='Planet Coaster'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                int appId = rs.getInt("AppId");
                System.out.println(appId);
            }
            rs.close();
        }
        catch(SQLException se)
        {
          Logger.getLogger(mySqlHelper.class.getName()).log(Level.SEVERE, null, se);  
        }
    }
    
}
