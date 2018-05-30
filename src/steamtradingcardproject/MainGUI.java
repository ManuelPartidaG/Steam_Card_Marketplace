/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject;

import java.awt.Color;
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
    }
    
}
