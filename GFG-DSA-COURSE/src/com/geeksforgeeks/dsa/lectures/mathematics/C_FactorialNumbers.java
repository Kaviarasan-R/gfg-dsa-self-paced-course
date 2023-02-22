/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

public class C_FactorialNumbers {
    public static void main(String[] args) {
        System.out.println(factorialRecursion(5));
        System.out.println(factorialIterative(5));
    }
    public static int factorialIterative(int n) {
        int temp = 1;
        for (int i=n; i >= 1; i--) {
            temp = temp * i;
        }
        return temp;
    }
    public static int factorialRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursion(n - 1);
    }
}
