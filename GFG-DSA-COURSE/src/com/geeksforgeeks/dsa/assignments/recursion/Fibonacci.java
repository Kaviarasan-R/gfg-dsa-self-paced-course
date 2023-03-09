/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

public class Fibonacci {
    /*
    You are given a number n. You need to find nth Fibonacci number.
    F(n)=F(n-1)+F(n-2); where F(1)=1 and F(2)=1

    Example 1:
    Input:
    n = 1
    Output: 1
    Explanation: The first fibonacci number is 1

    Example 2:
    Input:
    n = 20
    Output:6765
    Explanation: The 20th fibonacci
    number is 6765
    */
    public static void main(String[] args) {
        System.out.println(fibonacci(20));
    }
    public static int fibonacci(int n) {
        if( n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
