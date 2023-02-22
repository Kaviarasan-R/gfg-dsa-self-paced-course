/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import com.geeksforgeeks.dsa.lectures.matrix.A_MultiDimensionalArray;

public class E_EditDistance {
    public static void main(String[] args) {
        /* CONVERT FROM S1 TO S2 USING REPLACE,INSERT,DELETE IN MINIMUM OPERATION */
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";
        int m = s1.length();
        int n = s2.length();
        System.out.println("NAIVE : " + naiveSolution(s1,s2,m,n));
        System.out.println("EFFICIENT : " + efficientSolution(s1,s2,m,n));
    }
    public static int naiveSolution(String s1, String s2, int m, int n) {
        if(m == 0) return n;
        if(n == 0) return m;
        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            return naiveSolution(s1,s2,m-1,n-1);
        } else {
            int minimum = Math.min(
                            naiveSolution(s1,s2,m,n-1), // INSERTION
                            naiveSolution(s1,s2,m-1,n) // DELETION
                          );
            return 1 + Math.min(minimum,naiveSolution(s1,s2,m-1,n-1)); // REPLACE
        }
    }
    public static int efficientSolution(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int minimum = Math.min(dp[i-1][j],dp[i][j-1]); // TOP, LEFT
                    dp[i][j] = 1 + Math.min(minimum,dp[i-1][j-1]); // DIAGONAL
                }
            }
        }
        A_MultiDimensionalArray.normalMultiDimensionalArray(dp);
        return dp[m][n];
    }
}
