
import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of unique characters arr and a string str, Implement a function
 * getShortestUniqueSubString that finds the smallest substring of str containing
 * all the characters in arr. Return "" (empty string) if such a substriung doesn´t
 * exist.

    Come up with a asymptotically optimal solution and analyze the time and space
    complexities.


input: arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"

Constraints:

[time limits] 5000ms

[input] array.character arr
    1<=arr.length<=30

[input] string str
    1<=str.length<=500

[output] string


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
        //char [] arr = new char[]{'x','y','z'};
        //char [] arr = new char[]{'A','B','C','E','K','I'};
        
        char [] arr = new char[]{'A','B','E'};
        
        //String str = "xyyzyzyx";
        
        //String str = "KADOBECODEBANCDDDEI";
        
        String str = "ABNEDFAE";
        
        System.out.println("Shortest substring that includes every character: "+getShortestUniqueSubstring(arr,str));

        
        int [] test = new int[]{1,2,3,4,5};
        
        int fast = test[test[0]];
        
    }
    
    
    public static String getShortestUniqueSubstring(char [] arr,String str)
    {
        String shortest ="";
        
        //If the string has all the characters from the very beggining
        if(containsAllChar(arr,str))
        {
            //The new shortest is the entire string
            //We go through the entire string creating substrings to check if there is a smaller solution
            shortest=str;
            int i=0;
            
            //Size of the array
            int arrSize = arr.length;
            
            //While there is enough room for a substring that has all the necessary characters
            while(i<=str.length() - arrSize)
            {
                
                //We go through the string to check if there is a shorter solution
                int j= (i+arrSize)-1;
                boolean found = false;
                
                //While there is still room in the string to check for a solution
                while(j<str.length() && !found)
                {
                    String temp = str.substring(i,j+1);
                    
                    //If this substring contains all of the characters and is shorter than our current solution
                    if(containsAllChar(arr,temp) && temp.length() <shortest.length())
                    {
                        //We set a new solution and we look for other solutions with a different starting index
                        shortest = temp;
                        found=true;
                    }
                    j+=1;
                }
                i+=1;
            }
        }
        return shortest;
    }
    
    public static boolean containsAllChar(char[] arr,String str)
    {
        int i=0;
        boolean result=true;
        
        //We iterate through the array to check if every character is inside the string
        while(i<arr.length && result)
        {
            //If it doesn't contain the character
            if(str.indexOf(arr[i])==-1)
            {
                result=false;
            }
            i+=1;
        }
        
        return result;
    }
    
}
