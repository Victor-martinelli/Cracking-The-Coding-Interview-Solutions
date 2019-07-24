
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class Tree {
    
    private TreeNode root = null;
    

    public Tree(TreeNode n) {
        root = n;
    }

    public int size()
    {
        int result=0;
        if(root!=null)
        {
            result = root.size();
        }
        return result;
    }
    
    public TreeNode getRandomNode()
    {
        //If root is not nul, we get the random node
        //Otherwise, we simply return an empty node
        
        TreeNode result = new TreeNode();
        
        if(root!=null)
        {
            
            /*
            We return the node with the index generated through Random. The
            order of the nodes is determined through in-order traversal
            */
            result = root.getIthNode(new Random().nextInt(this.size()));
        }
        
        return result;
        
    }
    
    public void insertInOrder(int value)
    {
        //If root is null, we set it as root
        
        if(root!=null)
        {
            root.insertInOrder(value);
        }
        else
        {
            root = new TreeNode(value);
        }
        
    }
    
}
