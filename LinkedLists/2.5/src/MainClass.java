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
        LinkedListNode n = new LinkedListNode(7);

        LinkedListNode n1 = new LinkedListNode(1);

        LinkedListNode n2 = new LinkedListNode(6);

        LinkedListNode n3 = new LinkedListNode(5);

        LinkedListNode n4 = new LinkedListNode(9);

        LinkedListNode n5 = new LinkedListNode(2);

        n.setNext(n1);

        n1.setNext(n2);

        n3.setNext(n4);

        n4.setNext(n5);


        LinkedListNode result = add(n,n3);
        
        
        int i;
        
    }
    
    
    public static LinkedListNode add(LinkedListNode n1,LinkedListNode n2)
    {
        int carry=0;
        
        LinkedListNode result = new LinkedListNode();
        LinkedListNode current = result;
        
        //While there are still elements to add
        
        while(n1!=null && n2!=null)
        {
            //Result of operation
            int resultOp = n1.data + n2.data;
            
            //If there is a carry
            if(carry>0)
            {
                resultOp+=1;
                carry-=1;
            }
            
            //If the result goes above 1 digit
            if(resultOp>=10)
            {
                carry+=1;
                resultOp-=10;
            }
            
            current.data=resultOp;
            
            current.next= new LinkedListNode();
            
            current = current.next;
            
            n1 = n1.next;
            n2=n2.next;
            
        }
        
        
        return result;
    }
    
}
