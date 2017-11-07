/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.awt.EventQueue;

/**
 *
 * @author Josh
 */
public class Cs356Assignment2 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            AdminControlPanel ex = new AdminControlPanel();
            ex.setVisible(true);
        });
    }
    
}
