/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import java.util.Arrays;

public class A_Memoization {
    public static void main(String[] args) {
        int n = 3;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        System.out.println("Naive : " + fibNaive(n));
        System.out.println("Efficient : " + fibEfficient(n,memo));
    }
    public static int fibNaive(int n) {
        if(n == 0 || n == 1) return n;
        else return fibNaive(n-1) + fibNaive(n-2);
    }
    public static int fibEfficient(int n, int[] memo) {
        if(memo[n] == -1) {
            int res;
            if(n == 0 || n == 1) res = n;
            else res = fibNaive(n-1) + fibNaive(n-2);
            memo[n] = res;
        }
        return memo[n];
    }
}
