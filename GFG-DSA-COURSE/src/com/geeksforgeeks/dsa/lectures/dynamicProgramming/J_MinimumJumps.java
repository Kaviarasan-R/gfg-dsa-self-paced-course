/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import java.util.Arrays;

public class J_MinimumJumps {
    public static void main(String[] args) {
        int[] arr = {3,4,2,1,2,1};
        int n = arr.length;
        System.out.println("NAIVE SOLUTION : " + naiveSolution(arr,n));
        System.out.println("DP SOLUTION : " + dpSolution(arr,n));
    }
    public static int naiveSolution(int[] arr, int n) {
        if(n == 1) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n-2; i++) {
            if(i+arr[i]>=n-1) {
                int sub_res = naiveSolution(arr,i+1);
                if(sub_res != Integer.MAX_VALUE) {
                    res = Math.min(res,sub_res+1);
                }
            }
        }
        return res;
    }
    public static int dpSolution(int[] arr, int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j]+j >= i) {
                    if(dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i],dp[j]+1);
                    }
                }
            }
        }
        System.out.println("DP ARRAY : " + Arrays.toString(dp));
        return dp[n-1];
    }
}
