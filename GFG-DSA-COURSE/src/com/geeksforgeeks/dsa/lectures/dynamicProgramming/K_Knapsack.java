/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import com.geeksforgeeks.dsa.lectures.matrix.A_MultiDimensionalArray;

public class K_Knapsack {
    public static void main(String[] args) {
        int[] v = {10,40,30,50};
        int[] w = {5,4,6,3};
        int weight = 10;
        int n = v.length;
        System.out.println("NAIVE SOLUTION : " + naiveSolution(v,w,weight,n));
        System.out.println("DP SOLUTION : " + dpSolution(v,w,weight,n));
    }
    public static int naiveSolution(int[] v, int[] w, int weight, int n) {
        if(n == 0 || weight == 0) return 0;
        if(w[n-1] > weight) return naiveSolution(v,w,weight,n-1);
        else return Math.max(naiveSolution(v,w,weight,n-1),
                    v[n-1] + naiveSolution(v,w,weight-w[n-1],n-1)
                );
    }
    public static int dpSolution(int[] v, int[] w, int weight, int n) {
        int[][] dp = new int[n+1][weight+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= weight; j++) {
                /* IF CURR WEIGHT IS GREATER THAN N-th CAPACITY, PREV ROW SAME COLUMN */
                if(w[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(
                        v[i-1] + dp[i-1][j-w[i-1]],
                        dp[i-1][j]
                );
            }
        }
        System.out.println("DP 2D ARRAY : ");
        A_MultiDimensionalArray.normalMultiDimensionalArray(dp);
        return dp[n][weight];
    }
}
