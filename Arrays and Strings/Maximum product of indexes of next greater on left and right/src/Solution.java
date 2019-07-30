
import java.util.ArrayList;
import java.util.Stack;

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
        ArrayList<Integer>lista = new ArrayList();
        
        lista.add(5);
        lista.add(4);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        
        System.out.println("Max Product: "+maxSpecialProduct(lista));
        
    }
    
    
    public static int maxSpecialProduct(ArrayList<Integer> A) {
        
        ArrayList<Integer> l = leftSpecialV(A);
        ArrayList<Integer> r = rightSpecialV(A);

        long product=0, res= 0;

        //We now simply find out which product is the largest
        for(int i=0;i<A.size();i++){
            res= (long)l.get(i) * (long)r.get(i);
            if(product < res){
                product  = res;
            }
        }

        return (int)(product%1000000007);
    }
    
    
    private static ArrayList<Integer> leftSpecialV(ArrayList<Integer> A){

        ArrayList<Integer> r = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        //We try to find the largest element to the left of each element
        for(int i=0;i<A.size();i++){
            //If the stack is empty or we are larger than the element in the stack, then we simply pop it and keep looking
            while(!s.empty() && A.get(s.peek()) <= A.get(i)){
                s.pop();
            }

            //If the stack is empty, that means that there is no element larger then the current element
            if(s.empty()){
                r.add(0);
            }
            else{ //If there is an element larger than us, we simply add it to the solution
                r.add(s.peek());
            }
            s.push(i);
        }

        return r;
    }

    private static ArrayList<Integer> rightSpecialV(ArrayList<Integer> A){

        ArrayList<Integer> r = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=A.size()-1;i>=0;i--){
            while(!s.empty() && A.get(s.peek()) <= A.get(i)){
                s.pop();
            }

            if(s.empty()){
                //We add a 0 to the end of the result (this is because we are now filling the list from the right instead of the left)
                r.add(0,0);
            }
            else{
                //We add the top element of the stack to the result
                r.add(0,s.peek());
            }
            s.push(i);
        }

        return r;
    }
    
    
}
