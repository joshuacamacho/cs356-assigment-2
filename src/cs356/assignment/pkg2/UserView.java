package cs356.assignment.pkg2;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * User's view
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
        
        // init window
        this.setSize(800,800);
        this.setLayout(new GridLayout(0,1));
        JPanel addUser = new JPanel();
        addUser.setLayout(new GridLayout(1,2));
        // follow user
        followId = new JTextField();
        addUser.add(followId);
        follow = new JButton("Follow User");
        Font font = follow.getFont().deriveFont(24.0f);
        follow.setFont(font);
        follow.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               if(followId.getText()!=""){
                   ae.setSource(followId);
                   listener.actionPerformed(ae);
               }
               followId.setText("");
            }
        });
        addUser.add(follow);
        this.add(addUser);
        
        // View people you follow
        JList subscribersList = new JList(); 
        subscribersList.setModel(user.getSubscriptionList());
        subscribersList.setFont(font);
        this.add(subscribersList);
        
        //Send tweet
        addUser.setLayout(new GridLayout(1,2));
        tweetText = new JTextField();
        tweetText.setFont(font);
        addUser.add(tweetText);
        tweetButton = new JButton("tweet");
        tweetButton.setFont(font);
        tweetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!tweetText.getText().isEmpty()){
                    user.sendTweet(tweetText.getText());
                }
                tweetText.setText("");
            }
        });
        addUser.add(tweetButton);
        
        // View tweets
        JList tweetView = new JList();
        tweetView.setFont(font);
        tweetView.setModel(user.getTweets());
        this.add(tweetView);
    };
    
    /**
     * Set ActionListener for event firing
     * @param a 
     */
    public void SetActionListener(ActionListener a){
        this.listener = a;
    }

    /**
     * Get user associated with this user view
     * @return this windows user
     */
    public User getUser() {
        return this.user;
    }
}
