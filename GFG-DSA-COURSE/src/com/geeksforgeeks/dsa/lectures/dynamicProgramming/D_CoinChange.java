/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

public class D_CoinChange {
    public static void main(String[] args) {
        int[] coins = {2,5,3,6};
        int sum = 10;
        int n = coins.length;
        System.out.println("NAIVE : " + naiveSolution(coins,sum,n));
        System.out.println("EFFICIENT : " + naiveSolution(coins,sum,n));
    }
    public static int naiveSolution(int[] coins, int sum, int n) {
        if(sum == 0) return 1;
        if(sum < 0) return 0;
        if(n == 0) return 0;
        return naiveSolution(coins,sum-coins[n-1],n)  // INCLUDED
                + naiveSolution(coins,sum,n-1); // NOT INCLUDED
    }
    public static int efficientSolution(int[] coins, int sum, int n) {
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j]; // PREV ROW CURR COL
                if(coins[i-1] <= j) { // GETTING COINS FROM STARTING
                    dp[i][j] += dp[i][j - coins[i-1]]; // ADDING TO CURR CELL
                }
            }
        }
        return dp[n][sum];
    }
}
