package cs356.assignment.pkg2;

import java.awt.EventQueue;

/**
 * Driver for AdminControlPanel tweet app
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
