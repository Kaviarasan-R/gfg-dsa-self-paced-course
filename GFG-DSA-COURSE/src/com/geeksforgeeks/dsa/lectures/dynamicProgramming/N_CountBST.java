/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import java.util.Arrays;

public class N_CountBST {
    public static void main(String[] args) {
        /* COUNT BST WITH N KEYS */
        int n = 5;
        System.out.println("COUNT BST : " + countBST(n));
    }
    public static int countBST(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        System.out.println("DP ARRAY : " + Arrays.toString(dp));
        return dp[n];
    }
}
