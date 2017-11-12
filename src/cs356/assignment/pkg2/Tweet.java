package cs356.assignment.pkg2;

import java.time.LocalTime;

/**
 * Tweet class to hold message
 * @author Josh
 */
class Tweet {
    private final String message;
    private final String timestamp;
    /**
     * Create tweet
     * @param tweet String message to be stored as a tweet
     */
    Tweet(String tweet){
        this.message = tweet;
        this.timestamp = LocalTime.now().toString();
    }
   
    /**
     * To string including timestamp and message
     * @return String form of tweet
     */
    @Override
    public String toString(){
        return timestamp +" "+message;
    }
}
