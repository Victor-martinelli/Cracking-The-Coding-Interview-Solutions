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
       
       int index = 1;
        
       System.out.println("The "+index+"th to last element in the linked list is: "+findElement(n,2,1));
       
    }
    
    public static int findElement(LinkedListNode n,int wIndex,int currentIndex)
    {
        int value=0;
        
        //If we want an index that is too long for the linkedlist
        if(n==null)
        {
            value=Integer.MIN_VALUE;
        }
        else
        {
            //If we found the index
            if(wIndex==currentIndex)
            {
                value=n.data;
            }
            else //If we didn't reach the desired index yet, we keep looking
            {
                
                value=findElement(n.next,wIndex,currentIndex+1);
            }
        }
        
        return value;
    }
    
}
