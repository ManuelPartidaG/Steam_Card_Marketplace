/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import steamtradingcardproject.controller.Controller;
import steamtradingcardproject.controller.SteamAPI;
import steamtradingcardproject.model.Card;
import steamtradingcardproject.model.CardSet;
import steamtradingcardproject.model.Game;
import steamtradingcardproject.model.mySqlHelper;


/**
 *
 * @author sysadmin
 */
public class cardView extends javax.swing.JPanel {
    
    private final Image image;
    private final JFrame guiFrame;
    private final ImageIcon winClose, winCloseHover, winMinimize, winMinimizeHover, winMaximize, winMaximizeHover, winRestore, winRestoreHover, winResize, winResizeHover;
    private final Controller controller;
    private final SteamAPI api;
    private final mySqlHelper db;
    private int prevWindowState;
    private int xMouse;
    private int yMouse;
    private int windowSizeX, windowSizeY;
    
    public cardView(JFrame topLevelFrame) {
        guiFrame = topLevelFrame;
        prevWindowState = Frame.NORMAL;
        this.controller = new Controller();
        this.api = new SteamAPI();
        this.db = new mySqlHelper();
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
        try
        {
            gamesComboBox.setModel(new DefaultComboBoxModel(api.getGamesWithCardsSteam()));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),
                "This application need a network connection to run!\nPlease connect to the internet and try again.",
                "Network Error",
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        gamesComboBox.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Game) {
                    if(((Game)value).name.length() > 30)
                        value = ((Game)value).name.substring(0,27) + "...";
                    else
                        value = ((Game)value).name.substring(0, Math.min(((Game)value).name.length(), 30));
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.

            }
        });
        resultsComboBox.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Game) {
                    if(((Game)value).name.length() > 30)
                        value = ((Game)value).name.substring(0,27) + "...";
                    else
                        value = ((Game)value).name.substring(0, Math.min(((Game)value).name.length(), 30));
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.

            }
        });
        this.repaint();
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
        java.awt.GridBagConstraints gridBagConstraints;

        closeWindow = new javax.swing.JLabel();
        minimizeWindow = new javax.swing.JLabel();
        maximizeWindow = new javax.swing.JLabel();
        restoreWindow = new javax.swing.JLabel();
        dragWindow = new javax.swing.JLabel();
        windowResizer = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        //MainPanel.setVisible(false);
        cardPanel = new javax.swing.JPanel();
        gamesComboBox = new javax.swing.JComboBox<>();
        updateCardPanelButton = new javax.swing.JButton();
        priceFilter = new javax.swing.JCheckBox();
        toLabel1 = new javax.swing.JLabel();
        maxPrice = new javax.swing.JTextField();
        number_of_CardsFilter = new javax.swing.JCheckBox();
        minNumber_of_Cards = new javax.swing.JTextField();
        toLabel2 = new javax.swing.JLabel();
        maxNumber_of_Cards = new javax.swing.JTextField();
        resultsLabel = new javax.swing.JLabel();
        resultsComboBox = new javax.swing.JComboBox<>();
        updateButton = new javax.swing.JButton();
        minPrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(700, 400));
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeWindowHoverOutHandler(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeWindowHoverInHandler(evt);
            }
        });
        add(closeWindow);
        closeWindow.setBounds(680, 10, 14, 15);

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
        minimizeWindow.setBounds(640, 10, 14, 15);

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
        maximizeWindow.setBounds(660, 10, 14, 15);

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
        restoreWindow.setBounds(660, 10, 14, 15);

        dragWindow.setForeground(new java.awt.Color(111, 111, 111));
        dragWindow.setText("    Steam Trading Card Project");
        dragWindow.setAlignmentY(0.0F);
        dragWindow.setMaximumSize(null);
        dragWindow.setMinimumSize(null);
        dragWindow.setPreferredSize(new java.awt.Dimension(700, 46));
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
        dragWindow.setBounds(0, 0, 700, 46);

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
        windowResizer.setBounds(814, 444, 20, 20);

        mainPanel.setBackground(new java.awt.Color(27, 40, 56));
        mainPanel.setMinimumSize(new java.awt.Dimension(690, 470));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        cardPanel.setBackground(new java.awt.Color(27, 40, 56));
        cardPanel.setName(""); // NOI18N
        cardPanel.setRequestFocusEnabled(false);
        cardPanel.setLayout(new java.awt.GridLayout(0, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 358;
        gridBagConstraints.ipady = 306;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 2.0;
        mainPanel.add(cardPanel, gridBagConstraints);

        gamesComboBox.setBackground(new java.awt.Color(38, 38, 38));
        gamesComboBox.setForeground(new java.awt.Color(192, 192, 192));
        gamesComboBox.setMaximumRowCount(30);
        gamesComboBox.setToolTipText("");
        gamesComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gamesComboBox.setEditor(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(30, 13, 0, 13);
        mainPanel.add(gamesComboBox, gridBagConstraints);

        updateCardPanelButton.setBackground(new java.awt.Color(38, 38, 38));
        updateCardPanelButton.setForeground(new java.awt.Color(38, 38, 38));
        updateCardPanelButton.setText("<html> <font color=#c4c4c4>Display</font></html>");
        updateCardPanelButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 22, 22), 2), javax.swing.BorderFactory.createEmptyBorder(7, 14, 7, 14)));
        updateCardPanelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayCardsHandler(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        mainPanel.add(updateCardPanelButton, gridBagConstraints);

        priceFilter.setBackground(new java.awt.Color(38, 38, 38));
        priceFilter.setForeground(new java.awt.Color(192, 192, 192));
        priceFilter.setText("Price");
        priceFilter.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 22, 22), 2), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        priceFilter.setBorderPainted(true);
        priceFilter.setMaximumSize(new java.awt.Dimension(156, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        mainPanel.add(priceFilter, gridBagConstraints);

        toLabel1.setForeground(new java.awt.Color(255, 255, 255));
        toLabel1.setText("to");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        mainPanel.add(toLabel1, gridBagConstraints);

        maxPrice.setBackground(new java.awt.Color(38, 38, 38));
        maxPrice.setForeground(new java.awt.Color(192, 192, 192));
        maxPrice.setText("0");
        maxPrice.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 22, 22), 2), javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 5)));
        maxPrice.setMinimumSize(new java.awt.Dimension(26, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        mainPanel.add(maxPrice, gridBagConstraints);

        number_of_CardsFilter.setBackground(new java.awt.Color(38, 38, 38));
        number_of_CardsFilter.setForeground(new java.awt.Color(192, 192, 192));
        number_of_CardsFilter.setText("Number of Cards");
        number_of_CardsFilter.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 22, 22), 2), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        number_of_CardsFilter.setBorderPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 4);
        mainPanel.add(number_of_CardsFilter, gridBagConstraints);

        minNumber_of_Cards.setBackground(new java.awt.Color(38, 38, 38));
        minNumber_of_Cards.setForeground(new java.awt.Color(192, 192, 192));
        minNumber_of_Cards.setText("0");
        minNumber_of_Cards.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 22, 22), 2), javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 5)));
        minNumber_of_Cards.setMinimumSize(new java.awt.Dimension(26, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        mainPanel.add(minNumber_of_Cards, gridBagConstraints);

        toLabel2.setForeground(new java.awt.Color(255, 255, 255));
        toLabel2.setText("to");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        mainPanel.add(toLabel2, gridBagConstraints);

        maxNumber_of_Cards.setBackground(new java.awt.Color(38, 38, 38));
        maxNumber_of_Cards.setForeground(new java.awt.Color(192, 192, 192));
        maxNumber_of_Cards.setText("0");
        maxNumber_of_Cards.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 22, 22), 2), javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 5)));
        maxNumber_of_Cards.setMinimumSize(new java.awt.Dimension(26, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 4);
        mainPanel.add(maxNumber_of_Cards, gridBagConstraints);

        resultsLabel.setBackground(new java.awt.Color(38, 38, 38));
        resultsLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        resultsLabel.setForeground(new java.awt.Color(38, 38, 38));
        resultsLabel.setText("<html> <font color=#c4c4c4>Results</font></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 9, 0);
        mainPanel.add(resultsLabel, gridBagConstraints);
        resultsLabel.getAccessibleContext().setAccessibleName("");

        resultsComboBox.setBackground(new java.awt.Color(38, 38, 38));
        resultsComboBox.setForeground(new java.awt.Color(192, 192, 192));
        resultsComboBox.setMaximumRowCount(30);
        resultsComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 13);
        mainPanel.add(resultsComboBox, gridBagConstraints);

        updateButton.setBackground(new java.awt.Color(38, 38, 38));
        updateButton.setForeground(new java.awt.Color(38, 38, 38));
        updateButton.setText("<html> <font color=#c4c4c4>Update</font></html>");
        updateButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 22, 22), 2), javax.swing.BorderFactory.createEmptyBorder(7, 14, 7, 14)));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.weighty = 0.2;
        mainPanel.add(updateButton, gridBagConstraints);

        minPrice.setBackground(new java.awt.Color(38, 38, 38));
        minPrice.setForeground(new java.awt.Color(192, 192, 192));
        minPrice.setText("0");
        minPrice.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 22, 22), 2), javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 5)));
        minPrice.setMinimumSize(new java.awt.Dimension(26, 26));
        minPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minPriceActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.weightx = 0.01;
        mainPanel.add(minPrice, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(38, 38, 38));
        jButton1.setForeground(new java.awt.Color(38, 38, 38));
        jButton1.setText("<html> <font color=#c4c4c4>Display</font></html>");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 22, 22), 2), javax.swing.BorderFactory.createEmptyBorder(7, 14, 7, 14)));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaySearchedCardsHandler(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        mainPanel.add(jButton1, gridBagConstraints);

        add(mainPanel);
        mainPanel.setBounds(14, 48, 800, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void closeWindowHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeWindowHandler
        this.controller.handleClose();
    }//GEN-LAST:event_closeWindowHandler

    private void closeWindowHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeWindowHoverInHandler
        closeWindow.setIcon(winCloseHover);
    }//GEN-LAST:event_closeWindowHoverInHandler

    private void closeWindowHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeWindowHoverOutHandler
        closeWindow.setIcon(winClose);
    }//GEN-LAST:event_closeWindowHoverOutHandler

    private void maximizeWindowHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizeWindowHandler
        this.controller.handleMaximizeAction(getTopLevelAncestor());
        
        maximizeWindow.setEnabled(false);
        maximizeWindow.setVisible(false);
        restoreWindow.setEnabled(true);
        restoreWindow.setVisible(true);
        windowResizer.setEnabled(false);
        windowResizer.setVisible(false);
        
    }//GEN-LAST:event_maximizeWindowHandler

    private void maximizeWindowHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizeWindowHoverInHandler
        maximizeWindow.setIcon(winMaximizeHover);
    }//GEN-LAST:event_maximizeWindowHoverInHandler

    private void maximizeWindowHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximizeWindowHoverOutHandler
        maximizeWindow.setIcon(winMaximize);
    }//GEN-LAST:event_maximizeWindowHoverOutHandler

    private void minimizeWindowHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeWindowHandler
        prevWindowState = guiFrame.getExtendedState();
        this.controller.handleMinimizeAction(getTopLevelAncestor());
    }//GEN-LAST:event_minimizeWindowHandler

    private void minimizeWindowHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeWindowHoverInHandler
        minimizeWindow.setIcon(winMinimizeHover);
    }//GEN-LAST:event_minimizeWindowHoverInHandler

    private void minimizeWindowHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeWindowHoverOutHandler
        minimizeWindow.setIcon(winMinimize);
    }//GEN-LAST:event_minimizeWindowHoverOutHandler

    private void dragWindowMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragWindowMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        getTopLevelAncestor().setLocation(x - xMouse, y - yMouse);
        
    }//GEN-LAST:event_dragWindowMouseDragged

    private void dragWindowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragWindowMousePressed
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            if(guiFrame.getExtendedState() == JFrame.NORMAL)
                maximizeWindowHandler(evt);
            else if(guiFrame.getExtendedState() == JFrame.MAXIMIZED_BOTH)
            {
                restoreWindowHandler(evt);
            }
       }
        else
        {
            xMouse = evt.getX();
            yMouse = evt.getY();
        }
    }//GEN-LAST:event_dragWindowMousePressed

    private void windowResizeHandler(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_windowResizeHandler
        int panelWidth = getSize().width;
        int panelHeight = getSize().height;
        mainPanel.setBounds(14, 48, panelWidth - 28, panelHeight - 79);
        closeWindow.setBounds(panelWidth - 20, 10, 14, 18);
        maximizeWindow.setBounds(panelWidth - 40, 10, 14, 18);
        restoreWindow.setBounds(panelWidth - 40, 10, 14, 18);
        minimizeWindow.setBounds(panelWidth - 60, 10, 14, 18);
        windowResizer.setBounds(panelWidth - 15, panelHeight - 18, 14, 18);
        dragWindow.setBounds(0, 0, panelWidth, 46);
        validate();
    }//GEN-LAST:event_windowResizeHandler

    private void restoreWindowHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreWindowHandler
        this.controller.handleRestoreAction(getTopLevelAncestor());
        maximizeWindow.setEnabled(true);
        maximizeWindow.setVisible(true);
        restoreWindow.setEnabled(false);
        restoreWindow.setVisible(false);
        windowResizer.setEnabled(true);
        windowResizer.setVisible(true);
    }//GEN-LAST:event_restoreWindowHandler

    private void restoreWindowHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreWindowHoverInHandler
        restoreWindow.setIcon(winRestoreHover);
    }//GEN-LAST:event_restoreWindowHoverInHandler

    private void restoreWindowHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreWindowHoverOutHandler
        restoreWindow.setIcon(winRestore);
    }//GEN-LAST:event_restoreWindowHoverOutHandler

    private void windowResizerHoverOutHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowResizerHoverOutHandler
        windowResizer.setIcon(winResize);
    }//GEN-LAST:event_windowResizerHoverOutHandler

    private void windowResizerHoverInHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowResizerHoverInHandler
        windowResizer.setIcon(winResizeHover);
    }//GEN-LAST:event_windowResizerHoverInHandler

    private void windowResizerDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowResizerDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        getTopLevelAncestor().setSize(windowSizeX + (x - xMouse), windowSizeY + (y - yMouse));
    }//GEN-LAST:event_windowResizerDragged

    private void windowResizerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowResizerMousePressed
        xMouse = evt.getXOnScreen();
        yMouse = evt.getYOnScreen();
        windowSizeX = getBounds().width;
        windowSizeY = getBounds().height;
    }//GEN-LAST:event_windowResizerMousePressed
    
    private void getData(int appid) {
        CardSet result;
        try
        {
            result = api.getCardSet(appid);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(),
                "A network error has occured! \nPlease check your internet connection \nand that you're not ip ban from steam",
                "Network Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        Card[] cards = result.getCards();
        GetImagesThread workers[] = new GetImagesThread[cards.length];
        if(cards.length == 0)
        {
            JLabel jl = new JLabel("<html><font color=#949494>No cards found on market for this Item</font></html>");
            cardPanel.add(jl);
        }
        for (int i = 0; i < cards.length; i++)
        {
            workers[i] = new GetImagesThread(cards[i]);
            workers[i].start();
        }
        for (int i = 0; i < cards.length; i++)
        {
            try
            {
                workers[i].join();
            }
            catch(InterruptedException e)
            {
                System.err.println("Oops");
            }
        }
    }
    
    private void displayCardsHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayCardsHandler
        cardPanel.removeAll();
        getData(((Game)gamesComboBox.getSelectedItem()).appid);
        cardPanel.repaint();
        cardPanel.revalidate();
    }//GEN-LAST:event_displayCardsHandler

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        //Filters and result JComboBox generation
        String lowNumStr;
        String upNumStr;
        int lowNum = 0;
        int upNum = 0;
        String lowPricStr;
        String upPricStr;
        int lowPrice = 0;
        int upPrice = 0;
        
        if(number_of_CardsFilter.isSelected())
        {
            lowNumStr = minNumber_of_Cards.getText().replaceAll("\\.","");
            upNumStr = maxNumber_of_Cards.getText().replaceAll("\\.","");
            lowNum = Integer.parseInt(lowNumStr);
            upNum = Integer.parseInt(upNumStr);
        }
        
        if(priceFilter.isSelected())
        {
            lowPricStr = minPrice.getText().replaceAll("\\.","");
            upPricStr = maxPrice.getText().replaceAll("\\.","");
            lowPrice = Integer.parseInt(lowPricStr);
            upPrice = Integer.parseInt(upPricStr);
        }
        
        db.openHelper();
        resultsComboBox.setModel(new DefaultComboBoxModel(db.filterNumCards(lowNum, upNum, lowPrice, upPrice)));
        db.closeHelper();
        resultsComboBox.setEditable(true);
        JTextComponent editor = (JTextComponent) resultsComboBox.getEditor().getEditorComponent();
        editor.setDocument(new JComboBoxHelper(resultsComboBox));
    }//GEN-LAST:event_updateButtonActionPerformed

    private void displaySearchedCardsHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaySearchedCardsHandler
        if(resultsComboBox.getSelectedItem() != null)
        {
            cardPanel.removeAll();
            getData(((Game)resultsComboBox.getSelectedItem()).appid);
            cardPanel.repaint();
            cardPanel.revalidate();
        }
    }//GEN-LAST:event_displaySearchedCardsHandler

    private void minPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minPriceActionPerformed
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int panelWidth = getSize().width;
        int panelHieght = getSize().height;
        g.setColor(new Color(38,38,38));
        g.fillRect(0, 0, panelWidth, panelHieght);
        g.setColor(new Color(22,22,22));
        g.fillRect(12, 46, panelWidth - 24, panelHieght - 75);
        //g.setColor(new Color(27, 40, 56));
        //g.fillRect(14, 48, panelWidth - 28, panelHieght - 79);
        g.drawImage(this.image, 0, 0, panelWidth, 60, null);
    }
    
    public class GetImagesThread extends Thread
    {
        private final Card card;
        public GetImagesThread(Card c)
        {
            this.card = c;
        }
        @Override
        public void run()
        {
            JPanel jp = new JPanel();
            jp.setVisible(true);
            jp.setLayout(new GridBagLayout());
            jp.setOpaque(false);
            CardImage c = new CardImage(card);
            jp.add(c);
            synchronized(this){
                cardPanel.add(jp);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel closeWindow;
    private javax.swing.JLabel dragWindow;
    private javax.swing.JComboBox<String> gamesComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField maxNumber_of_Cards;
    private javax.swing.JTextField maxPrice;
    private javax.swing.JLabel maximizeWindow;
    private javax.swing.JTextField minNumber_of_Cards;
    private javax.swing.JTextField minPrice;
    private javax.swing.JLabel minimizeWindow;
    private javax.swing.JCheckBox number_of_CardsFilter;
    private javax.swing.JCheckBox priceFilter;
    private javax.swing.JLabel restoreWindow;
    private javax.swing.JComboBox<String> resultsComboBox;
    private javax.swing.JLabel resultsLabel;
    private javax.swing.JLabel toLabel1;
    private javax.swing.JLabel toLabel2;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateCardPanelButton;
    private javax.swing.JLabel windowResizer;
    // End of variables declaration//GEN-END:variables
}
