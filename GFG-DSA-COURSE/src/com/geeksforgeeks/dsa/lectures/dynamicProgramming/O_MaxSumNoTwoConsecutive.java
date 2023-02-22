/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import java.util.Arrays;

public class O_MaxSumNoTwoConsecutive {
    public static void main(String[] args) {
        /* MAXIMUM SUM WITH NO TWO CONSECUTIVE */
        int[] arr = {10,5,15,20,2,30};
        int n = arr.length;
        System.out.println("NAIVE SOLUTION : " + naiveSolution(arr,n));
        System.out.println("DP SOLUTION : " + dpSolution(arr,n));
    }
    public static int naiveSolution(int[] arr, int n) {
        if(n == 1) return arr[0];
        else if(n == 2) return Math.max(arr[0],arr[1]);
        else return Math.max(naiveSolution(arr,n-1),naiveSolution(arr,n-2)+arr[n-1]);
    }
    public static int dpSolution(int[] arr, int n) {
        if(n == 1) return arr[0];
        int[] dp = new int[n+1];
        dp[1] = arr[0];
        dp[2] = Math.max(arr[0],arr[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i-1]);
        }
        System.out.println("DP ARRAY : " + Arrays.toString(dp));
        return dp[n];
    }
}
