/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.controller;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author sysadmin
 */
public class Controller {
    public void handleClose() {
        System.exit(0);
    }

    public void handleMinimizeAction(Container topLevelAncestor) {
        JFrame frame = (JFrame) topLevelAncestor;
        frame.setExtendedState(JFrame.ICONIFIED);
    }

    public void handleMaximizeAction(Container topLevelAncestor) {
        JFrame frame = (JFrame) topLevelAncestor;
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void handleRestoreAction(Container topLevelAncestor) {
        JFrame frame = (JFrame) topLevelAncestor;
        frame.setExtendedState(JFrame.NORMAL);
    }
}
