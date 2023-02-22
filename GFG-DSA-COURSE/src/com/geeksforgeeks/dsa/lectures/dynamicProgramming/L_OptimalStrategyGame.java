/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import com.geeksforgeeks.dsa.lectures.matrix.A_MultiDimensionalArray;

public class L_OptimalStrategyGame {
    public static void main(String[] args) {
        /*
         MAX COINS CAN BE COLLECTED IN ARRAY, YOU HAVE THE EDGE OVER OPPONENT THAT YOU'VE FIRST
         CHOICE TO PICK COINS
         */
        int[] arr = {20,5,4,6};
        int n = arr.length;
        int sum = 35;
        int[] arr2 = {20,5,4,6,8,3};
        int n2 = arr2.length;
        System.out.println("NAIVE SOLUTION : " + naiveSolution(arr,0,n-1,sum));
        System.out.println("EFFICIENT SOLUTION : " + efficientSolution(arr,0,n-1));
        System.out.println("DP SOLUTION : " + dpSolution(arr2,n2));
    }
    public static int naiveSolution(int[] arr, int i, int j, int sum) {
        // WHEN ARRAY HAS ONLY 2 VALUE, THEN RETURN THE MAX OF TWO VALUES.
        if(j == (i+1)) return Math.max(arr[i],arr[j]);
        /*
        LET'S ASSUME I AS OPPONENT & J AS PLAYER
        I IS STARTING FROM BEGINNING,
            YOU'LL GET OPPONENTS VALUE BY REDUCING FROM SUM BY OPPONENT RETURN VALUE
        J IS STARTING FROM LAST,
            YOU'LL GET PLAYERS VALUE BY REDUCING FROM SUM BY PLAYER RETURN VALUE
        */
        return Math.max(
                sum - naiveSolution(arr,i+1,j,sum-arr[i]),
                sum - naiveSolution(arr,i,j-1,sum-arr[j])
                );
    }
    // WITHOUT SUM
    public static int efficientSolution(int[] arr, int i, int j) {
        if(j == i+1) return Math.max(arr[i],arr[j]);
        /*
        HERE, I CAN BE OPPONENT OR PLAYER && J CAN BE ALSO SAME AS I
        arr[i] || arr[j] is picked by player.
        */
        return Math.max(
                arr[i] + Math.min(
                        efficientSolution(arr,i+2,j),
                        efficientSolution(arr,i+1,j-1)
                ),
                arr[j] + Math.min(
                        efficientSolution(arr,i+1,j-1),
                        efficientSolution(arr,i,j-2)
                )
        );
    }
    public static int dpSolution(int[] arr, int n) {
        int[][] dp = new int[n][n];
        // FILL BASE CASE VALUES (i == j+1) --> j = i + 1
        for (int i = 0; i < n-1; i++) {
            dp[i][i+1] = Math.max(arr[i],arr[i+1]);
        }
        for (int gap = 3; gap < n; gap += 2) {
            for (int i = 0; i+gap < n; i++) {
                int j = i+gap;
                dp[i][j] =
                        Math.max(
                            arr[i] + Math.min(
                                    dp[i+2][j],
                                    dp[i+1][j-1]
                            ),
                            arr[j] + Math.min(
                                    dp[i+1][j-1],
                                    dp[i][j-2]
                            )
                        );
            }
        }
        System.out.println("DP ARRAY : ");
        A_MultiDimensionalArray.normalMultiDimensionalArray(dp);
        return dp[0][n-1];
    }
}
