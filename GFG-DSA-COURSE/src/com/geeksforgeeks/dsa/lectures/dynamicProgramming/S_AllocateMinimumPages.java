/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import com.geeksforgeeks.dsa.lectures.matrix.A_MultiDimensionalArray;

public class S_AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int n = arr.length;
        int k = 2;
        System.out.println(minPages(arr,n,k));
        System.out.println(dpSolution(arr,n,k));
    }
    public static int minPages(int[] arr, int n, int k) {
        if(k == 1) return sum(arr,0,n-1);
        if(n == 1) return arr[0];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res,
                    Math.max(minPages(arr,i,k-1),sum(arr,i,n-1))
            );
        }
        return res;
    }
    public static int dpSolution(int[] arr, int n, int k) {
        int[][] dp = new int[k+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = sum(arr,0,i-1);
        }
        for (int i = 1; i <= k; i++) {
            dp[i][1] = arr[0];
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int res = Integer.MAX_VALUE;
                for (int p = 1; p < j; p++) {
                    res = Math.min(res,
                            Math.max(dp[i-1][p],sum(arr,p,j-1))
                        );
                }
                dp[i][j] = res;
            }
        }
        A_MultiDimensionalArray.normalMultiDimensionalArray(dp);
        return dp[k][n];
    }
    private static int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
