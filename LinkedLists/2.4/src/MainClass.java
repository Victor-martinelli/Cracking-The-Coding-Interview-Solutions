
import java.util.ArrayList;
import java.util.Iterator;
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

        LinkedListNode n = new LinkedListNode(3);

        LinkedListNode n1 = new LinkedListNode(5);

        LinkedListNode n2 = new LinkedListNode(8);

        LinkedListNode n3 = new LinkedListNode(5);

        LinkedListNode n4 = new LinkedListNode(10);

        LinkedListNode n5 = new LinkedListNode(2);

        LinkedListNode n6 = new LinkedListNode(1);

        n.setNext(n1);

        n1.setNext(n2);

        n2.setNext(n3);

        n3.setNext(n4);

        n4.setNext(n5);

        n5.setNext(n6);

        rearrenge(n, 5);

        partition(n,5);
        
    }

    public static LinkedListNode rearrenge(LinkedListNode n, int x) {

        //List for each one of the elements in the list
        List less = new ArrayList();
        List greater = new ArrayList();
        List equal = new ArrayList();

        //New elements for the new LinkedList
        LinkedListNode start = new LinkedListNode();
        int current = 0;

        while (n != null) {
            //If the element is less than the one we are sorting through
            if (n.data < x) {
                less.add(n.data);
            } else if (n.data > x) {
                greater.add(n.data);
            } else {
                equal.add(n.data);
            }
            n = n.next;
        }

        //Iterators to go through each one of the lists
        Iterator itLess = less.iterator();
        Iterator itGreater = greater.iterator();
        Iterator itEqual = equal.iterator();

        //We start to set up the linked list
        start.data = (int) itLess.next();

        //While there is still objects in the lists
        while (itLess.hasNext() || itGreater.hasNext() || itEqual.hasNext()) {

            //If there are elements lower than the pivot, we add it to the new linked list
            if (itLess.hasNext()) {
                current = (int) itLess.next();
            } else if (itGreater.hasNext()) //If there are elements greater than the pivot, we add it to the new linked list
            {
                current = (int) itGreater.next();
            } else //If there are elements equal than the pivot, we add it to the new linked list
            {
                current = (int) itEqual.next();
            }

            start.appendNode(current);

        }

        return start;
    }

    //Elements that are smaller than the pivot are inserted at the start and
    //Elements that are bigger than the pivot are inserted at the end of the list
    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                /* Insert node at head. (start) */
                node.next = head;
                head = node;
            } else {
                /* Insert node at tail. (end) */
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        // The head has changed, so we need to return it to the user.
        return head;
    }

}
