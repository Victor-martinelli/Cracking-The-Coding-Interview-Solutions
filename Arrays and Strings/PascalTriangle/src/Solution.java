
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 5;
        
        ArrayList<ArrayList<Integer>> matrix = solve(n);
        
        System.out.println("Pascal Triangle");
        
        printList(matrix);
    }
    
    
    public static ArrayList<ArrayList<Integer>> solve(int A) {
        
        ArrayList<ArrayList<Integer>> matrix = new ArrayList();
        
        if(A>0)
        {
            for(int i=0;i<A;i++)
            {
                
                ArrayList<Integer> row = new ArrayList();
                
                for(int j=0;j<i+1;j++)
                {
                    
                    if(j==0 || j==i)
                    {
                        row.add(1);
                    }
                    else
                    {
                        row.add(matrix.get(i-1).get(j) + matrix.get(i-1).get(j-1));
                    }
                }
                matrix.add(row);
                
            }
        }
        
        return matrix;
        
    }
    
    
    public static void printList(ArrayList<ArrayList<Integer>> matrix)
    {
        for(ArrayList<Integer> row : matrix)
        {
            for(Integer column : row)
            {
                System.out.print(column+" ");
            }
            System.out.println();
        }
    }
    
}
