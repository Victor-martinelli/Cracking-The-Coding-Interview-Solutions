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
        
        int[] nodes = new int[4];
        
        nodes[0]=1;
        nodes[1]=2;
        nodes[2]=3;
        nodes[3]=4;
        
        TreeNode tree = minimalTree(nodes,0,3);
        
    }
    
    public static TreeNode minimalTree(int[] nodes, int start, int end)
    {
        TreeNode n = null;
        //If there are no more elements to go through
        if(end>=start)
        {
            //We set the middle of the array as the root
            int mid = (start+end)/2;
            n = new TreeNode(nodes[mid]);
            
            //We fill the left and right sides of the tree recursively
            n.setLeft(minimalTree(nodes,start,mid - 1));
            n.setRight(minimalTree(nodes,mid+1,end));
        }
        
        return n;
    }
    
}
