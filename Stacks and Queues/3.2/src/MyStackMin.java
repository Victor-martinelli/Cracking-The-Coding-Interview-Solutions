
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStackMin {

    private static class StackNode {

        private int data;
        private StackNode next;

        public StackNode(int data) {
            this.data = data;
        }
    }

    public MyStackMin() {
        listMin = new ArrayList<StackNode>();
        
    }
    
    

    private StackNode top;
    
    private StackNode min;
    
    private List<StackNode> listMin;
    

    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        StackNode item = top;
        top = top.next;
        
        //If the item that we remove is the min element if the stack
        if(item.data==min.data)
        {
            //We set up the next min as the current min
            listMin.remove(item);
            min=listMin.get(listMin.size()-1);
        }
        
        return item.data;
    }

    public void push(int item) {

        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
        
        //If the element that we insert is less than out minimum
        if(min==null || top.data<min.data)
        {
            listMin.add(t);
            min=top;
        }
    }

    public int peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
