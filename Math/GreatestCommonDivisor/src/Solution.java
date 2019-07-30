/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victormartinelli
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number1 = 9;
        int number2 = 6;
        
        
        System.out.println("GDC of "+number1+" and "+number2+" - "+gdc(number1,number2));
        
    }
    
    
    public static int gdc(int A,int B)
    {
         int greatestCommonDivisitor = -1;
        
         for(int i = 1; i <= A && i <= B; i++)
        {
            if(A%i==0 && B%i==0)
                greatestCommonDivisitor = i;
        }
        
        if(greatestCommonDivisitor==-1)
        {
            if(A>B)
            {
                greatestCommonDivisitor = A;
            }
            else
                greatestCommonDivisitor = B;
        }
        
        return greatestCommonDivisitor;
    }
    
}
