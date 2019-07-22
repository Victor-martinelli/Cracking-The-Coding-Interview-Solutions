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
        MyStackMin stack = new MyStackMin();
        
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(-3);
        
        stack.pop();
        
    }
    
}
