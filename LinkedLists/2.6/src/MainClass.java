
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
        
        LinkedListNode n = new LinkedListNode(0);

        LinkedListNode n1 = new LinkedListNode(1);

        LinkedListNode n2 = new LinkedListNode(2);

        LinkedListNode n3 = new LinkedListNode(1);

        LinkedListNode n4 = new LinkedListNode(0);

        
        n.setNext(n1);
        
        n1.setNext(n2);
        
        n2.setNext(n3);
        
        n3.setNext(n4);
        
        
        System.out.println("Is it a palindrome?: "+isPalindrome(n));
        
    }
    
    public static boolean isPalindrome(LinkedListNode n)
    {
        LinkedListNode current = n;
        
        boolean result = true;
        
        List<Integer> reverseList = new ArrayList<Integer>();
        
        //We first insert the elements into a regular list
        
        while(current!=null)
        {
            reverseList.add(current.data);
            current=current.next;
        }
        
        //Now we check the list in reverse order to check that everything is the same
        int i = reverseList.size()-1;
        
        current=n;
        
        while(current!=null && result)
        {
          
            //If it's not the same

            if(current.data!=reverseList.get(i))
            {
                result=false;
            }
            
            
            //We go to the next element
            i-=1;
            current = current.next;
        }
        
        return result;
    }
    
    
}
