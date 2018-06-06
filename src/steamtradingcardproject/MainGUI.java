/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject;

import java.awt.Color;
import javax.swing.JFrame;
import steamtradingcardproject.view.cardView;

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
        JFrame guiFrame = new JFrame();
        guiFrame.setUndecorated(true);
        guiFrame.add(new cardView(guiFrame));
        guiFrame.pack();
        guiFrame.setBackground(new Color(0, 255, 0, 0));
        guiFrame.setLocationRelativeTo(null);
        guiFrame.setVisible(true);
    }
    
}
