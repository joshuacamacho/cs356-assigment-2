package cs356.assignment.pkg2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.tree.TreeNode;

/**
 * User class
 * extends component and contains tweets, subscribers and subscriptions
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
    
    /**
     * 
     * @param u 
     */
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

    /**
     * Update list of users that this user follows
     * @param user User to add to this.subscription list 
     */
    public void updateSubscriberList(User user) {
        subscriptions.addElement(user);
    }

    /**
     * Get subscription list (followers) in ListModel form
     * @return subscriptions List Model for listing subscriptions on UI
     */
    public DefaultListModel getSubscriptionList(){
        return subscriptions;
    }
    
    /**
     * Get List of tweets in ListModel form
     * @return tweets List model used for JList
     */
    public DefaultListModel getTweets() {
        return tweets;
    }

    /**
     * Get name property
     * @return this user's name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * User implementation of accept visitor
     * @param v 
     */
    @Override
    public void acceptVisitor(NodeVisitor v){
        v.visitUser(this);
    }
    
    /**
     * Get total Amount of tweets from this user
     * @return Int - Amount of tweets
     */
    public int getTweetCount(){
        return myTweets.size();
    }
    
    /**
     * Get ArrayList of tweets from this user
     * @return ArrayList of tweets
     */
    public ArrayList<Tweet> getTweetsAsList(){
        return myTweets;
    }
    
}
