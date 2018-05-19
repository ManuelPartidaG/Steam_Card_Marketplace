/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.LayoutManager;

import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import steamtradingcardproject.model.Card;



/**
 *
 * @author 1matt
 */
public class CardImage extends JPanel{
    
    
    
    public CardImage(Card c) {
        String iconUrl = c.getIconUrl();
        BufferedImage image;
        JLabel ic = new JLabel();
        try{
         image = ImageIO.read(new URL("https://steamcommunity-a.akamaihd.net/economy/image/" + iconUrl+"/140x120") );
         ic.setIcon(new ImageIcon(image));
         
         this.add(ic);
         
        }
        catch (Exception e){
            System.out.println("Oops");
        }
        
        
        
        
        
        JLabel info = new JLabel();
        info.setText("<html>Price: " + c.getPrice() + " cents<br>");
        
       // JLabel name = new JLabel();
        
        if(c.getName().length() > 20) {
            String s1 = c.getName().substring(0,20);
            String s2 = c.getName().substring(20,c.getName().length());
            info.setText("<html>     Price: " + c.getPrice() + " cents<br>" + s1 + "<br>" + s2);
            
        }else {
            info.setText("<html>Price: " + c.getPrice() + " cents<br>" + c.getName());
        }
        
        
        
        
        //name.setLayout(new FlowLayout());
        info.setBounds(30, 60, 300, 100);
       // price.setLayout(new FlowLayout());
       //price.setLocation(200, 4);
        //price.setBounds(5, 40, 300, 120);
        
        
        //image img = new image(c.getIconUrl());
        
        
        //this.setLayout(null);
        this.setVisible(true);
        //this.add(img);
        ;this.add(info);
        
       
        //this.setSize(500,500);
        this.setBounds(20,20,150,200);
        this.setBackground(Color.white);
        
       
        Border blackline;
         blackline = BorderFactory.createLineBorder(Color.black);
         this.setBorder(blackline);
    }
}

class image extends JPanel{
    String iconUrl;
    Image image;
    public image(String iconUrl) {
      
        this.setVisible(true);
        this.setSize(70,70);   
        this.iconUrl = iconUrl;
        this.setLocation(25, 4);
        //this.setBackground(Color.red);
        
        
    }
    
    protected void painComponent(Graphics g ){
        super.paintComponent(g);
        
        
        int baslangciX = 0;
        int baslangciY = 0;
        
        int bitisX = getSize().width;
        int bitisY= getSize().height;
        
        g.drawImage(image,baslangciX,baslangciY,null);
    }
    
}