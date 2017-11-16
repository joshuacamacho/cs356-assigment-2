package cs356.assignment.pkg2;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

/**
 * Admin control panel for tweet application
 * @author Josh
 */
public class AdminControlPanel extends JFrame {
    private static AdminControlPanel panel=null;
    private UserGroup root;
    private AdminControlPanel() {

        initUI();
    }
    
    public static AdminControlPanel getInstance(){
        if(panel==null){
            panel = new AdminControlPanel();
        }
        return panel;
    }
    /**
     * Initialize UI
     */
    private void initUI() {
        // Set Control Panel stuff
        setTitle("Admin Control Panel");
        setSize(1200, 1200);
        setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1,2));
        
        
        // Set tree root with default info
        root = new UserGroup("Users");
        root.add(new User("Joshua Camacho"));
        UserGroup middle = new UserGroup("Bad students");
        middle.add(new User("Danielle"));
        root.add(middle);
        JTree tree = new JTree(root);
        Font font = tree.getFont().deriveFont(24.0f);
        tree.setFont(font);
        JScrollPane treeView = new JScrollPane(tree);
        this.add(treeView);
        expandTree(tree);
        
        
        
        //add user text field and button
        JPanel addUser = new JPanel();
        addUser.setLayout(new GridLayout(2,2));
        JTextField addUserTextField = new JTextField();
        addUserTextField.setFont(font);
        addUser.add(addUserTextField);
        JButton addUserButton = new JButton("Add User");
        addUserButton.setFont(font);
        // add user button listener
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!addUserTextField.getText().isEmpty()){
                    try{
                        UserGroup u = (UserGroup)tree.getLastSelectedPathComponent();
                        if(u==null) u=root;
                        if(u.getAllowsChildren()){
                            DefaultTreeModel modal = (DefaultTreeModel) tree.getModel();
                            u.add(new User(addUserTextField.getText()));
                            modal.reload();
                            expandTree(tree);
                            addUserTextField.setText("");
                        }
                    }catch(ClassCastException error){
                        //not userGroup
                        JOptionPane.showMessageDialog(null, "Cannot add a User to another User");
                    }
                    
                }
            }
        });
        addUser.add(addUserButton);
        
        
        // Add usergroup  textField and button
        JTextField addUserGroupTextField = new JTextField();
        addUserGroupTextField.setFont(font);
        addUser.add(addUserGroupTextField);
        JButton addUserGroupButton = new JButton("Add UserGroup");
        addUserGroupButton.setFont(font);
        
        // Listen for button press
        addUserGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!addUserGroupTextField.getText().isEmpty()){
                    try{
                        UserGroup u = (UserGroup)tree.getLastSelectedPathComponent();
                        if(u==null) u=root;
                        if(u.getAllowsChildren()){
                            DefaultTreeModel modal = (DefaultTreeModel) tree.getModel();
                            u.add(new UserGroup(addUserGroupTextField.getText()));
                            modal.reload();
                            expandTree(tree);
                            addUserGroupTextField.setText("");
                        }
                    }catch(ClassCastException error){
                        //not userGroup
                        JOptionPane.showMessageDialog(null, "Cannot add UserGroup to a user");
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
        userProfileButton.setFont(font);
        userProfileButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                User u = (User)tree.getLastSelectedPathComponent();
                UserView userview = new UserView(u);
                userview.setTitle(u.getName()+"'s profile");
                // New follower event
                userview.SetActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        JTextField j = (JTextField)ae.getSource();
                        String searchID = j.getText();
                        System.out.println(searchID);
                        User toSub = (User)root.find(searchID);
                        j.setText("");
                        if(toSub!=null){
                           System.out.println(u.getName()+" subscribing to "+toSub.getName());
                           u.subscribeTo(toSub); 
                        }else{
                            JOptionPane.showMessageDialog(null, "User "+searchID+" does not exist");
                        }
                        
                    }
                });
                userview.setVisible(true);
            }
            
        });
        threeSections.add(userProfileButton);
        
        JPanel fourButtons = new JPanel();
        fourButtons.setLayout(new GridLayout(2,2));
        
        // total users
        JButton totalUsersButton = new JButton("Total Users");
        totalUsersButton.setFont(font);
        totalUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NodeVisitor v = new UserCountVisitor();
                treeTraverse(root,v);
                JOptionPane.showMessageDialog(null, "Total Users: "+v.getResult());
            }
        });
        fourButtons.add(totalUsersButton);
        
        //total groups
        JButton totalUserGroupsButton = new JButton("Total UserGroups");
        totalUserGroupsButton.setFont(font);
        totalUserGroupsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NodeVisitor v = new UserGroupCountVisitor();
                treeTraverse(root,v);
                JOptionPane.showMessageDialog(null, "Total UserGroups: "+v.getResult());
            }
        });
        fourButtons.add(totalUserGroupsButton);
        
        //total messages
        JButton totalTweetsButton = new JButton("Total Tweets");
        totalTweetsButton.setFont(font);
        totalTweetsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NodeVisitor v = new MessageCountVisitor();
                treeTraverse(root,v);
                JOptionPane.showMessageDialog(null, "Total Tweets: "+v.getResult());
            }
        });
        fourButtons.add(totalTweetsButton);
        
        
        // positive message %
        JButton positiveMessageButton = new JButton("% Positive Messages");
        positiveMessageButton.setFont(font);
        positiveMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NodeVisitor v = new PositiveMessageCountVisitor();
                treeTraverse(root,v);
                JOptionPane.showMessageDialog(null, "Positive Messages : "+v.getResult()+"%");
            }
        });
        
        fourButtons.add(positiveMessageButton);
        threeSections.add(fourButtons);
        
        this.add(threeSections);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }  
    
    /**
     * Expands the rows on a JTree UI elemnent
     * @param tree JTree to expand
     */
    private void expandTree(JTree tree){
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }
    
    /**
     * Recursively traverse tree, breadth first, visit each node with visitor
     * @param node Node to recursively traverse
     * @param v NodeVisitor to call on each node
     */
    private void treeTraverse(Component node, NodeVisitor v) {
        ArrayList<Component> children = node.getChildren();
        for(Component child: children){
            treeTraverse(child,v);
        }
        node.acceptVisitor(v);
    }
}