
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        
        n2.setLeft(n1);
        n2.setRight(n3);
        
       ArrayList<LinkedList> result =  possibleArrays(n2);
        
       
       /*
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(11);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(4);
        
        n1.setRight(n2);
        n1.setLeft(n4);
        
        n2.setLeft(n3);
        
        n4.setRight(n5);
        n4.setLeft(n6);
        
        n6.setLeft(n7);
        n6.setRight(n8);
        
        ArrayList<LinkedList> result =  possibleArrays(n1);
       
       */
        
    }
    
    
    public static ArrayList<LinkedList> possibleArrays(TreeNode n)
    {
        
        //Each solution (which is an array) will be stored in a Linked List
        ArrayList<LinkedList> result = new ArrayList();
        
        //This will store what elements will already be added to the current solution
        LinkedList prefix = new LinkedList();
        
        //If we are at the end of a branch
        if(n!=null)
        {
            
            //We add the current node to the solution
             prefix.add(n.getData());
            
            //We store the elements of each of the children of the current node
            List<LinkedList> leftChildren = possibleArrays(n.getLeft());
            List<LinkedList> rightChildren = possibleArrays(n.getRight());
            
            //For each left children, we combine it with every element of the right children to get all the possible combinations
            for(LinkedList left: leftChildren)
            {
                for(LinkedList right : rightChildren)
                {
                    //We mix the left element with the right element and add it to the solution
                    ArrayList<LinkedList> mixed = mixedArrays(left,right,prefix);
                    result.addAll(mixed);
                }
            }
            
        }
        else
        {
            //We add an empty solution
            result.add(new LinkedList());
        }
        
        return result;
        
    }
    
    public static ArrayList<LinkedList> mixedArrays(LinkedList first,LinkedList second,LinkedList prefix)
    {
        ArrayList<LinkedList> result = new ArrayList<LinkedList>();
        
        //If one of the lists is empty, we can stop merging and all the remaining elements to the results list
        
        if(first.size()==0 || second.size()==0)
        {
            //We create a temp list to add all the elements and later we add it to the solution
            
            LinkedList temp = (LinkedList) prefix.clone();
            
            temp.addAll(first);
            temp.addAll(second);
            
            result.add(temp);
        }
        else
        {
            
            /*To properly mix both array with all the posibilities, we take out
            the first element of the left and add it to the predefined solution,
            later we add it again so that we can now remove it from the right and
            do the same as before
            */
            
            int headFirst = (int) first.removeFirst();
            prefix.addLast(headFirst);
            result.addAll(mixedArrays(first,second,prefix));
            prefix.removeLast();
            first.addFirst(headFirst);
            
            
            int headSecond = (int) second.removeFirst();
            prefix.addLast(headSecond);
            result.addAll(mixedArrays(first,second,prefix));
            prefix.removeLast();
            second.addFirst(headSecond);
            
        }
        
        return result;
        
    }
    
}
