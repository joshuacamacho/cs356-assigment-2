/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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
        UserGroup top = new UserGroup("Users");
        top.add(new User("Joshua Camacho"));
        
        UserGroup middle = new UserGroup("Bad students");
        middle.add(new User("Danielle"));
        top.add(middle);
        
        JTree tree = new JTree(top);
        JScrollPane treeView = new JScrollPane(tree);
        this.add(treeView);
        expandTree(tree);
        
        
        
        //add user buttons
        JPanel addUser = new JPanel();
        addUser.setLayout(new GridLayout(2,2));
        JTextField addUserTextField = new JTextField();
        addUser.add(addUserTextField);
        JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!addUserTextField.getText().isEmpty()){
                    try{
                        UserGroup u = (UserGroup)tree.getLastSelectedPathComponent();
                        if(u.getAllowsChildren()){
                            DefaultTreeModel modal = (DefaultTreeModel) tree.getModel();
                            u.add(new User(addUserTextField.getText()));
                            modal.reload();
                            expandTree(tree);
                        }
                    }catch(ClassCastException error){
                        //not userGroup
                    }
                }
            }
        });
        addUser.add(addUserButton);
        
        
        // Add usergroup button
        JTextField addUserGroupTextField = new JTextField();
        addUser.add(addUserGroupTextField);
        JButton addUserGroupButton = new JButton("Add UserGroup");
        
        // Listen for button press
        addUserGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!addUserGroupTextField.getText().isEmpty()){
                    try{
                        UserGroup u = (UserGroup)tree.getLastSelectedPathComponent();
                        if(u.getAllowsChildren()){
                            DefaultTreeModel modal = (DefaultTreeModel) tree.getModel();
                            u.add(new UserGroup(addUserGroupTextField.getText()));
                            modal.reload();
                            expandTree(tree);
                        }
                    }catch(ClassCastException error){
                        //not userGroup
                    }
                }
            }
        });
        
        
        addUser.add(addUserGroupButton);
        
        JPanel threeSections = new JPanel();
        threeSections.setLayout(new GridLayout(3,1));
        threeSections.add(addUser);
        
        
        //user profile button
        JButton userProfileButton = new JButton("User Profile");
        userProfileButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                User u = (User)tree.getLastSelectedPathComponent();
                UserView userview = new UserView(u);
                userview.setSize(600, 600);
                userview.setTitle("User View");
                userview.SetActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        JTextField j = (JTextField)ae.getSource();
                        String searchID = j.getText();
                        System.out.println(searchID);
                        User toSub = (User)top.find(searchID);
                        System.out.println(u.name+" subscribing to "+toSub.name);
                        u.subscribeTo(toSub);
                    }
                });
                userview.setVisible(true);
            }
            
        });
        threeSections.add(userProfileButton);
        
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
    
    private void expandTree(JTree tree){
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }
}