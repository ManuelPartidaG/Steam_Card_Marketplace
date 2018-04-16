/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Steam_Card_Marketplace;




import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author 1matt
 */
class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
	int baslangciX = 0;
    int baslangciY = 0;
        
    int bitisX = getSize().width;
    int bitisY= getSize().height;
	g.drawImage(img,baslangciX,baslangciY,bitisX,bitisY,null);
  }
}
/**
 *
 * @author manuelpartida
 */
public class Background extends javax.swing.JFrame {

    /**
     * Creates new form Background
     */
    public Background() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new ImagePanel(new ImageIcon("/Users/manuelpartida/Desktop/background1.png").getImage());
        Title = new javax.swing.JLabel();
        Filter_menu = new javax.swing.JComboBox<>();
        Searchbar = new javax.swing.JTextField();
        Slot1 = new javax.swing.JPanel();
        Slot2 = new javax.swing.JPanel();
        Search_button = new javax.swing.JButton();
        Name11 = new javax.swing.JLabel();
        Slot3 = new javax.swing.JPanel();
        Slot4 = new javax.swing.JPanel();
        Slot5 = new javax.swing.JPanel();
        Slot6 = new javax.swing.JPanel();
        Slot8 = new javax.swing.JPanel();
        Slot9 = new javax.swing.JPanel();
        Slot7 = new javax.swing.JPanel();
        Slot10 = new javax.swing.JPanel();
        Slot11 = new javax.swing.JPanel();
        Name4 = new javax.swing.JLabel();
        Name7 = new javax.swing.JLabel();
        Name3 = new javax.swing.JLabel();
        Price2 = new javax.swing.JLabel();
        Name5 = new javax.swing.JLabel();
        Name8 = new javax.swing.JLabel();
        Name9 = new javax.swing.JLabel();
        Slot12 = new javax.swing.JPanel();
        Name6 = new javax.swing.JLabel();
        Name10 = new javax.swing.JLabel();
        Name12 = new javax.swing.JLabel();
        Name1 = new javax.swing.JLabel();
        Name2 = new javax.swing.JLabel();
        Price3 = new javax.swing.JLabel();
        Price4 = new javax.swing.JLabel();
        Price5 = new javax.swing.JLabel();
        Price7 = new javax.swing.JLabel();
        Price6 = new javax.swing.JLabel();
        Price8 = new javax.swing.JLabel();
        Price9 = new javax.swing.JLabel();
        Price10 = new javax.swing.JLabel();
        Price11 = new javax.swing.JLabel();
        Price12 = new javax.swing.JLabel();
        Price1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        Title.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setText("Steam Trading Card Marketplace");
        jPanel1.add(Title);
        Title.setBounds(10, 10, 300, 60);

        Filter_menu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card", "Set", "Game", "Price" }));
        jPanel1.add(Filter_menu);
        Filter_menu.setBounds(320, 30, 91, 27);

        Searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbarActionPerformed(evt);
            }
        });
        jPanel1.add(Searchbar);
        Searchbar.setBounds(430, 30, 180, 26);

        Slot1.setBackground(new java.awt.Color(255, 255, 204));
        Slot1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot1Layout = new javax.swing.GroupLayout(Slot1);
        Slot1.setLayout(Slot1Layout);
        Slot1Layout.setHorizontalGroup(
            Slot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot1Layout.setVerticalGroup(
            Slot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot1);
        Slot1.setBounds(20, 100, 100, 100);

        Slot2.setBackground(new java.awt.Color(255, 255, 204));
        Slot2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot2Layout = new javax.swing.GroupLayout(Slot2);
        Slot2.setLayout(Slot2Layout);
        Slot2Layout.setHorizontalGroup(
            Slot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot2Layout.setVerticalGroup(
            Slot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot2);
        Slot2.setBounds(140, 100, 100, 100);

        Search_button.setText("Search");
        jPanel1.add(Search_button);
        Search_button.setBounds(610, 30, 85, 29);

        Name11.setForeground(new java.awt.Color(255, 255, 255));
        Name11.setText("Name:");
        jPanel1.add(Name11);
        Name11.setBounds(500, 350, 100, 20);

        Slot3.setBackground(new java.awt.Color(255, 255, 204));
        Slot3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot3Layout = new javax.swing.GroupLayout(Slot3);
        Slot3.setLayout(Slot3Layout);
        Slot3Layout.setHorizontalGroup(
            Slot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot3Layout.setVerticalGroup(
            Slot3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot3);
        Slot3.setBounds(260, 100, 100, 100);

        Slot4.setBackground(new java.awt.Color(255, 255, 204));
        Slot4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot4Layout = new javax.swing.GroupLayout(Slot4);
        Slot4.setLayout(Slot4Layout);
        Slot4Layout.setHorizontalGroup(
            Slot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot4Layout.setVerticalGroup(
            Slot4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot4);
        Slot4.setBounds(380, 100, 100, 100);

        Slot5.setBackground(new java.awt.Color(255, 255, 204));
        Slot5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot5Layout = new javax.swing.GroupLayout(Slot5);
        Slot5.setLayout(Slot5Layout);
        Slot5Layout.setHorizontalGroup(
            Slot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot5Layout.setVerticalGroup(
            Slot5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot5);
        Slot5.setBounds(500, 100, 100, 100);

        Slot6.setBackground(new java.awt.Color(255, 255, 204));
        Slot6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot6Layout = new javax.swing.GroupLayout(Slot6);
        Slot6.setLayout(Slot6Layout);
        Slot6Layout.setHorizontalGroup(
            Slot6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot6Layout.setVerticalGroup(
            Slot6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot6);
        Slot6.setBounds(620, 100, 100, 100);

        Slot8.setBackground(new java.awt.Color(255, 255, 204));
        Slot8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot8Layout = new javax.swing.GroupLayout(Slot8);
        Slot8.setLayout(Slot8Layout);
        Slot8Layout.setHorizontalGroup(
            Slot8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot8Layout.setVerticalGroup(
            Slot8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot8);
        Slot8.setBounds(140, 250, 100, 100);

        Slot9.setBackground(new java.awt.Color(255, 255, 204));
        Slot9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot9Layout = new javax.swing.GroupLayout(Slot9);
        Slot9.setLayout(Slot9Layout);
        Slot9Layout.setHorizontalGroup(
            Slot9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot9Layout.setVerticalGroup(
            Slot9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot9);
        Slot9.setBounds(260, 250, 100, 100);

        Slot7.setBackground(new java.awt.Color(255, 255, 204));
        Slot7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot7Layout = new javax.swing.GroupLayout(Slot7);
        Slot7.setLayout(Slot7Layout);
        Slot7Layout.setHorizontalGroup(
            Slot7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot7Layout.setVerticalGroup(
            Slot7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot7);
        Slot7.setBounds(20, 250, 100, 100);

        Slot10.setBackground(new java.awt.Color(255, 255, 204));
        Slot10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot10Layout = new javax.swing.GroupLayout(Slot10);
        Slot10.setLayout(Slot10Layout);
        Slot10Layout.setHorizontalGroup(
            Slot10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot10Layout.setVerticalGroup(
            Slot10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot10);
        Slot10.setBounds(380, 250, 100, 100);

        Slot11.setBackground(new java.awt.Color(255, 255, 204));
        Slot11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot11Layout = new javax.swing.GroupLayout(Slot11);
        Slot11.setLayout(Slot11Layout);
        Slot11Layout.setHorizontalGroup(
            Slot11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot11Layout.setVerticalGroup(
            Slot11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot11);
        Slot11.setBounds(500, 250, 100, 100);

        Name4.setForeground(new java.awt.Color(255, 255, 255));
        Name4.setText("Name:");
        jPanel1.add(Name4);
        Name4.setBounds(380, 200, 100, 16);

        Name7.setForeground(new java.awt.Color(255, 255, 255));
        Name7.setText("Name:");
        jPanel1.add(Name7);
        Name7.setBounds(20, 350, 100, 16);

        Name3.setForeground(new java.awt.Color(255, 255, 255));
        Name3.setText("Name:");
        jPanel1.add(Name3);
        Name3.setBounds(260, 200, 100, 16);

        Price2.setForeground(new java.awt.Color(255, 255, 255));
        Price2.setText("Price:");
        jPanel1.add(Price2);
        Price2.setBounds(140, 220, 90, 16);

        Name5.setForeground(new java.awt.Color(255, 255, 255));
        Name5.setText("Name:");
        jPanel1.add(Name5);
        Name5.setBounds(500, 200, 100, 16);

        Name8.setForeground(new java.awt.Color(255, 255, 255));
        Name8.setText("Name:");
        jPanel1.add(Name8);
        Name8.setBounds(140, 350, 100, 16);

        Name9.setForeground(new java.awt.Color(255, 255, 255));
        Name9.setText("Name:");
        jPanel1.add(Name9);
        Name9.setBounds(260, 350, 100, 16);

        Slot12.setBackground(new java.awt.Color(255, 255, 204));
        Slot12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 4));

        javax.swing.GroupLayout Slot12Layout = new javax.swing.GroupLayout(Slot12);
        Slot12.setLayout(Slot12Layout);
        Slot12Layout.setHorizontalGroup(
            Slot12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        Slot12Layout.setVerticalGroup(
            Slot12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        jPanel1.add(Slot12);
        Slot12.setBounds(620, 250, 100, 100);

        Name6.setForeground(new java.awt.Color(255, 255, 255));
        Name6.setText("Name:");
        jPanel1.add(Name6);
        Name6.setBounds(620, 200, 100, 16);

        Name10.setForeground(new java.awt.Color(255, 255, 255));
        Name10.setText("Name:");
        jPanel1.add(Name10);
        Name10.setBounds(380, 350, 100, 16);

        Name12.setForeground(new java.awt.Color(255, 255, 255));
        Name12.setText("Name:");
        jPanel1.add(Name12);
        Name12.setBounds(620, 350, 100, 20);

        Name1.setForeground(new java.awt.Color(255, 255, 255));
        Name1.setText("Name:");
        jPanel1.add(Name1);
        Name1.setBounds(20, 200, 90, 20);

        Name2.setForeground(new java.awt.Color(255, 255, 255));
        Name2.setText("Name:");
        jPanel1.add(Name2);
        Name2.setBounds(140, 200, 100, 20);

        Price3.setForeground(new java.awt.Color(255, 255, 255));
        Price3.setText("Price:");
        jPanel1.add(Price3);
        Price3.setBounds(260, 220, 90, 16);

        Price4.setForeground(new java.awt.Color(255, 255, 255));
        Price4.setText("Price:");
        jPanel1.add(Price4);
        Price4.setBounds(380, 220, 90, 16);

        Price5.setForeground(new java.awt.Color(255, 255, 255));
        Price5.setText("Price:");
        jPanel1.add(Price5);
        Price5.setBounds(500, 220, 90, 16);

        Price7.setForeground(new java.awt.Color(255, 255, 255));
        Price7.setText("Price:");
        jPanel1.add(Price7);
        Price7.setBounds(20, 370, 90, 16);

        Price6.setForeground(new java.awt.Color(255, 255, 255));
        Price6.setText("Price:");
        jPanel1.add(Price6);
        Price6.setBounds(620, 220, 90, 16);

        Price8.setForeground(new java.awt.Color(255, 255, 255));
        Price8.setText("Price:");
        jPanel1.add(Price8);
        Price8.setBounds(140, 370, 90, 16);

        Price9.setForeground(new java.awt.Color(255, 255, 255));
        Price9.setText("Price:");
        jPanel1.add(Price9);
        Price9.setBounds(260, 370, 90, 16);

        Price10.setForeground(new java.awt.Color(255, 255, 255));
        Price10.setText("Price:");
        jPanel1.add(Price10);
        Price10.setBounds(380, 370, 90, 16);

        Price11.setForeground(new java.awt.Color(255, 255, 255));
        Price11.setText("Price:");
        jPanel1.add(Price11);
        Price11.setBounds(500, 370, 90, 16);

        Price12.setForeground(new java.awt.Color(255, 255, 255));
        Price12.setText("Price:");
        jPanel1.add(Price12);
        Price12.setBounds(620, 370, 90, 16);

        Price1.setForeground(new java.awt.Color(255, 255, 255));
        Price1.setText("Price:");
        jPanel1.add(Price1);
        Price1.setBounds(20, 220, 90, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchbarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Background.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Background.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Background.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Background.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Background().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Filter_menu;
    private javax.swing.JLabel Name1;
    private javax.swing.JLabel Name10;
    private javax.swing.JLabel Name11;
    private javax.swing.JLabel Name12;
    private javax.swing.JLabel Name2;
    private javax.swing.JLabel Name3;
    private javax.swing.JLabel Name4;
    private javax.swing.JLabel Name5;
    private javax.swing.JLabel Name6;
    private javax.swing.JLabel Name7;
    private javax.swing.JLabel Name8;
    private javax.swing.JLabel Name9;
    private javax.swing.JLabel Price1;
    private javax.swing.JLabel Price10;
    private javax.swing.JLabel Price11;
    private javax.swing.JLabel Price12;
    private javax.swing.JLabel Price2;
    private javax.swing.JLabel Price3;
    private javax.swing.JLabel Price4;
    private javax.swing.JLabel Price5;
    private javax.swing.JLabel Price6;
    private javax.swing.JLabel Price7;
    private javax.swing.JLabel Price8;
    private javax.swing.JLabel Price9;
    private javax.swing.JButton Search_button;
    private javax.swing.JTextField Searchbar;
    private javax.swing.JPanel Slot1;
    private javax.swing.JPanel Slot10;
    private javax.swing.JPanel Slot11;
    private javax.swing.JPanel Slot12;
    private javax.swing.JPanel Slot2;
    private javax.swing.JPanel Slot3;
    private javax.swing.JPanel Slot4;
    private javax.swing.JPanel Slot5;
    private javax.swing.JPanel Slot6;
    private javax.swing.JPanel Slot7;
    private javax.swing.JPanel Slot8;
    private javax.swing.JPanel Slot9;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}