package cs356.assignment.pkg2;

import java.util.ArrayList;

/**
 * Visit Components and count positive messages
 * @author Josh
 */
public class PositiveMessageCountVisitor extends NodeVisitor{
    private int total=0;
    /**
     * Visit user and read messages, with complex machine learning
     * @param u User whose messages to read
     */
    @Override
    public void visitUser(User u) {
        ArrayList<Tweet> tweets = u.getTweetsAsList();
        for(Tweet t: tweets){
            if(t.toString().matches(".*food.*")){
                result+=1;
            }
            total+=1;
        }
    }

    /**
     * UserGroups dont have messages, nothing to do
     * @param g UserGroup
     */
    @Override
    public void visitUserGroup(UserGroup g) {
        // nada
    }
    
    /**
     * Returns calculated percent result
     * @return Percent, as a whole integer 0-100
     */
    @Override
    public int getResult(){
        if(total==0) return 0;
        float percentage = (float)result/(float)total;
        System.out.println(percentage);
        return (int)(percentage*100);
    }
    
}
