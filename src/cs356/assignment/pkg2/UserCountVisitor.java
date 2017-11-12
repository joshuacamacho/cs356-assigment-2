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
public class UserCountVisitor extends NodeVisitor {

    @Override
    public void visitUser(User u) {
        result+=1;
    }

    @Override
    public void visitUserGroup(UserGroup g) {
        //
    }    
}
