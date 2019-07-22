
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

        LinkedListNode n4 = new LinkedListNode(5);
        
       LinkedListNode n5 = new LinkedListNode(3);
        
        n.setNext(n1);
        
        n1.setNext(n2);
        
        n2.setNext(n3);
        
        n3.setNext(n4);
        
        n4.setNext(n2);
        
        System.out.println("Is there a loop?: "+isThereLoop(n).data);
        
    }
    
    public static LinkedListNode isThereLoop(LinkedListNode n)
    {
        List<LinkedListNode>nList = new ArrayList<LinkedListNode>();
        
        boolean result=false;
        
        //While we havent found a loop or there are more nodes to look at
        
        while(!result && n!=null)
        {
            //It it's in the list
            if(nList.contains(n))
            {
                result=true;
            }
            else
            {
                nList.add(n);
                n=n.next;
            }
            
            
        }
        
        
        return n;
    }
}
