/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class Factorial {
    /*
    Given a positive integer N. The task is to find factorial of N.

    Example 1:
    Input:
    N = 4
    Output: 24
    Explanation: 4! = 4 * 3 * 2 * 1 = 24
    */
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
    public static long factorial(int N) {
        if(N == 0) return 1;
        return N * factorial(N-1);
    }
}
