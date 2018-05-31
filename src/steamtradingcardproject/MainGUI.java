/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import steamtradingcardproject.controller.SteamAPI;
import steamtradingcardproject.view.cardView;
import steamtradingcardproject.model.Card;
import steamtradingcardproject.model.CardSet;
//import steamtradingcardproject.lib.ComponentResizer;

/**
 *
 * @author sysadmin
 */
public class MainGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Database driver and host url
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://evillalpandodb.cfuraxh162ie.us-west-1.rds.amazonaws.com:3306/steamTradingCards?useSSL=false";
        //  Database credentials
        String USER = "evillalpando22";
        String PASS = "2wsxXDR%";
        Connection conn = null;
        Statement stmt = null;
        
        try 
        {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //Open a connection
            //System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //System.out.println("Connected database successfully...");
        }
        catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        
        // TODO code application logic here
//        int[] testappids = {828580, 485670, 582330, 48720};
//        for(int i : testappids)
//        {
//            CardSet test;
//            SteamAPI temp = new SteamAPI();
//            try
//            {
//                test = temp.getCardSet(i);
//                Thread.sleep(1000);
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//                return;
//            }
//            System.out.println(test.getSetPrice());
//            Card[] cards = test.getCards();
//            for (Card card : cards)
//            {
//                System.out.println(card.getName() + ": " + card.getPrice());
//            }
//        }
        try
        {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM games"; 
            ResultSet rset = stmt.executeQuery(sql);
            System.out.println("Query Success");
        }
        catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        
        JFrame guiFrame = new JFrame();
        guiFrame.setUndecorated(true);
        guiFrame.add(new cardView(guiFrame));
        guiFrame.pack();
        guiFrame.setBackground(new Color(0, 255, 0, 0));
        guiFrame.setLocationRelativeTo(null);
        //ComponentResizer cr = new ComponentResizer();
        //cr.registerComponent(guiFrame);
        //ImageIcon icon = new ImageIcon("/steamtradingcardproject/resources/steamCardIcon.png");
        
        //Image image = ImageIO.read("/me/spedwards/program/Icon.ico");
        //guiFrame.setIconImage(icon.getImage());
        guiFrame.setVisible(true);
        
        try
        {
            if(conn!=null)
                conn.close();
            System.out.println("Connection closed.");
        }
        catch(SQLException se)
        {
         se.printStackTrace();
        }
    }
    
}
