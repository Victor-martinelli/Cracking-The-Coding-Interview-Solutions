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

        LinkedListNode n2 = new LinkedListNode(8);

        LinkedListNode n3 = new LinkedListNode(6);

        LinkedListNode n4 = new LinkedListNode(0);
        
        LinkedListNode n5 = new LinkedListNode(5);
        
        LinkedListNode n6 = new LinkedListNode(5);
         
        LinkedListNode n7 = new LinkedListNode(0);

        
        n.setNext(n1);
        n1.setNext(n4);
        
        n2.setNext(n3);
        n3.setNext(n4);
        
        n4.setNext(n5);
        
        
        /*
        n.setNext(n1);
        n1.setNext(n4);
        n4.setNext(n6);
        
        n2.setNext(n3);
        n3.setNext(n7);
        n7.setNext(n5);
        */


        System.out.println("Is it intersection?: "+isIntersection(n,n2));
        
        
    }
    
    public static boolean isIntersection(LinkedListNode s1,LinkedListNode s2)
    {
        boolean result=false;
        
        while(s1!=null && s2!=null && !result)
        {
            //If there are the same node
            if(s1==s2)
            {
                result=true;
            }
            
            s1=s1.next;
            s2=s2.next;
            
        }
        
        return result;
    }
    
}
