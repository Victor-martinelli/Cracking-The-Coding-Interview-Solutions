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
        
        cola.add(4);
        cola.add(3);
        cola.add(2);
        cola.add(1);
        
        cola.remove();
        
    }
    
}
