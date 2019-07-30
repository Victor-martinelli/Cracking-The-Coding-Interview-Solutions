
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.youtube.com/watch?v=dolcMgiJ7I0&feature=player_embedded
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
        solution(10);
    }
    
    public static ArrayList<Integer> solution(int A)
    {
       ArrayList<Integer> result = new ArrayList();
        ArrayList<Integer> indices = new ArrayList();
        
        for(int i=0;i<=A;i++)
        {
            indices.add(1);
        }
        
        indices.set(0,0);
        indices.set(1,0);
        
        for(int i=2;i<Math.sqrt(A);i++)
        {
            if(indices.get(i)==1)
            {
                
                result.add(i);
                
                for(int j=2;i*j<=A;j++)
                {
                    indices.set(i*j,0);
                }
                
            }
        }
        
        
        return result;
    }
    
    
    
}
