
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    

    Count = 0


    i       j

    1   2   3
    4   5   6
    7   8   9

    L       k


    Count = 1


        i

    1   2   3
L   4   5   6   j
    7   8   9

        k



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
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        printMatrix(matrix);
        
        System.out.println("");
        rotate(matrix);
        
    }
    
    
    public static void rotate(int [][] matrix)
    {
        int i=0; int j=matrix.length-1; int k=matrix.length-1; int l=matrix.length-1;
        List<Integer> temp = new ArrayList<Integer>();
     
        for(int count=0;count<2;count++)
        {
            //We save the value before deleting it
            temp.add(matrix[count][j]);
            //We change it
            matrix[count][j] = matrix[0][i];
            
            
            //We add a new temp number
            //We change the current value for the previous temp number
            temp.add(matrix[matrix.length-1][k]);
            matrix[matrix.length-1][k] = temp.get(0);
            
            
            temp.add(matrix[l][0]);
            matrix[l][0] = temp.get(1);
            
            //We change the last value for the last temp value
            matrix[0][i] = temp.get(2);
            
            temp.clear();
            
            i++; k--; l--;
        }
        
        printMatrix(matrix);
    }

    public static boolean rotateSOLUTION(int[][] matrix) {
        
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];// save top 
                
                //left -> top 
                matrix[first][i] =matrix[last - offset][first];
                // bottom -> left 
                matrix[last - offset][first]  =matrix[last][last - offset];
                // right -> bottom 
                matrix[last][last - offset]  =matrix[i][last];
 
                // top -> right
                matrix[i][last]  =top; // right < - saved top
            }
        }
        printMatrix(matrix);
        return true;
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
