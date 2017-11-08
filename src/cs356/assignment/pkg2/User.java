/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Josh
 */
public class User extends Component{
    private LinkedList<User> subscribers;
    private LinkedList<User> subscriptions;
    private LinkedList<Tweet> tweets;
    private LinkedList<Tweet> myTweets;
    User(String name){
        super(name);
        subscribers = new LinkedList<User>();
        subscriptions = new LinkedList<User>();
        tweets = new LinkedList<Tweet>();
        myTweets = new LinkedList<Tweet>();
    }
    @Override
    public TreeNode getChildAt(int i) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode tn) {
        return -1;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public Enumeration children() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void subscribe(User u){
        subscribers.add(u);
        u.updateSubscriberList(this);
        for(Tweet tweet: myTweets){
            u.recieveMessage(tweet);
        }
    }
    public void recieveMessage(Tweet t){
        tweets.add(t);
    }
    private void sendTweet(String message){
        Tweet t = new Tweet("@"+name+" "+message);
        myTweets.add(t);
        tweets.add(t);
        broadcast(t);
    }

    private void broadcast(Tweet t) {
        for(User user: subscribers){
            user.recieveMessage(t);
        }
    }

    public void updateSubscriberList(User u) {
        subscriptions.add(u);
    }

    public Object[] getTweets() {
        if(tweets.size()>0)
        return tweets.toArray();
        else{
            Tweet[] temp = new Tweet[1];
            temp[0] = new Tweet("No tweets yet");
            return temp;
        }
    }
    
}
