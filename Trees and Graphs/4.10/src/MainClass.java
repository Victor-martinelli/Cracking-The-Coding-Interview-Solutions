
import java.util.ArrayList;
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
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        
        n1.setLeft(n2);
        n1.setRight(n5);
        
        n2.setLeft(n3);
        n2.setRight(n4);
        
        n6.setLeft(n3);
        n6.setRight(n7);
        

        System.out.println("Is s2 inside s1?: "+isSubTree(n1,n2));
        
        System.out.println("Is s2 inside s1?: "+isSubTree(n1,n6));
    }
    
    public static boolean isSubTree(TreeNode s1,TreeNode s2)
    {
        
        //We get all the elements of both trees and we finally check if s2 is in s1
        List s1Elements = getElementsTree(s1);
        List s2Elements = getElementsTree(s2);
        
        return s1Elements.containsAll(s2Elements);
        
    }
    
    public static List getElementsTree(TreeNode n)
    {
        List result = new ArrayList();
        
        //We add the current node to the solution and check if it has children
        //Then we iterate through them
        
        result.add(n.getData());
        
        if(n.getLeft()!=null)
        {
            result.addAll(getElementsTree(n.getLeft()));
        }
        
        if(n.getRight()!=null)
        {
            result.addAll(getElementsTree(n.getRight()));
        }
        
        return result;
    }
    
}
