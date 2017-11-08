/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Josh
 */
public class UserView extends JFrame {
    User user;
    UserView(User user){
        this.user=user;
        makeUI();
    }
    private void makeUI(){
        this.setLayout(new GridLayout(0,1));
        JPanel addUser = new JPanel();
        addUser.setLayout(new GridLayout(1,2));
        addUser.add(new JTextField());
        addUser.add(new JButton("add"));
        this.add(addUser);
        this.add(new JList());
        
        JPanel tweet = new JPanel();
        addUser.setLayout(new GridLayout(1,2));
        addUser.add(new JTextField());
        addUser.add(new JButton("tweet"));
        this.add(tweet);
        this.add(new JList());
    };
}
