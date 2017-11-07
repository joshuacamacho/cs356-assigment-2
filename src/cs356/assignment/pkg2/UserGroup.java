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
 *
 * @author Josh
 */
public class UserGroup extends Component {
    
    
    UserGroup(String name){
        super(name);
        children = new ArrayList<Component>();
    }
    public void add(Component n){
        n.setParent(this);
        children.add(n);
    }
    
    
}
