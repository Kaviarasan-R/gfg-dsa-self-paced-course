/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

public class D_TrailingZeros {
    public static void main(String[] args) {
        System.out.println(trailingZerosNaive(5));
        System.out.println(trailingZerosEfficient(10));
    }
    // NAIVE SOLUTION
    public static int trailingZerosNaive(int n) {
        int res = 0;
        int temp = factorialIterative(n);
        while(temp % 10 == 0) {
            res++;
            temp = temp / 10;
        }
        return res;
    }
    public static int factorialIterative(int n) {
        int temp = 1;
        for (int i=n; i >= 1; i--) {
            temp = temp * i;
        }
        return temp;
    }
    // EFFICIENT SOLUTION
    public static int trailingZerosEfficient(int n) {
        int res = 0;
        if(n < 5) return 0;
        for(int i = 5; i <= n; i = i * 5) {
            res += (n / i);
        }
        return res;
    }

}
