/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.time.LocalTime;

/**
 *
 * @author Josh
 */
class Tweet {
    private final String message;
    private final String timestamp;
    Tweet(String tweet){
        this.message = tweet;
        this.timestamp = LocalTime.now().toString();
    }
    
    @Override
    public String toString(){
        return timestamp +" "+message;
    }
}
