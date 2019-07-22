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
        
        /*
        TreeNodeWithParent n1 = new TreeNodeWithParent(1);
        TreeNodeWithParent n2 = new TreeNodeWithParent(2);
        TreeNodeWithParent n3 = new TreeNodeWithParent(3);
        TreeNodeWithParent n4 = new TreeNodeWithParent(4);
        TreeNodeWithParent n5 = new TreeNodeWithParent(5);
        TreeNodeWithParent n6 = new TreeNodeWithParent(6);
        TreeNodeWithParent n7 = new TreeNodeWithParent(7);
        TreeNodeWithParent n8 = new TreeNodeWithParent(8);
        TreeNodeWithParent n9 = new TreeNodeWithParent(9);
        
        
        n1.setLeft(n2);
        n1.setRight(n3);
        
        n2.setLeft(n4);
        
        n4.setLeft(n5);
        
        n5.setLeft(n6);
        n5.setRight(n7);
        
        n6.setLeft(n8);
        
        n7.setRight(n9);

        */
        
        TreeNodeWithParent n1 = new TreeNodeWithParent(20);
        TreeNodeWithParent n2 = new TreeNodeWithParent(30);
        TreeNodeWithParent n3 = new TreeNodeWithParent(10);
        TreeNodeWithParent n4 = new TreeNodeWithParent(15);
        TreeNodeWithParent n5 = new TreeNodeWithParent(17);
        TreeNodeWithParent n6 = new TreeNodeWithParent(5);
        TreeNodeWithParent n7 = new TreeNodeWithParent(7);
        TreeNodeWithParent n8 = new TreeNodeWithParent(3);
        
        
        n1.setRight(n2);
        n1.setLeft(n3);
        
        n3.setRight(n4);
        n3.setLeft(n6);
        
        n4.setRight(n5);
        
        n6.setLeft(n8);
        n6.setRight(n7);
        
        
        System.out.println("Common Successor: "+findCommonSucc(n1,n7,n5).getData());
        
    }
    
    public static TreeNodeWithParent findCommonSucc(TreeNodeWithParent root, TreeNodeWithParent n1, TreeNodeWithParent n2)
    {
        TreeNodeWithParent result = null;
        boolean found = false;
        
        //If we´ve searched the entire tree
        if(root!=null)
        {
            //If the current node is the parent of one of the nodes
            if(root.getLeft()==n1 || root.getRight()==n1)
            {
                //We then search for the other node in each of the children
                found = searchNode(root.getLeft(),n2);
                
                //If we didn't find the node
                if(!found)
                {
                    found = searchNode(root.getRight(),n2);
                }
                
                
                //If we found it, then the current node is the common successor
                if(found)
                {
                    result=root;
                }
                else //If we didn't find it, then we look in the parent of the current node
                {
                    result = findCommonSucc(root.getParent(),n1,n2);
                }
            }
            else //If we didnt find it, we keep looking down in the tree
            {
                result = findCommonSucc(root.getLeft(),n1,n2);
                
                //If we didn't find it in that branch
                if(result==null)
                {
                    result = findCommonSucc(root.getRight(),n1,n2);
                }
                
            }
        }
        
        return result;
    }
    
    
    public static boolean searchNode(TreeNodeWithParent current, TreeNodeWithParent search)
    {
        boolean result = false;
        
        //If we haven't reached the end of one of the tree's branches
        if(current!=null)
        {
            //We check if the searched node is found
            
            if(current.getRight()==search || current.getLeft()==search)
            {
                result=true;
            }
            else
            {
                //We will keep looking in each of the children
                
                result = searchNode(current.getRight(), search);
                
                //If it's found, we don't need to keep looking
                if(!result)
                {
                    result = searchNode(current.getLeft(),search);
                }
            }
        }
        
        
        return result;
    }
    
}
