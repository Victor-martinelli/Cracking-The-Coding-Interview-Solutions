
import java.util.LinkedList;
import java.util.Queue;

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
 
    private Queue dogs;
    private Queue cats;

    public MyQueue() {
        
        dogs  = new LinkedList();
        cats = new LinkedList();
        
    }
    
    public void enqueue(Animal current)
    {
        //We insert the animal into the corresponding type
        
        if(current.getType().equals("Dog"))
        {
            dogs.add(current);
        }
        else if(current.getType().equals("Cat"))
        {
            cats.add(current);
        }
    }
    
    public Animal dequeueDog()
    {
        return (Animal) dogs.remove();
    }
    
    public Animal dequeueCat()
    {
        return (Animal) cats.remove();
    }
    
    public Animal DequeueAny()
    {
        
        //We check which animal from either list is the oldest
        
        Animal oldestDog = (Animal) dogs.peek();
        Animal oldestCat = (Animal)cats.peek();
        
        Animal result;
        
        if(oldestDog.getTimeArrival()<oldestCat.getTimeArrival())
        {
            result=(Animal) dogs.remove();
        }
        else
        {
            result = (Animal) cats.remove();
        }
        return result;
    }
    
    
    
}
