/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

/**
 * Visitor which counts Users
 * @author Josh
 */
public class UserCountVisitor extends NodeVisitor {

    /**
     * Adds 1 to the result when visiting a user
     * @param u User to visit
     */
    @Override
    public void visitUser(User u) {
        result+=1;
    }

    /**
     * Adds 0 to result when visiting a userGroup
     * @param g UserGroup to visit
     */
    @Override
    public void visitUserGroup(UserGroup g) {
        // nada
    }    
}
