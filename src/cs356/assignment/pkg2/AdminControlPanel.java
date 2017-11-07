/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Josh
 */
public class AdminControlPanel extends JFrame {

    public AdminControlPanel() {

        initUI();
    }

    private void initUI() {
        
        setTitle("Admin Control Panel");
        setSize(600, 600);
        setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1,2));
        UserGroup top = new UserGroup("Students");
        top.add(new User("Joshua Camacho"));
        
        UserGroup middle = new UserGroup("Bad students");
        middle.add(new User("Danielle"));
        top.add(middle);
        
        JTree tree = new JTree(top);
        JScrollPane treeView = new JScrollPane(tree);
        this.add(treeView);
        
        
        
        
        //add user buttons
        JPanel addUser = new JPanel();
        addUser.setLayout(new GridLayout(2,2));
        addUser.add(new JTextField());
        addUser.add(new JButton("Button 1"));
        addUser.add(new JTextField());
        addUser.add(new JButton("Button 1"));
        
        JPanel threeSections = new JPanel();
        threeSections.setLayout(new GridLayout(3,1));
        threeSections.add(addUser);
        threeSections.add(new JButton("Button"));
        
        JPanel fourButtons = new JPanel();
        fourButtons.setLayout(new GridLayout(2,2));
        fourButtons.add(new JButton("Button 1"));
        fourButtons.add(new JButton("Button 1"));
        fourButtons.add(new JButton("Button 1"));
        fourButtons.add(new JButton("Button 1"));
        threeSections.add(fourButtons);
        
        this.add(threeSections);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
}