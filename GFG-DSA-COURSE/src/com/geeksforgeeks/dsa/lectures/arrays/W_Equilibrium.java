/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class W_Equilibrium {
    public static void main(String[] args) {
        /**
         * arr[] = {3,4,8,-9,20,6}
         * OP : YES
         * arr[] = {4,2,2}
         * OP : NO
         * Highest number in the array should have both left & right side must be lower than that.
         **/
        int[] arr = {3, 4, 8, -9, 20, 6};
        System.out.println(naiveSolution(arr, arr.length));
        System.out.println(efficientSolution(arr,arr.length));
    }
    public static boolean naiveSolution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int lSum = 0;
            int rSum = 0;
            for (int j = 0; j < i; j++) {
                lSum += arr[j];
            }
            for (int j = i+1; j < n; j++) {
                rSum += arr[j];
            }
            if(lSum == rSum) return true;
        }
        return false;
    }
    public static boolean efficientSolution(int[] arr, int n) {
        // TOTAL SUM
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // LEFT SUM
        int lSum = 0;
        for (int i = 0; i < n; i++) {
            if(lSum == sum - arr[i]) {
                return true;
            }
            lSum += arr[i];
            sum -= arr[i];
        }
        return false;
    }
}
