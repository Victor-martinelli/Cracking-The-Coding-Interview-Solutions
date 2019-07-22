/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class MyQueue {
    
    private MyStack oldest;
    private MyStack newest;

    public MyQueue() {
        oldest = new MyStack();
        newest = new MyStack();
    }
    
    //Returns the size of the queue
    public int size()
    {
        return oldest.getCapacity() + newest.getCapacity();
    }
    
    
    public void add(Object value)
    {
        //We add the new element to the newest stack
        newest.push(value);
    }
    
    private void shiftStacks()
    {
        //We shift the stacks if the oldest stack is empty (the elements are already ready to be popped)
        if(oldest.isEmpty())
        {
            //We continue to move elements until newest is empty
            while(!newest.isEmpty())
            {
                //We move the elements from one stack to the next one
                oldest.push(newest.pop());
            }
        }
    }
    
    public Object peek()
    {
        
        //To see what which is the next element to be removed from the queue,
        //we first have to move all the elements to the oldest stack
        
        shiftStacks();
        
        return oldest.peek();
        
    }
    
    public Object remove()
    {
        //To remove the element, we first have to move all the elements to the
        //oldest stack
        
        shiftStacks();
        
        //Now we remove pop the element in the oldest stack
        return oldest.pop();
        
    }
    
}
