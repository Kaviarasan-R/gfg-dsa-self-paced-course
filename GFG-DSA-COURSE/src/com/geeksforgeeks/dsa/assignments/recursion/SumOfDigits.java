/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

public class SumOfDigits {
    /*
    You are given a number n. You need to find the sum of digits of n.

    Example 1:
    Input:
    n = 1
    Output: 1
    Explanation: Sum of digit of 1 is 1.

    Example 2:
    Input:
    n = 99999
    Output: 45
    Explanation: Sum of digit of 99999 is 45.
     */
    public static void main(String[] args) {
        System.out.println(sumOfDigits(213));
    }
    public static int sumOfDigits(int n) {
        return n == 0 ? 0 : n%10 + sumOfDigits(n/10);
    }
}
