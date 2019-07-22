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
        String word = "Mr John Smith    ";
        int trueLength=13;
        
        replaceSpaces(word.toCharArray(),trueLength);
        
    }
    
    public static void replaceSpaces(char [] word,int trueLength)
    {
        
        //This is where the new string will end
        int endWordIndex = word.length-1;
        
        //We look through the array to find spaces and move the non space 
        //To their new location
        for(int i=trueLength-1;i>=0;i--)
        {
            //If it's a space
            if(word[i]==' ')
            {
                word[endWordIndex]= '0';
                word[endWordIndex - 1 ]= '2';
                word[endWordIndex - 2 ]= '%';
                endWordIndex-=3;
            }
            else //If it isn't we move it to their new location
            {
                word[endWordIndex] = word[i];
                //We move the index to the next new position to move a non-space character
                endWordIndex--;
            }
        }
        
        int i=0;
        
    }
    

    public static void replaceSpacesSOLUTION(char[] str, int trueLength) {
  
        int index = str.length;
        
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        
         int i =0;
        
    }

}
