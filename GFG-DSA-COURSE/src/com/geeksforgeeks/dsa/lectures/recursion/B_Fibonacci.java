/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.recursion;

public class B_Fibonacci {
    static int n1 = 0;
    static int n2 = 1;
    static int n3 = 0;

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        fibonacciIterative(10);
        System.out.print("\n" + n1 + " " + n2 + " ");
        fibonacciRecursive(10-2); // because we already printed 2 values
    }
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void fibonacciIterative(int n) {
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 2; i < n; i++) {
            n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
    }
    public static void fibonacciRecursive(int n) {
        if(n > 0) {
            n3 = n1 + n2;
            System.out.print(n3+" ");
            n1 = n2;
            n2 = n3;
            fibonacciRecursive(n-1);
        }
    }
}
