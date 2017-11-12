/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

/**
 * Visitor base class
 * @author Josh
 */
abstract class NodeVisitor {
    /**
     * Result used for visitors
     */
    protected int result;
    
    /**
     * Visit a user
     * @param u user to visit
     */
    public abstract void visitUser(User u);
    
    /**
     * Visit a usergroup
     * @param g userGroup to visit
     */
    public abstract void visitUserGroup(UserGroup g);
    
    /**
     * get result of current visits
     * @return Result of the visits, depending on the concrete class implemenation
     */
    public int getResult(){
        return result;
    }
    
    /**
     * Initialize result in constructor
     */
    NodeVisitor(){
        result=0;
    }
}
