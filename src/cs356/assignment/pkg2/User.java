package cs356.assignment.pkg2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
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
    
    /**
     * Constructor, requires a name
     * @param name String which represents the name of the User
     */
    User(String name){
        super(name);
        subscribers = new LinkedList<User>();
        subscriptions = new DefaultListModel();
        tweets = new DefaultListModel();
        myTweets = new ArrayList<Tweet>();
    }
    
    /**
     * Returns null because users dont have children
     * @param i
     * @return null
     */
    @Override
    public TreeNode getChildAt(int i) {
        return null;
    }

    /**
     * Child count always 0 for users
     * @return 0
     */
    @Override
    public int getChildCount() {
        return 0;
    }

    /**
     * Returns parent of user
     * @return Component parent
     */
    @Override
    public TreeNode getParent() {
        return parent;
    }

    /**
     * Returns -1 because users never have children
     * @param tn Node to check
     * @return -1
     */
    @Override
    public int getIndex(TreeNode tn) {
        return -1;
    }

    /**
     * Returns false, users can't have children
     * @return false
     */
    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    /**
     * Returns true because users are always leaf nodes
     * @return true
     */
    @Override
    public boolean isLeaf() {
        return true;
    }

    /**
     * Unsupported
     * @return Exception
     */
    @Override
    public Enumeration children() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Allows a user to subscribe to this user
     * Also gives new subscriber all tweets from this user
     * @param u User to subscribe to this user
     */
    public void subscribe(User u){
        subscribers.add(u);
        
        for(Tweet tweet: myTweets){
            u.recieveMessage(tweet);
        }
    }
    
    /**
     * Subscribes a another user to this user
     * @param u User to add to this user's subscription list
     */
    public void subscribeTo(User u){
        u.subscribe(this);
        updateSubscriberList(u);
    }
    
    /**
     * Push message to this user's tweet list
     * @param t Tweet to add to tweet list
     */
    public void recieveMessage(Tweet t){
        tweets.addElement(t);
    }
    
    /**
     * Send tweet from this user. Also broadcasts to all subscribers
     * @param message String message to send as Tweet
     */
    public void sendTweet(String message){
        Tweet t = new Tweet("@"+name+" "+message);
        myTweets.add(t);
        tweets.addElement(t);
        broadcast(t);
    }

    /**
     * Broadcasts a tweet to all subscribers
     * @param t Tweet to broadcast
     */
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
