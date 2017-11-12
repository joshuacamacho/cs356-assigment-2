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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Josh
 */
public class UserView extends JFrame {
    private User user;
    private JPanel tweet;
    private JButton tweetButton;
    private JTextField tweetText;
    private JButton follow;
    private JTextField followId;
    private ActionListener listener;
    UserView(User user){
        this.user=user;
        makeUI();
    }
    private void makeUI(){
        this.setSize(800,800);
        this.setLayout(new GridLayout(0,1));
        JPanel addUser = new JPanel();
        addUser.setLayout(new GridLayout(1,2));
        followId = new JTextField();
        
        addUser.add(followId);
        
        follow = new JButton("Follow User");
        follow.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               if(followId.getText()!=""){
                   ae.setSource(followId);
                   listener.actionPerformed(ae);
               } 
            }
        });
//        follow.setFont(follow.getFont().deriveFont(12.0f));
        addUser.add(follow);
        this.add(addUser);
        
        
        JList subscribersList = new JList(); 
        subscribersList.setModel(user.getSubscriptionList());
        this.add(subscribersList);
        
        
        addUser.setLayout(new GridLayout(1,2));
        tweetText = new JTextField();
//        tweetText.setFont(tweetText.getFont().deriveFont(24.0f));
        addUser.add(tweetText);
        tweetButton = new JButton("tweet");
//        tweetButton.setFont(tweetButton.getFont().deriveFont(24.0f));
        tweetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!tweetText.getText().isEmpty()){
                    user.sendTweet(tweetText.getText());
                }
            }
        });
        addUser.add(tweetButton);
        
        
        JList tweetView = new JList();
        tweetView.setModel(user.getTweets());
        this.add(tweetView);
    };
    
    public void SetActionListener(ActionListener a){
        this.listener = a;
    }

    public User getUser() {
        return this.user;
    }
}
