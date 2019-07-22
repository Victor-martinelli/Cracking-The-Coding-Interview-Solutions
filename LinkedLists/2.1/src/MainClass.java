
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
       
       LinkedListNode n2 = new LinkedListNode(0);
       
       
       n.setNext(n1);
       
       n1.setNext(n2);
       
       
       removeDuplicates(n);
    }
    
    public static void removeDuplicates(LinkedListNode n)
    {
        List founds = new ArrayList();
        founds.add(n.data);
        Object current;
        //While there is still elements to check
        while(n!=null && n.next!=null)
        {
            //If the element has been found before
            if(founds.contains(n.next.data))
            {
                n.next=n.next.next;
            }
            else
            {
                founds.add(n.next.data);
            }
         
            n = n.next;
            
        }
    }
    
}
