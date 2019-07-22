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
        
        SetOfStacks stacks = new SetOfStacks(1);
        
        System.out.println("Is it empty?: "+stacks.isEmpty());
        
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        
        stacks.pop();
        
    }
    
}
