/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory; 
import static javax.swing.Box.createVerticalGlue;
import javax.swing.BoxLayout;
import steamtradingcardproject.model.Card;
import java.awt.Desktop;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;


/**
 *
 * @author 1matt
 */
public class CardImage extends JPanel{
   
  
    
    public CardImage(Card c) {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        String iconUrl = c.getIconUrl();
        //BufferedImage image;
        JLabel icon = new JLabel();
        this.add(createVerticalGlue());
        try{
        URL url = new URL("https://steamcommunity-a.akamaihd.net/economy/image/" + iconUrl+"/140x120");
        URLConnection con = url.openConnection();
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        InputStream in = con.getInputStream();
        Image img = ImageIO.read(in);
        icon.setIcon(new ImageIcon(img));
        if (img != null)
            icon.setIcon(new ImageIcon(img));
        else {
            ImageIcon defaultImg = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/steamCardIcon.png"));
            icon.setIcon(defaultImg);
        }
        this.add(icon);
        }
        catch (Exception e){
            ImageIcon img = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/steamCardIcon.png"));
            icon.setIcon(img);
            this.add(icon);
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
        icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               if (Desktop.isDesktopSupported()) {
                   try {
                       String tempHash = c.getHashName().replace(" ", "%20");
                       Desktop.getDesktop().browse(new URI("https://steamcommunity.com/market/listings/753/" + tempHash));
                   } catch (Exception e) {
                       e.printStackTrace();
                       System.out.println("Oops");  
                   }
                }
            }
        });
    }
    
    
   
}