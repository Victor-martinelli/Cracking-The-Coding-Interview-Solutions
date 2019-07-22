
import java.sql.Timestamp;

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
        
        MyQueue cola = new MyQueue();
        
        cola.enqueue(new Animal("Dog",System.nanoTime()));
        cola.enqueue(new Animal("Cat",System.nanoTime()));
        cola.enqueue(new Animal("Cat",System.nanoTime()));
        cola.enqueue(new Animal("Dog",System.nanoTime()));
        
        cola.dequeueCat();
        cola.dequeueDog();
        cola.DequeueAny();
        
    }
    
}