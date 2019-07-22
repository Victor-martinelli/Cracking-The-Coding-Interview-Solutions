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
        String s1="pale";
        String s2="ppla";
        
        System.out.println("Is "+s2+" one character away from "+s1+" ?: "+isOneAway(s1,s2));
        
    }
    
    public static boolean isOneAway(String s1,String s2)
    {
        int i=0;
        boolean dif=false;
        boolean result=true;
        while(i<s1.length() && result)
        {
            //If they don't have the same amount that specific character
            if(s1.length() - s1.replace(String.valueOf(s1.charAt(i)),"").length()!=s2.length() - s2.replace(String.valueOf(s1.charAt(i)),"").length())
            {
                //If We didnt find a difference before
                if(!dif)
                {
                    dif=true;
                }
                else
                {
                    result=false;
                }
            }
            i++;
        }
        
        return result;
    }
    
}
