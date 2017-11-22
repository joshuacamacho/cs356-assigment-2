package cs356.assignment.pkg2;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

/**
 * Abstract Component class for Users and UserGroups
 * Implements treeNode for JTree view of users and groups
 * @author Josh
 */
abstract class Component implements TreeNode{
    protected ArrayList<Component> children;
    protected Component parent;
    protected String name;
    private long creationTime; 
    
    /**
     * Component constructor
     * @param name Name of Component to set
     */
    Component(String name){
        this.name=name;
        children = new ArrayList<Component>();
        creationTime = System.currentTimeMillis();
    }
    
    /**
     * Set parent Component
     * @param p Parent component
     */
    public void setParent(Component p){
        this.parent = p;
    }
    
    /**
     * Get TreeNode specified at index
     * @param i Index to get node
     * @return TreeNode at index i
     */
    @Override
    public TreeNode getChildAt(int i) {
        return children.get(i);
    }

    /**
     * Get count of child nodes
     * @return Int - amount of children this node has
     */
    @Override
    public int getChildCount() {
        return children.size();
    }

    /**
     * Returns parent of this node
     * @return TreeNode which is the parent of this node
     */
    @Override
    public TreeNode getParent() {
        return parent;
    }

    /**
     * Get Index of Specified Node
     * @param tn TreeNode to check
     * @return Index of TreeNode tn if the node is a child element, -1 if not
     */
    @Override
    public int getIndex(TreeNode tn) {
        for(int i=0; i<children.size(); i++){
            if(children.get(i).equals(tn)) return i;
        }
        return -1;
    }

    /**
     * Checks if this Node can have children
     * @return true if allows children
     */
    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    /**
     * Checks if this node is a leaf node, has 0 children
     * @return True if this node is childless
     */
    @Override
    public boolean isLeaf() {
        if(children.size()>0) return false;
        return true;
    }

    /**
     * Unsupported legacy thing
     * @return Exception
     */
    @Override
    public Enumeration children() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * To string of a node
     * @return the name of the node in string form
     */
    @Override
    public String toString(){
        return this.name;
    }
    
    /**
     * visitor accepter
     * @param v visitor to accept
     */
    public abstract void acceptVisitor(NodeVisitor v);
    
    /**
     * Searches recursively and returns component if theres a match on name
     * @param s Name of component to look for
     * @return Component if matched, null otherwise
     */
    public Component find(String s){
        if(name.equals(s)) return this;
        if(children.size()==0) return null;
        for(Component x: children){
            Component n = x.find(s);
            if(n!=null) return n;
        }
        return null;
    }
    
    /**
     * Returns children of the node as ArrayList
     * @return Children of node
     */
    public ArrayList<Component> getChildren() {
        return children;
    }
    
    /**
     * Get name property
     * @return this user's name
     */
    public String getName() {
        return this.name;
    }
    
    public long getCreationTime(){
        return creationTime;
    }
}
