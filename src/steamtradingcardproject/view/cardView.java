/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import steamtradingcardproject.controller.Controller;

/**
 *
 * @author sysadmin
 */
public class cardView extends javax.swing.JPanel {
    
    private final Image image;
    private final ImageIcon winClose, winCloseHover, winMinimize, winMinimizeHover, winMaximize, winMaximizeHover;
    private final Controller controller;
    private int xMouse;
    private int yMouse;
    
    public cardView() {
        initComponents();
        this.setPreferredSize(new Dimension(706, 384));
        this.setDoubleBuffered(true);
        this.setOpaque(false);
        winClose = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_close.png"));
        winCloseHover = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_close_hover.png"));
        winMinimize = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_min.png"));
        winMinimizeHover = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_min_hover.png"));
        winMaximize = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_max.png"));
        winMaximizeHover = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_max_hover.png"));
        this.image = new ImageIcon(getClass().getResource("/steamtradingcardproject/resources/projectTemplate.png")).getImage();
        
        this.controller = new Controller();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeWindow = new javax.swing.JLabel();
        minimizeWindow = new javax.swing.JLabel();
        maximizeWindow = new javax.swing.JLabel();
        dragWindow = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(706, 384));
        setLayout(null);

        closeWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_close.png"))); // NOI18N
        closeWindow.setText("jLabel1");
        closeWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeWindowHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeWindowHoverOutHandler(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeWindowHoverInHandler(evt);
            }
        });
        add(closeWindow);
        closeWindow.setBounds(680, 10, 14, 18);

        minimizeWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_min.png"))); // NOI18N
        minimizeWindow.setText("jLabel3");
        minimizeWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeWindowHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeWindowHoverOutHandler(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeWindowHoverInHandler(evt);
            }
        });
        add(minimizeWindow);
        minimizeWindow.setBounds(640, 10, 14, 18);

        maximizeWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_max.png"))); // NOI18N
        maximizeWindow.setText("jLabel2");
        maximizeWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximizeWindowHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maximizeWindowHoverOutHandler(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maximizeWindowHoverInHandler(evt);
            }
        });
        add(maximizeWindow);
        maximizeWindow.setBounds(660, 10, 14, 18);

        dragWindow.setText("    Steam Trading Card Project");
        dragWindow.setAlignmentY(0.0F);
        dragWindow.setMaximumSize(new java.awt.Dimension(600, 30));
        dragWindow.setMinimumSize(new java.awt.Dimension(201, 18));
        dragWindow.setPreferredSize(new java.awt.Dimension(600, 30));
        dragWindow.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragWindowMouseDragged(evt);
            }
        });
        dragWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragWindowMousePressed(evt);
            }
        });
        add(dragWindow);
        dragWindow.setBounds(0, 0, 710, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void closeWindowHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeWindowHandler
        // TODO add your handling code here:
        this.controller.handleClose();
    }//GEN-LAST:event_closeWindowHandler

    private void closeWindowHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeWindowHoverInHandler
        // TODO add your handling code here:
        closeWindow.setIcon(winCloseHover);
    }//GEN-LAST:event_closeWindowHoverInHandler

    private void closeWindowHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeWindowHoverOutHandler
        // TODO add your handling code here:
        closeWindow.setIcon(winClose);
    }//GEN-LAST:event_closeWindowHoverOutHandler

    private void maximizeWindowHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizeWindowHandler
        // TODO add your handling code here:
        this.controller.handleMaximizeAction(getTopLevelAncestor());
    }//GEN-LAST:event_maximizeWindowHandler

    private void maximizeWindowHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizeWindowHoverInHandler
        // TODO add your handling code here:
        maximizeWindow.setIcon(winMaximizeHover);
    }//GEN-LAST:event_maximizeWindowHoverInHandler

    private void maximizeWindowHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizeWindowHoverOutHandler
        // TODO add your handling code here:
        maximizeWindow.setIcon(winMaximize);
    }//GEN-LAST:event_maximizeWindowHoverOutHandler

    private void minimizeWindowHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeWindowHandler
        // TODO add your handling code here:
        minimizeWindow.setIcon(winMinimize);                                    // this is not working for some reason idk why
        this.controller.handleMinimizeAction(getTopLevelAncestor());
    }//GEN-LAST:event_minimizeWindowHandler

    private void minimizeWindowHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeWindowHoverInHandler
        // TODO add your handling code here:
        minimizeWindow.setIcon(winMinimizeHover);
    }//GEN-LAST:event_minimizeWindowHoverInHandler

    private void minimizeWindowHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeWindowHoverOutHandler
        // TODO add your handling code here:
        minimizeWindow.setIcon(winMinimize);
    }//GEN-LAST:event_minimizeWindowHoverOutHandler

    private void dragWindowMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragWindowMouseDragged
        // TODO add your handling code here:
        //JFrame guiFrame;
        //guiFrame = (JFrame) getTopLevelAncestor();
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        //System.out.println(x + "," + y);
        getTopLevelAncestor().setLocation(x - xMouse, y - yMouse);
        
    }//GEN-LAST:event_dragWindowMouseDragged

    private void dragWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragWindowMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_dragWindowMousePressed
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(this.image, 0, 0, null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeWindow;
    private javax.swing.JLabel dragWindow;
    private javax.swing.JLabel maximizeWindow;
    private javax.swing.JLabel minimizeWindow;
    // End of variables declaration//GEN-END:variables
}
