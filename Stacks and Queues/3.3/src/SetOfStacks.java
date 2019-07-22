
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacks<T> {

    private static class StackNode<T> {

        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }
    
    
    private List<MyStack> stacks;
    
    private int maxCapacity;
    
    private int currentStack;
    
    
    public SetOfStacks(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        stacks = new ArrayList<MyStack>();
        currentStack=-1;
    }
    

    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        
        T item = (T) stacks.get(currentStack).pop();
        
        //If the current stack is empty if we remove the node
        if(stacks.get(currentStack).getCapacity()-1==0)
        {
            //We remove the stack from the list and decrement the counter
            stacks.remove(currentStack);
            currentStack--;
        }

        return item;
    }
    
    public T popAt(int index)
    {
        return (T) stacks.get(index).pop();
    }

    public void push(T item) {
        
        //If the current stack is at it's limit or there are no stacks in the list
        if(this.isEmpty() || stacks.get(currentStack).getCapacity()==maxCapacity)
        {
            //We create a new stack
            MyStack newStack = new MyStack();
            
            //We add the item
            newStack.push(item);
            
            //We increment the current stack index
            currentStack++;
            
            //We add it to the list of stacks
            stacks.add(newStack);
            
        }
        else //If there is still room in the current stack
        {
            //We simply add it to the current stack
            stacks.get(currentStack).push(item);
        }

    }

    public T peek() {
        return (T) stacks.get(currentStack).peek();
    }

    public boolean isEmpty() {
        return stacks.isEmpty();
    }
}
