/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import java.util.Arrays;

public class I_MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {3,4,1};
        int n = coins.length;
        int value = 5;
        System.out.println("NAIVE SOLUTION : " + naiveSolution(coins,value,n));
        System.out.println("DP SOLUTION : " + dpSolution(coins,value,n));
    }
    public static int naiveSolution(int[] coins, int value, int n) {
        if(value == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(coins[i] <= value) {
                int x = naiveSolution(coins,value-coins[i],n);
                if(x != Integer.MAX_VALUE) res = Math.min(res,x+1);
            }
        }
        return res;
    }
    public static int dpSolution(int[] coins, int value, int n) {
        int[] dp = new int[value+1];
        for (int i = 1; i < dp.length; i++) {
            int y = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(coins[j] <= i) {
                    int x = i - coins[j];
                    y = Math.min(y,dp[x]+1);
                }
            }
            dp[i] = y;
        }
        System.out.println("DP ARRAY : " + Arrays.toString(dp));
        return dp[value];
    }
}
