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
        TreeNodeWithParent n = new TreeNodeWithParent(1);
        TreeNodeWithParent n1 = new TreeNodeWithParent(2);
        TreeNodeWithParent n2 = new TreeNodeWithParent(3);
        TreeNodeWithParent n3 = new TreeNodeWithParent(4);
        TreeNodeWithParent n4 = new TreeNodeWithParent(10);
        TreeNodeWithParent n5 = new TreeNodeWithParent(5);
        TreeNodeWithParent n6 = new TreeNodeWithParent(6);
        TreeNodeWithParent n7 = new TreeNodeWithParent(7);
        TreeNodeWithParent n8 = new TreeNodeWithParent(8);
        
        
        n.setRight(n1);
        
        n1.setRight(n2);
        
        n2.setLeft(n3);
        n2.setRight(n4);
        
        n3.setLeft(n5);
        n3.setRight(n6);
        
        n6.setLeft(n7);
        n6.setRight(n8);
        
        System.out.println("What is the successor to "+n7.getData()+" ?: "+successor(n7).getData());
        
    }
    
    public static TreeNodeWithParent successor(TreeNodeWithParent n)
    {
        TreeNodeWithParent successor = null;
        
        //If the current node has children on the right
        if(n.getRight()!=null)
        {
            successor = n.getRight();
        }
        else
        {
            //We go to the parents until we find the next successor
            while(successor==null)
            {
                TreeNodeWithParent parent = n.getParent();
                
                //If the child is the left child of the parent, then we return the parent
                if(parent.getLeft()==n)
                {
                    successor = parent;
                }
                else // The child if the right child and we must look at the parent of the parent
                {
                    n = parent;
                }
                
            }
        }
        
        return successor;
    }
    
}
