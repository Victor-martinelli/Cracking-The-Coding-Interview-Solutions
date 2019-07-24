/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class TreeNode {
    
    private int size;
    
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int d) {
        size=1;
        data=d;
    }

    public TreeNode() {
    }
    
    
    
    public TreeNode getIthNode(int i)
    {
        TreeNode result = null;
        int leftSize = 0;
        
        //We first get the left node's size to compare to the index
        if(this.getLeft()!=null)
        {
            leftSize = this.getLeft().getSize();
        }
        
        //If the index is the same as the current node's weight
        if(i==leftSize)
        {
            result = this;
        }
        else if(i<leftSize) //If the index is less than the left node's weight, then the wanted node must be to the left of the current node
        {
            result = this.getLeft().getIthNode(i);
        }
        else //This means that the node we want is to the right of the current node, therefore, we have to skip all the nodes to the left in order to traverse
             //To the correct node
        {
            result = this.getRight().getIthNode(i - (leftSize +1));
        }
        
        return result;
    }
    
    public void insertInOrder(int d)
    {
        //If we are less than the current node
        
        if(d<=this.data)
        {
            //If we have children to the left
            if(this.getLeft()!=null)
            {
                this.getLeft().insertInOrder(d);
            }
            else //It's our new child
            {
                this.setLeft(new TreeNode(d));
            }
        }
        else if(d>this.data) //If we are greater than the current node
        {
            //If we have children to the right
            if(this.getRight()!=null)
            {
                this.getRight().insertInOrder(d);
            }
            else //It's our new child
            {
                this.setRight(new TreeNode(d));
            }
        }
        size++;
        
    }
    
    public int size()
    {
        return size;
    }
    
    public TreeNode find(int d)
    {
        TreeNode result = null;
        
        //If we found the node we were looking for is
        if(d==this.data)
        {
            //We simply copy it
            result = this;
        }
        else if(d<this.data && this.getLeft()!=null) //If the value we are looking for is less than current, we look to the left
        {
            result = this.getLeft().find(d);
        }
        else if(d>this.data && this.getRight()!=null) //If the value we are looking for is greater than current, we look to the right
        {
            result = this.getRight().find(d);
        }
        
        return result;
        
    }

    public int getSize() {
        return size;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    
    
    
}
