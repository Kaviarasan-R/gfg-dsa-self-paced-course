/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

public class CountDigits {
    /*
    You are given a number n. You need to find the count of digits in n.

    Example 1:
    Input:
    n = 1
    Output: 1
    Explanation: Number of digit in 1 is 1.

    Example 2:
    Input:
    n  = 99999
    Output: 5
    Explanation:Number of digit in 99999 is 5
    */
    public static void main(String[] args) {
        System.out.println(countDigit(9999));
    }
    public static int countDigit(int n) {
        if (n/10 == 0) return 1;
        return 1 + countDigit(n / 10);
    }
}
