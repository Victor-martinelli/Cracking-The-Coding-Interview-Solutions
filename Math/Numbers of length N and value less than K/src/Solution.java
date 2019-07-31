
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

/*
 *Given a set of digits A[] in sorted order and two integers N and K, the task 
is to find how many numbers of length N are possible whose value is less than K 
and the digits are from the given set only. Note that you can use the same digit 
multiple times.

Examples:

Input: A[] = {0, 1, 5}, N = 1, K = 2
Output: 2
Only valid numbers are 0 and 1.

Input: A[] = {0, 1, 2, 5}, N = 2, K = 21
Output: 5
10, 11, 12, 15 and 20 are the valid numbers.

/**
 *
 * @author Portatil
 */
public class Solution {

    static int MAX = 10;

    public static void main(String[] args) {
        // TODO code application logic here
    }

    static Vector<Integer> numToVec(int N) {
        Vector<Integer> digit = new Vector<Integer>();

        // Push all the digits of N from the end 
        // one by one to the vector 
        while (N != 0) {
            digit.add(N % 10);
            N = N / 10;
        }

        // If the original number was 0 
        if (digit.size() == 0) {
            digit.add(0);
        }

        // Reverse the vector elements 
        Collections.reverse(digit);

        // Return the required vector 
        return digit;
    }

    public int solve(ArrayList<Integer> A, int B, int C) {

        Vector<Integer> digit = new Vector<Integer>();
        int d, d2;

        // Convert number to digit array 
        digit = numToVec(C);
        d = A.size();

        // Case 1: No such number possible as the 
        // generated numbers will always 
        // be greater than C 
        if (B > digit.size() || d == 0) {
            return 0;
        } // Case 2: All integers of length B are valid 
        // as they all are less than C 
        else if (B < digit.size()) {
            // contain 0 
            if (A.get(0) == 0 && B != 1) {
                return (int) ((d - 1) * Math.pow(d, B - 1));
            } else {
                return (int) Math.pow(d, B);
            }
        } // Case 3 
        else {
            int[] dp = new int[B + 1];
            int[] lower = new int[MAX + 1];

            // Update the lower[] array such that 
            // lower[i] stores the count of elements 
            // in A[] which are less than i 
            for (int i = 0; i < d; i++) {
                lower[A.get(i) + 1] = 1;
            }
            for (int i = 1; i <= MAX; i++) {
                lower[i] = lower[i - 1] + lower[i];
            }

            boolean flag = true;
            dp[0] = 0;
            for (int i = 1; i <= B; i++) {
                d2 = lower[digit.get(i - 1)];
                dp[i] = dp[i - 1] * d;

                // For first index we can't use 0 
                if (i == 1 && A.get(0) == 0 && B != 1) {
                    d2 = d2 - 1;
                }

                // Whether (i-1) digit of generated number 
                // can be equal to (i - 1) digit of C 
                if (flag) {
                    dp[i] += d2;
                }

                // Is digit[i - 1] present in A ? 
                flag = (flag & (lower[digit.get(i - 1) + 1]
                        == lower[digit.get(i - 1)] + 1));
            }
            return dp[B];
        }
    }
    
    
    /**
     *  public boolean zeroPresent(ArrayList<Integer> A,int num){
        for(int i=0;i<A.size();i++){
            if(A.get(i)==num){
                return true;
            }
        }
        return false;
    }
    public int calculate(ArrayList<Integer> A,ArrayList<Integer> number,int index,int B){
        if(index==B){
            return 0;
        }
        int lessthan = 0;
        for(int i=0;i<A.size();i++){
            if(A.get(i)<number.get(index)){
                if(A.get(i)==0&&index==0&&B>1)
                    lessthan--;
                lessthan++;
            }
        }
        int result = lessthan*((int)Math.pow(A.size(),B-index-1));
        boolean isPresent = zeroPresent(A,number.get(index));
        if(isPresent){
            result = result+(calculate(A,number,index+1,B));
        }
        return result;
    }
    public int solve(ArrayList<Integer> A, int B, int C) {
        ArrayList<Integer> number = new ArrayList<Integer>();
        while(C!=0){
            number.add(0,C%10);
            C /= 10;
        }
        if(number.size()<B){
            return 0;
        }
        else if(number.size()>B){
            boolean isZero = zeroPresent(A,0);
            if(isZero&&B>1){
                return (A.size()-1)*((int)Math.pow(A.size(),B-1));
            }else{
                return (int)Math.pow(A.size(),B);
            }
        }else{
            return calculate(A,number,0,B);
        }
    }
     */

}
