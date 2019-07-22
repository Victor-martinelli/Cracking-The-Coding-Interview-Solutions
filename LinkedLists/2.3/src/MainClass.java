
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
        LinkedListNode n = new LinkedListNode(1);
        
       LinkedListNode n1 = new LinkedListNode(2);
       
       LinkedListNode n2 = new LinkedListNode(3);
       
       LinkedListNode n3 = new LinkedListNode(4);
       
       List test = new ArrayList(); 
       
       n.setNext(n1);
       
       n1.setNext(n2);
       
       n2.setNext(n3);
       
       
       deleteNode(n2);
       
    }
    
    public static void deleteNode(LinkedListNode n)
    {
        n.data = n.next.data;
        
        n.next=n.next.next;
        
        int i=0;
    }
    
}
