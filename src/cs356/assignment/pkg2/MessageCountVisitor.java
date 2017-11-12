package cs356.assignment.pkg2;

/**
 * NodeVisitor implementation that counts all messages from Components
 * @author Josh
 */
public class MessageCountVisitor extends NodeVisitor {

    /**
     * Adds 1 to result when visiting a user
     * @param u User to visit
     */
    @Override
    public void visitUser(User u) {
        result+=u.getTweetCount();
    }

    /**
     * Adds 0 to the result when visiting a userGroup
     * @param g userGroup to visit
     */
    @Override
    public void visitUserGroup(UserGroup g) {
        // nada to do
    }
    
}
