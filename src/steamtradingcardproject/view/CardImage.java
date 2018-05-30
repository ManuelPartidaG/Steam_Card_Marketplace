/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory; 
import static javax.swing.Box.createVerticalGlue;
import javax.swing.BoxLayout;
import steamtradingcardproject.model.Card;


/**
 *
 * @author 1matt
 */
public class CardImage extends JPanel{
    
    public CardImage(Card c) {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        String iconUrl = c.getIconUrl();
        BufferedImage image;
        JLabel icon = new JLabel();
        this.add(createVerticalGlue());
        try{
         image = ImageIO.read(new URL("https://steamcommunity-a.akamaihd.net/economy/image/" + iconUrl+"/140x120") );
         icon.setIcon(new ImageIcon(image));
         this.add(icon);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Oops");                                     //THIS NEEDS TO BE CHANGED TO PROPERLY HANDLE EXCEPTIONS
        }
        JLabel info = new JLabel();
        info.setText("<html><font color=#949494>Price: " + c.getPriceText() + "<br>" + c.getName() + "</font></html>");
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(info);
        this.add(createVerticalGlue());
        this.setVisible(true);
        this.setPreferredSize(new Dimension(140, 180));
        this.setBackground(new Color(38,38,38));
        this.setBorder(BorderFactory.createLineBorder(new Color(22,22,22), 2));
    }
}