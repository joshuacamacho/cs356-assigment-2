/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

/**
 *
 * @author Josh
 */
public class LastUpdatedVisitor extends NodeVisitor {
    long highest=0;
    String message;
    LastUpdatedVisitor(){
        message="No messages so far";
    }
    
    @Override
    public void visitUser(User u) {
        if(u.getLastUpdatedValue()>highest){
            message = "Last updated user: "+u.getName();
            highest = u.getLastUpdatedValue();
        }
    }

    public String getLastUpdated(){
        return message;
    }
    
    @Override
    public void visitUserGroup(UserGroup g) {
        // nada
    }
    
}
