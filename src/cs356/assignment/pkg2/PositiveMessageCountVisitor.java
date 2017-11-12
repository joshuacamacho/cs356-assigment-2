/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.util.ArrayList;

/**
 *
 * @author Josh
 */
public class PositiveMessageCountVisitor extends NodeVisitor{
    private int total=0;
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

    @Override
    public void visitUserGroup(UserGroup g) {
        // nada
    }
    
    @Override
    public int getResult(){
        if(total==0) return 0;
        float percentage = (float)result/(float)total;
        System.out.println(percentage);
        return (int)(percentage*100);
    }
    
}
