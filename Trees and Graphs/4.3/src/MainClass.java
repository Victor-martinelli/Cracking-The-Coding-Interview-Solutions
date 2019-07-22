
import java.util.Iterator;
import java.util.LinkedList;

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
        TreeNode n = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        
        n.setLeft(n1);
        n.setRight(n2);
        
        n1.setLeft(n3);
        n1.setRight(n4);
        
        n2.setLeft(n5);
        n2.setRight(n6);
        
        LinkedList result = LinkedListDepth(n);
        
        
        
    }
    
    public static LinkedList LinkedListDepth(TreeNode n)
    {
        LinkedList result = new LinkedList();
        LinkedList currentList = new LinkedList();
        
        currentList.add(n);
        
        //While the list containing children is not empty
        while(currentList.size() > 0)
        {
            //We add the current list of nodes into the result
            result.add(currentList);
            
            //List to iterate through the parents
            LinkedList parents = currentList;
            
            //We clean the previous list and store the children
            currentList = new LinkedList();
            
            //We iterate through the parents to add their children to the solution
            for (Iterator it = parents.iterator(); it.hasNext();) {
                TreeNode current = (TreeNode) it.next();
                
                //If the parents has children to the left or right, we add them
                if(current.getLeft()!=null)
                {
                    currentList.add(current.getLeft());
                }
                
                if(current.getRight()!=null)
                {
                    currentList.add(current.getRight());
                }
            }
            
        }
        
        return result;
        
    }
    
}
