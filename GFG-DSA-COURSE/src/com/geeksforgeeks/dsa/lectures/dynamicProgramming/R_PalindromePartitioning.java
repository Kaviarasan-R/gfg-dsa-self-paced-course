/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import com.geeksforgeeks.dsa.lectures.matrix.A_MultiDimensionalArray;

public class R_PalindromePartitioning {
    public static void main(String[] args) {
        /* MINIMIZE THE CUTS */
        String str = "geek";
        int i = 0;
        int j = str.length()-1;
        System.out.println("NAIVE SOLUTION : " + naiveSolution(str,i,j));
        System.out.println("DP SOLUTION : " + dpSolution(str));
    }
    public static int naiveSolution(String str, int i, int j) {
        if(isPalindrome(str,i,j)) return 0;
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            res = Math.min(res,1 + naiveSolution(str,i,k)+naiveSolution(str,k+1,j));
        }
        return res;
    }
    public static int dpSolution(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        /* INSTEAD OF CALLING IS PALINDROME FUN */
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int gap = 1; gap < n; gap++) { // GAP TO START FROM THE COLUMN
            for (int i = 0; i+gap < n; i++) { // ROW
                int j = i+gap; // ROW + GAP
                //if(isPalindrome(str,i,j)) dp[i][j] = 0;
                /* INSTEAD OF CALLING IS PALINDROME FUN */
                if(str.charAt(i)==str.charAt(j) && (isPalindrome[i+1][j-1] || gap==1)) {
                    dp[i][j] = 0;
                    isPalindrome[i][j] = true;
                }
                else {
                    isPalindrome[i][j] = false;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k+1][j]);
                    }
                }
            }
        }
        System.out.println("PALINDROME ARRAY : ");
        A_MultiDimensionalArray.normalMultiDimensionalArray(isPalindrome);
        System.out.println("DP ARRAY : ");
        A_MultiDimensionalArray.normalMultiDimensionalArray(dp);
        return dp[0][n-1];
    }
    public static boolean isPalindrome(String str, int low, int high) {
        while(low < high) {
            if(str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }
}
