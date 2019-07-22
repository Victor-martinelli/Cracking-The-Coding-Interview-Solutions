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
        n.setRight(n3);
        
        n1.setLeft(n2);
        
        n3.setLeft(n4);
        n3.setRight(n5);
        
        n2.setLeft(n6);
        
        System.out.println("Is the tree balanced: "+isBalanced(n));
        
    }

    public static boolean isBalanced(TreeNode n) {
        boolean result = false;

        if (recursiveIsBalanced(n) != -1) {
            result = true;
        }
        return result;
    }

    public static int recursiveIsBalanced(TreeNode n) {
        int result = -1;
        int leftHeight = 1;
        int rightHeight = 1;
        //It it has a left child
        if (n.getLeft() != null) {
            leftHeight+= recursiveIsBalanced(n.getLeft());
        }

        //If it has a right child
        if (n.getRight() != null) {
            rightHeight+= recursiveIsBalanced(n.getRight());
        }

        //If any of the children returned -1 or if their heights differ by more than 1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {

            result=-1;
            
        }else
        {
            //We get the maximum of each height
            result=Math.max(leftHeight, rightHeight);
        }
      

        return result;

    }

}
