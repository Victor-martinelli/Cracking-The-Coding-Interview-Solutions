
import java.util.Arrays;
import java.util.Collections;

/*
 *Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 
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
        String test = "BD";
        
        System.out.println("Original String: "+test+" - Conversion: "+titleToNumber(test));
        
    }
    
    
    public static int titleToNumber(String s)
    {
        int result =0;
        
        for(int i=0;i<s.length();i++)
        {
            result = result*26 + (s.charAt(i) - 'A' + 1); //With this last segment, we know which position the character is in this 
        }
        
        return result;
    }
    
    
    /*
    public static int previousSolution(String A)
    {
         int result=0;
        int base=26;
        String possibleChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        if(A!="")
        {
            
            String [] characters = A.split("");
            
            Collections.reverse(Arrays.asList(characters));
            
            for(int i=0;i<characters.length;i++)
            {
                
                result+=(possibleChar.indexOf(characters[i])+1) * (Math.pow(base,i));
                
            }
            
        }
        
        
        return result;
    }

*/
    
}
