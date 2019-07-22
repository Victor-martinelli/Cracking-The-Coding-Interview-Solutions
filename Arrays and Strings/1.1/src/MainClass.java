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
        
        String word = "data";
        
        System.out.println("Are all the characters in the word: "+word+" unique? - "+isUniqueCharacters(word));
    }
    
    public static boolean isUniqueCharacters(String word)
    {
        boolean end = true;
        
        int i=0;
        int j=i+1;
        
        while(end && i<word.length()-1)
        {
            //We reached the end of the array
            if(j==word.length())
            {
                i++;
                j=i+1;
            }
            //We check if the characters are equal
            else if(word.charAt(i)==(word.charAt(j)))
            {
                end=false;
            }
            //They are not equal and we look for the next one
            else
            {
                j++;
            }
        }
        
        return end;
    }
    
}
