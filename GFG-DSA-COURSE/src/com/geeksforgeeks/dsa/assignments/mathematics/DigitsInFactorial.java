/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class DigitsInFactorial {
    /*
    Given an integer N. Find the number of digits that appear in its factorial.
    Factorial is defined as, factorial(n) = 1*2*3*4……..*N and factorial(0) = 1.

    Example 1:
    Input: N = 5
    Output: 3
    Explanation: Factorial of 5 is 120.
    Number of digits in 120 is 3 (1, 2, and 0)
    */
    public static void main(String[] args) {
        System.out.println(digitsInFactorial(5));
    }
    public static int digitsInFactorial(int N){
        if(N < 0) return 0;
        if(N <= 1) return 1;
        double d = 0;
        for (int i=2; i<=N; i++){
            d += Math.log10(i);
        }
        return (int) Math.floor(d) + 1;
    }
}
