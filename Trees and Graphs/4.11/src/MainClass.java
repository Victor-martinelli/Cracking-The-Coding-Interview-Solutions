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
       Tree arbol = new Tree(new TreeNode(8));
       
       arbol.insertInOrder(7);
       arbol.insertInOrder(5);
       arbol.insertInOrder(6);
       arbol.insertInOrder(10);
       arbol.insertInOrder(12);
       
       System.out.println("Random Node obtained from tree: "+arbol.getRandomNode().getData());
       
    }
    
}
