/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import com.geeksforgeeks.dsa.lectures.matrix.A_MultiDimensionalArray;

public class Q_MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4};
        int i = 0;
        int j = arr.length-1;
        System.out.println(mChain(arr,i,j));
        System.out.println(dpSolution(arr,arr.length));
    }
    public static int mChain(int[] arr, int i, int j) {
        if(i + 1 == j) return 0; // It means single matrix
        int res = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            res = Math.min(
                    res,
                    mChain(arr,i,k) + mChain(arr,k,j) + (arr[i] * arr[k] * arr[j])
            );
        }
        return res;
    }
    public static int dpSolution(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n-1; i++) { // SINGLE MATRIX
            dp[i][i+1] = 0;
        }
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i+gap < n; i++) {
                int j = i+gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + (arr[i] * arr[k] * arr[j]));
                }
            }
        }
        A_MultiDimensionalArray.normalMultiDimensionalArray(dp);
        return dp[0][n-1];
    }
}
