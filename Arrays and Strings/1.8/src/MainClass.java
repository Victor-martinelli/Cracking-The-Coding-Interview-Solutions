
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
        int [][] matrix = {
            {1,0,3},
            {4,5,6}
        };
        
        printMatrix(matrix);
        
        System.out.println("");
        zeroMatrix(matrix);
    }
    
    
    public static void zeroMatrix(int [][] matrix)
    {
        
        List<Integer> affectedRows = new ArrayList<Integer>();
        List<Integer> affectedColumns = new ArrayList<Integer>();
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                //If cell is 0 and it's not been changed by a previous cell
                if(matrix[i][j]==0 && !affectedRows.contains(i) && !affectedColumns.contains(j))
                {
                    //We set the entire colum to 0
                    for(int k=0;k<matrix[i].length;k++)
                    {
                        matrix[i][k]=0;
                    }
                    
                    //We set the entire row to 0
                    
                    for(int k=0;k<matrix.length;k++)
                    {
                        matrix[k][j] = 0;
                    }
                    
                    //We add the row and column to the list of affected rows and columns
                    affectedRows.add(i);
                    affectedColumns.add(j);
                }
            }
        }
        
        printMatrix(matrix);
        
    }
    
    public static void printMatrix(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
}
