
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
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Node n = new Node("6");
        Node n1 = new Node("3");
        Node n2 = new Node("4");
        Node n3 = new Node("2");
        Node n4 = new Node("5");
        Node n5 = new Node("1");
        
        n5.addChild(n4);
        n5.addChild(n3);
        n5.addChild(n2);
        
        n3.addChild(n1);
        
        n4.addChild(n);
        
        System.out.println("Is there a path between "+n5.getName()+" and "+n.getName()+"?: "+routeBetweenTwoNodes(n5,n));
        
    }
    
     public static boolean routeBetweenTwoNodes(Node origin, Node destination)
    {
        boolean result = false;
        
        //Here we wil lsave all the children nodes
        Queue<Node> cola = new LinkedList<Node>();
        
        Node current = origin;
        
        //We queue the element to later search its children
        cola.add(current);
        
        //We iterate thought the queue
        while(!result && !cola.isEmpty())
        {
            current = cola.remove();
            
            //If the element is not the one we are looking for and it has not been visited
            if(current!=destination && current.isIsVisited()==false)
            {
                current.setIsVisited(true);
                //We iterate through the children of the current node and add them to the queue
                for(Node child: current.getChildren())
                {
                    cola.add(child);
                }
            }
            else if(current==destination) // If we have found the node
            {
                result=true;
            }
            
        }
        
        return result;
    }
    
}
