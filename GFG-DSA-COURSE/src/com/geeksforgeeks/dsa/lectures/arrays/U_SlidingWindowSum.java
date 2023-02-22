/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class U_SlidingWindowSum {
    public static void main(String[] args) {
        /**
         * window size : 3
         * 1,8,30,-5,20,7
         * (1,8,30) (8,30,-5) (30,-5,20) (-5,20,7)
         **/
        int[] arr = {1,8,30,-5,20,7};
        System.out.println(naiveSolution(arr,arr.length));
        System.out.println(efficientSolution(arr,arr.length));
    }
    public static int naiveSolution(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE;
        int k = 3;
        for (int i = 0; (i+k) - 1 < n; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i+j];
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
    public static int efficientSolution(int[] arr, int n) {
        int current_sum = 0;
        int k = 3;
        for (int i = 0; i < k; i++) {
            current_sum += arr[i];
        }
        int max_sum = current_sum;
        for (int i = k; i < n; i++) {
            current_sum += arr[i] - arr[i-k];
            max_sum = Math.max(current_sum,max_sum);
        }
        return max_sum;
    }
}
