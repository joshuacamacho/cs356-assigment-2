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
abstract class NodeVisitor {
    protected int result;
    public abstract void visitUser(User u);
    public abstract void visitUserGroup(UserGroup g);
    public int getResult(){
        return result;
    }
    NodeVisitor(){
        result=0;
    }
}
