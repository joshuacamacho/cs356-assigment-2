/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

/**
 * UserGroup Component, contains Components as children
 * @author Josh
 */
public class UserGroup extends Component {
    
    /**
     * Constructor
     * @param name Name of UserGroup 
     */
    UserGroup(String name){
        super(name);
    }
    
    /**
     * Add Component to this UserGroup's children
     * @param n Component to be added
     */
    public void add(Component n){
        n.setParent(this);
        children.add(n);
    }
    
    /**
     * Accept visitor for UserGroup
     * @param v Visitor to be accepted
     */
    @Override
    public void acceptVisitor(NodeVisitor v){
        v.visitUserGroup(this);
    }

    
}
