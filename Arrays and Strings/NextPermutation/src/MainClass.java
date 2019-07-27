
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
        List<Integer> lista = new ArrayList();
        
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        
        nextPermutation(lista);
        
    }
    
    
    public static List<Integer> nextPermutation(List<Integer> input)
    {
        
        //If there is only one element
        
        if(input.size()>1)
        {
        
            //We first find out where the largest and rightmost element is

            int largest = input.size() -2;
            boolean found = false;

            while(!found && largest>=0)
            {
                //If the element to our right is greater than us
                
                if(input.get(largest)<input.get(largest+1))
                {
                    found=true;
                }
                else
                largest-=1;
                
            }
            
            //We now try to find the next element, starting from the end, than is greater than the previous element
            
            int secondLargest = input.size()-1;
            found=false;
            
            while(!found)
            {
                //If this element is the second largest in the collection
                if(input.get(largest)< input.get(secondLargest))
                {
                    found=true;
                }
                else
                secondLargest-=1;
                
            }
            
            //We swap both elements
            
            int temp = input.get(largest);
            
            input.set(largest,input.get(secondLargest));
            
            input.set(secondLargest, temp);
            
            
            //We reverse the order of the array to finalize the permutation starting from the largest +1
            
            largest+=1;
            secondLargest=input.size()-1;
            
            while(largest<secondLargest)
            {
                temp = input.get(largest);
                input.set(largest, input.get(secondLargest));
                input.set(secondLargest, temp);
                
                secondLargest-=1;
                largest+=1;
                
            }
            
        }
        
        
        return input;
    }
    
}
