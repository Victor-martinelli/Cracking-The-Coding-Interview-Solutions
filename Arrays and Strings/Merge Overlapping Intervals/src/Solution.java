
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Portatil
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // [1,3],[2,6],[8,10],[15,18]

        List<Interval> lista = new ArrayList();

        lista.add(new Interval(1, 3));

        lista.add(new Interval(2, 6));

        lista.add(new Interval(8, 10));

        lista.add(new Interval(15, 18));
        
        
        System.out.println("Before: ");
                
        printList(lista);
        
        lista = Solution(lista);
        
        System.out.println("After: ");
        
        printList(lista);
        
    }

    public static List<Interval> Solution(List<Interval> intervals) {

        //If there is more than one element to mergue
        if (intervals.size() > 1) {

            //We first sort the entire list
            Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

            for (int i = 0; i < intervals.size(); i++) {
                int j = i + 1;

                while (j < intervals.size() && i < intervals.size()) {
                    Interval candidateA = intervals.get(i);

                    Interval candidateB = intervals.get(j);

                    
                    //We iterate through the entire list and check if it needs to merge
                    if (candidateA.end >= candidateB.start && candidateA.start <= candidateB.end) {
                        
                        //We keep the limits of the range and then we keep ut
                        int min = Math.min(candidateA.start, candidateB.start);
                        int max = Math.max(candidateA.end, candidateB.end);

                        intervals.get(i).start = min;
                        intervals.get(i).end = max;

                        intervals.remove(j);

                        //Because deleting the item might result in an index that is out of bounds, we update it
                        if (j > intervals.size()) {
                            j = intervals.size();
                        }
                    } else {
                        j += 1;
                    }

                }
            }

        }

        return intervals;
    }
    
    
    public static void printList(List<Interval> lista)
    {
        for(int i=0;i<lista.size();i++)
        {
            System.out.println("Index: "+i+" - start: "+lista.get(i).start+" end: "+lista.get(i).end);
        }
    }

}
