/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356.assignment.pkg2;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Josh
 */
public class IdValidatorVisitor extends NodeVisitor {
    Set<String> used;
    IdValidatorVisitor(){
        used = new HashSet<String>();
    }
    
    @Override
    public void visitUser(User u) {
        if(used.contains(u.getName())){
            this.result=1;
        }else
        if(u.getName().contains(" ")){
            this.result=1;
        }else{
            used.add(u.getName());
        }
    }

    @Override
    public void visitUserGroup(UserGroup g) {
        if(used.contains(g.getName())){
            this.result=1;
        }else
        if(g.getName().contains(" ")){
            this.result=1;
        }else{
            used.add(g.getName());
        }
    }
    
}
