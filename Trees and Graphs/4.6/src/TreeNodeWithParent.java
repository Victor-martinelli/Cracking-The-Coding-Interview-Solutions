/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class TreeNodeWithParent {
    
    private int data;
    private TreeNodeWithParent parent;
    private TreeNodeWithParent left;
    private TreeNodeWithParent right;

    public TreeNodeWithParent() {
    }

    
    
    public TreeNodeWithParent(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNodeWithParent getLeft() {
        return left;
    }

    public void setLeft(TreeNodeWithParent left) {
        this.left = left;
        
        left.setParent(this);
    }

    public TreeNodeWithParent getRight() {
        return right;
    }

    public void setRight(TreeNodeWithParent right) {
        this.right = right;
        
        right.setParent(this);
        
    }

    public TreeNodeWithParent getParent() {
        return parent;
    }

    public void setParent(TreeNodeWithParent parent) {
        this.parent = parent;
    }
    
    
    
}
