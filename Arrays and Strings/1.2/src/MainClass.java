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
        String s1 = "data";
        String s2 = "atda";
        System.out.println("Is the word "+s2+" a permutation of "+s1+"? : "+isPermutation(s1,s2));
    }
    
    public static boolean isPermutation(String s1,String s2)
    {
        boolean result=true;
        
        //It can only be a permutation if they are the same length and have a length of atleast 2
        if(s1.length()!=s2.length() || s1.length()<2)
        {
            result=false;
        }
        else
        {
            int i=0;
            
            while(i<s1.length() && result)
            {
                //If after removing the character, they are the same length,
                //That means that they had the same amount of characters in the string
                //Therefore, it could be a permutation of the original string
                if(s1.replace(String.valueOf(s1.charAt(i)),"").length() != s2.replace(String.valueOf(s1.charAt(i)),"").length())
                {
                    result=false;
                }
                else
                {
                    i++;
                }
            }
            
        }
        
        return result;
    }
    
}
