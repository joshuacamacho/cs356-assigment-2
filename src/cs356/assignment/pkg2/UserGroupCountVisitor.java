package cs356.assignment.pkg2;

/**
 * Visitor which counts UserGroups
 * @author Josh
 */
public class UserGroupCountVisitor extends NodeVisitor {

    /**
     * Add 0 to result when visiting a user
     * @param u User to visit
     */
    @Override
    public void visitUser(User u) {
        //nada
    }

    /**
     * Add 1 to result when visiting a userGroup
     * @param g UserGroup to visit
     */
    @Override
    public void visitUserGroup(UserGroup g) {
        result+=1;
    }
    
}
