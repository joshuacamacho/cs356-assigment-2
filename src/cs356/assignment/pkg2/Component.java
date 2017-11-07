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
public class Component implements TreeNode{
    ArrayList<Component> children;
    Component parent;
    String name;
    Component(String name){
        this.name=name;
    }
    
    public void setParent(Component p){
        this.parent = p;
    }
    
    @Override
    public TreeNode getChildAt(int i) {
        return children.get(i);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode tn) {
        for(int i=0; i<children.size(); i++){
            if(children.get(i).equals(tn)) return i;
        }
        return -1;
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        if(children.size()>0) return false;
        return true;
    }

    @Override
    public Enumeration children() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
