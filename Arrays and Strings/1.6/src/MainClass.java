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
        
        String word = "aabcccccaaa";
        System.out.println("What is the compressed version of the word "+word+" ? - "+compress(word));
    }
    
    public static String compress(String s)
    {
        String result="";
        //Since the characters will be from a-z
        char prev=s.charAt(0);
        int count=1;
        boolean add=false;
        
        //If the string needs compressing
        if(needsCompress(s))
        {
            
            for(int i=1;i<s.length();i++)
            {
                add=false;
                
                //If the character is the same as the one before
                if(prev==s.charAt(i))
                {
                    //We keep counting of the same character
                    count++;
                }
                else // If it isn't we get ready to save to solution
                {
                    add=true;
                }

                //If we need to add to the string solution, we add prev and the count number
                if(add)
                {
                    result+=String.valueOf(prev) + count;
                    count=1;
                }
                prev = s.charAt(i);
            }
            
            result+=String.valueOf(prev) + count;
            
        }
        else
        {
            result=s;
        }
        
        return result;
    }
    
    public static boolean needsCompress(String s)
    {
        int countDif=1;
         char prev=s.charAt(0);
        for(int i=1;i<s.length();i++)
        {
            //If the next character is different than the next one
            if(prev!=s.charAt(i))
            {
                countDif++;
            }
            
             prev = s.charAt(i);
        }
        
        //We check if the number of different characters is the same as the length of the string
        
        return countDif!=s.length();
    }
    
    
}
