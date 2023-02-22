/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.recursion;

public class A_Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static int factorial(int n) {
        if(n == 0 || n == 1) return 1;
        return n * factorial(n-1);
    }
}
