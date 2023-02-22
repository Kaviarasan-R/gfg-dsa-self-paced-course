/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import com.geeksforgeeks.dsa.lectures.matrix.A_MultiDimensionalArray;

public class M_EggDropping {
    public static void main(String[] args) {
        /* EGG DROPPING PUZZLE */
        int e = 3;
        int f = 5;
        System.out.println(res(e,f));
    }
    public static int res(int e, int f) {
        int dp[][] = new int[f+1][e+1];
        for (int i = 1; i <= e; i++) {
            dp[1][i] = 1; // res(1,e) = 1
            dp[0][i] = 0; // res(0,e) = 0
        }
        for (int i = 1; i <= f; i++) dp[i][1] = i; // res(f,1) = f
        for (int i = 2; i <= f; i++) {
            for (int j = 2; j <= e; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    dp[i][j] = Math.min(dp[i][j],1+Math.max(dp[x-1][j-1],dp[i-x][j]));
                }
            }
        }
        A_MultiDimensionalArray.normalMultiDimensionalArray(dp);
        return dp[f][e];
    }
}
