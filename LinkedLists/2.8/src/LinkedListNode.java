
import java.util.Objects;
import java.util.Random;


public class LinkedListNode {

    public LinkedListNode next, prev, last;
    public int data;

    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        data = d;
        setNext(n);
        setPrevious(p);
    }

    public LinkedListNode(int d) {
        data = d;
    }

    public LinkedListNode() {
    }

    public void setNext(LinkedListNode n) {
        next = n;
        if (this == last) {
            last = n;
            if (n != null && n.prev != this) {
                n.setPrevious(this);
            }
        }
    }
    
    public void appendNode(int data)
    {
        LinkedListNode current = this;
        
        while(current.next!=null)
        {
            current = current.next;
        }
        
        current.next = new LinkedListNode(data);
        
    }
    
        
    public void setPrevious(LinkedListNode p) {
        prev = p;
        if (p != null && p.next
                != this) {
            p.setNext(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.next);
        hash = 59 * hash + this.data * new Random().nextInt();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LinkedListNode other = (LinkedListNode) obj;
        if (this.data != other.data) {
            return false;
        }
        if (!Objects.equals(this.next, other.next)) {
            return false;
        }
        return true;
    }
    
    

    public LinkedListNode clone() {
        LinkedListNode next2 = null;
        if (next != null) {
        }
        next2 = next.clone();
        LinkedListNode head2 = new LinkedListNode(data, next2, null);
        return head2;
    }
}
