/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject;

import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import steamtradingcardproject.view.cardView;

//import steamtradingcardproject.lib.ComponentResizer;

/**
 *
 * @author sysadmin
 */
public class MainGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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