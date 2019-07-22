/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeNode n = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(6);

        n.setLeft(n1);
        n.setRight(n2);
        
        n2.setLeft(n3);
        
        System.out.println("Is the tree BST?: "+isBST(n,null,null));
    }
 
    public static boolean isBST(TreeNode n, Integer min, Integer max)
    {
        boolean result=true;
        
        //If the current node is null
        
        if(n!=null)
        {
            
            //If we are in the base case or the current node is larger or smaller than the edges, then
            //the tree is not bst
            if((max!=null && n.getData()>max) || (min!=null && n.getData()<=min))
            {
                result=false;
            }
            
            //If after updating the max and min form the other searches the result from the other searches is false
            if(!isBST(n.getLeft(),min,n.getData()) || !isBST(n.getRight(),n.getData(),max))
            {
                result=false;
            }
            
        }
        
        return result;
        
    }
    
}
