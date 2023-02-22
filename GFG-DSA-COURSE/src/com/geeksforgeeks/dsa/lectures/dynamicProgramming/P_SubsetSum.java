/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import com.geeksforgeeks.dsa.lectures.matrix.A_MultiDimensionalArray;

public class P_SubsetSum {
    public static void main(String[] args) {
        int[] arr = {10,20,15};
        int sum = 25;
        int n = arr.length;
        System.out.println(countSubsets(arr,n,sum));
        System.out.println(dpSolution(arr,n,sum));
    }
    public static int countSubsets(int[] arr, int n, int sum) {
        if(n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        return countSubsets(arr,n-1,sum) + countSubsets(arr,n-1,sum-arr[n-1]);
    }
    public static int dpSolution(int[] arr, int n, int sum) {
        int dp[][] = new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= sum; i++) dp[1][i] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(j < arr[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - arr[i-1]];
                }
            }
        }
        A_MultiDimensionalArray.normalMultiDimensionalArray(dp);
        return dp[n][sum];
    }
}
