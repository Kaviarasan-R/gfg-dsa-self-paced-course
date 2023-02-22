/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

public class B_Tabulation {
    public static void main(String[] args) {
        int n = 5;
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        System.out.println(fib[n]);
    }
}
