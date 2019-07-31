/*
 * Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False
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
        // TODO code application logic here
    }

    /**
     *
     * Java reverse an int value - Pseudocode:
     *
     * a. Extract off the rightmost digit of your input number. (1234 % 10) = 4
     *
     * b. Take that digit (4) and add it into a new reversedNum.
     *
     * c. Multiply reversedNum by 10 (4 * 10) = 40, this exposes a zero to the
     * right of your (4).
     *
     * d. Divide the input by 10, (removing the rightmost digit). (1234 / 10) =
     * 123
     *
     * e. Repeat at step a with 123
     */
    public static boolean isPalindrome(int originalNumber) {
        int reversed = 0;

        if (originalNumber >= 0) {
            int number = originalNumber;

            while (originalNumber != 0) {
                reversed = reversed * 10 + originalNumber % 10;

                originalNumber /= 10;
            }

        }

        return reversed == originalNumber;
    }

}
