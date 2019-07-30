
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author victormartinelli
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList();
        
        a.add(4);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(3);
        
        System.out.println("ORIGINAL LIST");
        printList(a);
        
        a=solution(a);
        
        System.out.println("REARRANGED LIST");
        printList(a);
        
    }

    public static ArrayList<Integer> solution(ArrayList<Integer> a) {
        if (a.size() > 0) {

            //We encode the array so that each value holds its new and old value at
            //the same time
            for (int i = 0; i < a.size(); i++) {
                a.set(i, a.get(i) + (a.get(a.get(i)) % a.size()) * a.size());
            }

            //Using this property, if we simply divide by the size, we obtain the new value
            //If we want the old value, we simply do the mod by the size
            for (int i = 0; i < a.size(); i++) {
                a.set(i, a.get(i) / a.size());
            }

        }

        return a;
    }
    
    public static void printList(ArrayList<Integer> a)
    {
        for(int element : a)
        {
            System.out.print(element);
        }
        System.out.println();
    }

}
