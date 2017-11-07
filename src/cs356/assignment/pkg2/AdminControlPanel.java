/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
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
        
        setTitle("Simple example");
        setSize(1400, 1000);
        setLocationRelativeTo(null);
        UserGroup top = new UserGroup("Students");
        top.add(new User("Joshua Camacho"));
        
        UserGroup middle = new UserGroup("Bad students");
        middle.add(new User("Danielle"));
        top.add(middle);
        
        JTree tree = new JTree(top);
        JScrollPane treeView = new JScrollPane(tree);
        this.add(treeView);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
}