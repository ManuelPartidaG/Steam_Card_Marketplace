/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import steamtradingcardproject.controller.Controller;

/**
 *
 * @author sysadmin
 */
public class cardView extends javax.swing.JPanel {
    
    private final Image image;
    private final JFrame guiFrame;
    private final ImageIcon winClose, winCloseHover, winMinimize, winMinimizeHover, winMaximize, winMaximizeHover, winRestore, winRestoreHover, winResize, winResizeHover;
    private final Controller controller;
    private int prevWindowState;
    private int xMouse;
    private int yMouse;
    private int windowSizeX, windowSizeY;
    
    public cardView(JFrame topLevelFrame) {
        guiFrame = topLevelFrame;
        prevWindowState = Frame.NORMAL;
        initComponents();
        this.setDoubleBuffered(true);
        this.setOpaque(false);
        winClose = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_close.png"));
        winCloseHover = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_close_hover.png"));
        winMinimize = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_min.png"));
        winMinimizeHover = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_min_hover.png"));
        winMaximize = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_max.png"));
        winMaximizeHover = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_max_hover.png"));
        winRestore = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_restore.png"));
        winRestoreHover = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_restore_hover.png"));
        winResize = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/resizer.png"));
        winResizeHover = new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/resizer_over.png"));
        this.image = new ImageIcon(getClass().getResource("/steamtradingcardproject/resources/clienttexture2.png")).getImage();
        restoreWindow.setEnabled(false);
        restoreWindow.setVisible(false);
        this.controller = new Controller();
       guiFrame.addWindowListener(new WindowListener() {
            //made a bunch of listeners by default since WindowListener is not an abstract class just ignore i guess
            @Override
            public void windowIconified(WindowEvent e) {
            }
            @Override
            public void windowOpened(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                guiFrame.setExtendedState(prevWindowState);
                minimizeWindow.setIcon(winMinimize);
                repaint();
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
       
       
       
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
        restoreWindow = new javax.swing.JLabel();
        dragWindow = new javax.swing.JLabel();
        windowResizer = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(700, 400));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                windowResizeHandler(evt);
            }
        });
        setLayout(null);

        closeWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_close.png"))); // NOI18N
        closeWindow.setToolTipText("");
        closeWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeWindowHandler(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeWindowHoverInHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeWindowHoverOutHandler(evt);
            }
        });
        add(closeWindow);
        closeWindow.setBounds(800, 10, 30, 20);

        minimizeWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_min.png"))); // NOI18N
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
        minimizeWindow.setBounds(760, 0, 20, 30);

        maximizeWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_max.png"))); // NOI18N
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
        maximizeWindow.setBounds(780, 10, 20, 20);

        restoreWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/win32_win_restore.png"))); // NOI18N
        restoreWindow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restoreWindowHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restoreWindowHoverOutHandler(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restoreWindowHoverInHandler(evt);
            }
        });
        add(restoreWindow);
        restoreWindow.setBounds(780, 10, 10, 20);

        dragWindow.setText("    Steam Trading Card Project");
        dragWindow.setAlignmentY(0.0F);
        dragWindow.setMaximumSize(null);
        dragWindow.setMinimumSize(null);
        dragWindow.setPreferredSize(new java.awt.Dimension(700, 30));
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
        dragWindow.setBounds(130, 0, 600, 40);

        windowResizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/steamtradingcardproject/resources/resizer.png"))); // NOI18N
        windowResizer.setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));
        windowResizer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                windowResizerDragged(evt);
            }
        });
        windowResizer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                windowResizerMousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                windowResizerHoverOutHandler(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                windowResizerHoverInHandler(evt);
            }
        });
        add(windowResizer);
        windowResizer.setBounds(810, 390, 20, 30);
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
        maximizeWindow.setEnabled(false);
        maximizeWindow.setVisible(false);
        restoreWindow.setEnabled(true);
        restoreWindow.setVisible(true);
        windowResizer.setEnabled(false);
        windowResizer.setVisible(false);
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
        prevWindowState = guiFrame.getExtendedState();
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
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        getTopLevelAncestor().setLocation(x - xMouse, y - yMouse);
        
    }//GEN-LAST:event_dragWindowMouseDragged

    private void dragWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragWindowMousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_dragWindowMousePressed

    private void windowResizeHandler(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_windowResizeHandler
        // TODO add your handling code here:
        int panelWidth = getSize().width;
        int panelHeight = getSize().height;
        closeWindow.setBounds(panelWidth - 20, 10, 14, 18);
        maximizeWindow.setBounds(panelWidth - 40, 10, 14, 18);
        restoreWindow.setBounds(panelWidth - 40, 10, 14, 18);
        minimizeWindow.setBounds(panelWidth - 60, 10, 14, 18);
        windowResizer.setBounds(panelWidth - 15, panelHeight - 18, 14, 18);
        dragWindow.setBounds(0, 0, panelWidth, 30);
    }//GEN-LAST:event_windowResizeHandler

    private void restoreWindowHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreWindowHandler
        // TODO add your handling code here:
        this.controller.handleRestoreAction(getTopLevelAncestor());
        maximizeWindow.setEnabled(true);
        maximizeWindow.setVisible(true);
        restoreWindow.setEnabled(false);
        restoreWindow.setVisible(false);
        windowResizer.setEnabled(true);
        windowResizer.setVisible(true);
    }//GEN-LAST:event_restoreWindowHandler

    private void restoreWindowHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreWindowHoverInHandler
        // TODO add your handling code here:
        restoreWindow.setIcon(winRestoreHover);
    }//GEN-LAST:event_restoreWindowHoverInHandler

    private void restoreWindowHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreWindowHoverOutHandler
        // TODO add your handling code here:
        restoreWindow.setIcon(winRestore);
    }//GEN-LAST:event_restoreWindowHoverOutHandler

    private void windowResizerHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowResizerHoverOutHandler
        // TODO add your handling code here:
        windowResizer.setIcon(winResize);
    }//GEN-LAST:event_windowResizerHoverOutHandler

    private void windowResizerHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowResizerHoverInHandler
        // TODO add your handling code here:
        windowResizer.setIcon(winResizeHover);
    }//GEN-LAST:event_windowResizerHoverInHandler

    private void windowResizerDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowResizerDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        getTopLevelAncestor().setSize(windowSizeX + (x - xMouse), windowSizeY + (y - yMouse));
    }//GEN-LAST:event_windowResizerDragged

    private void windowResizerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowResizerMousePressed
        // TODO add your handling code here:
        xMouse = evt.getXOnScreen();
        yMouse = evt.getYOnScreen();
        windowSizeX = getBounds().width;
        windowSizeY = getBounds().height;
    }//GEN-LAST:event_windowResizerMousePressed
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D g2D = (Graphics2D) g;
        int panelWidth = getSize().width;
        int panelHieght = getSize().height;
        g.setColor(new Color(38,38,38));
        g.fillRect(0, 0, panelWidth, panelHieght);
        g.setColor(new Color(22,22,22));
        g.fillRect(12, 46, panelWidth - 24, panelHieght - 75);
        g.setColor(new Color(27, 40, 56));
        g.fillRect(14, 48, panelWidth - 28, panelHieght - 79);
        g.drawImage(this.image, 0, 0, panelWidth, 60, null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeWindow;
    private javax.swing.JLabel dragWindow;
    private javax.swing.JLabel maximizeWindow;
    private javax.swing.JLabel minimizeWindow;
    private javax.swing.JLabel restoreWindow;
    private javax.swing.JLabel windowResizer;
    // End of variables declaration//GEN-END:variables
}
