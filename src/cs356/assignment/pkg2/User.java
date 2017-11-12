/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Josh
 */
public class User extends Component{
    private LinkedList<User> subscribers;
    private DefaultListModel subscriptions;
    private DefaultListModel tweets;
    private ArrayList<Tweet> myTweets;
    User(String name){
        super(name);
        subscribers = new LinkedList<User>();
        subscriptions = new DefaultListModel();
        tweets = new DefaultListModel();
        myTweets = new ArrayList<Tweet>();
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
        
        for(Tweet tweet: myTweets){
            u.recieveMessage(tweet);
        }
    }
    public void subscribeTo(User u){
        u.subscribe(this);
        updateSubscriberList(u);
    }
    public void recieveMessage(Tweet t){
        tweets.addElement(t);
    }
    public void sendTweet(String message){
        Tweet t = new Tweet("@"+name+" "+message);
        myTweets.add(t);
        tweets.addElement(t);
        broadcast(t);
    }

    private void broadcast(Tweet t) {
        for(User user: subscribers){
            user.recieveMessage(t);
        }
    }

    public void updateSubscriberList(User u) {
        subscriptions.addElement(u);
    }

    public DefaultListModel getSubscriptionList(){
        return subscriptions;
    }
    public DefaultListModel getTweets() {
        return tweets;
    }

    public String getName() {
        return this.name;
    }
    
    @Override
    public void acceptVisitor(NodeVisitor v){
        v.visitUser(this);
    }
    
    public int getTweetCount(){
        return myTweets.size();
    }
    
    public ArrayList<Tweet> getTweetsAsList(){
        return myTweets;
    }
    
}
