/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import java.util.Arrays;

public class C_LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AXYZ";
        String s2 = "BAZ";
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i],-1);
        }
        System.out.println("LCS NAIVE : " + LCSNaive(s1,s2,m,n));
        System.out.println("LCS MEMO : " + LCSMemo(s1,s2,m,n,memo));
        System.out.println("LCS TABULATION : " + LCSTabulation(s1,s2,m,n));
    }
    public static int LCSNaive(String s1, String s2, int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(s1.charAt(m-1) == s2.charAt(n-1)) return 1 + LCSNaive(s1,s2,m-1,n-1);
        else return Math.max(LCSNaive(s1,s2,m-1,n),LCSNaive(s1,s2,m,n-1));
    }
    public static int LCSMemo(String s1, String s2, int m, int n, int[][] memo) {
        if(memo[m][n] != -1) {
            return memo[m][n];
        }
        if(m == 0 || n == 0) memo[m][n] = 0;
        else {
            if (s1.charAt(m-1) == s2.charAt(n-1)) {
                /** IF LAST S1 & S2 ARE MATCHING, REMOVE LAST FROM BOTH. **/
                memo[m][n] = 1 + LCSMemo(s1,s2,m-1,n-1,memo);
            } else {
                /** IF LAST S1 & S2 NOT MATCHING, WE CALL 2 FUN TO RETURN MAX --> (M-1) && (N-1) **/
                memo[m][n] = Math.max(LCSMemo(s1,s2,m-1,n,memo),LCSMemo(s1,s2,m,n-1,memo));
            }
        }
        return memo[m][n];
    }
    public static int LCSTabulation(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        /* for (int i = 0; i <= m; i++) {
            dp[i][0] = 0; // PRINTING 0th COL OF EVERY ROW AS 0.
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0; // PRINTING 0th ROW AS 0.
        } **/
        for (int i = 1; i <= m; i++) {  // ROW
            for (int j = 1; j <= n; j++) {  // COL
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    /** IF LAST S1 & S2 ARE MATCHING, ADD 1 TO ABOVE ROW's PREV COL. **/
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    /**
                     IF LAST S1 & S2 ARE NOT MATCHING, GET MAX OF ``CURR ROW PREV COL``
                     & ``PREV ROW CURR COL``
                     **/
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
