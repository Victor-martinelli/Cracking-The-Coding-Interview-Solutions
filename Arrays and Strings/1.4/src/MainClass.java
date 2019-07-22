
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
        String word="tact coa";
        
        System.out.println("Is the word "+word+" a palindrome permutation?: "+paliPermutation(word));
    }
    
    public static boolean paliPermutation(String rawWord)
    {
        String word = rawWord.replace(" ","");
        boolean result=true;
        
        //Indicates if an odd character has been found before
        boolean oddFound=false;
        
        //Collection of characters that have been found before
        List searchedWords= new ArrayList();
        
        int i=0;
        
        while(i<word.length() && result)
        {
            //Character has not been found before
            if(!searchedWords.contains(word.charAt(i)))
            {
                //If there isn't an off number of characters in the string
              if((word.length() - word.replace(String.valueOf(word.charAt(i)),"").length())%2!=0)
              {
                  //If we havent found an off character before
                  if(!oddFound)
                  {
                      oddFound=true;
                  }
                  else //If we have found it before
                  {
                      result=false;
                  }
              }
              //We add the current char to the list of 
              searchedWords.add(word.charAt(i));
            }
            i++;
        }
        
        return result;
    }
    
}
