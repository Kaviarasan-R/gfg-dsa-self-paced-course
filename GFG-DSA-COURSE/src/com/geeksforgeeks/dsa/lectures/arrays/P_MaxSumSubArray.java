/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class P_MaxSumSubArray {
    public static void main(String[] args) {
        /**
         * IP : {2,3,-8,7,-1,2,3}
         * OP : 11
         **/
        int[] arr = {2,3,-8,7,-1,2,3};
        int[] arr1  = {1,2,3,4,5};
        System.out.println(naiveSolution(arr,arr.length));
        System.out.println(efficientSolution(arr1,arr1.length));
    }
    public static int naiveSolution(int[] arr, int n) {
        int res = arr[0];
        for (int i = 0; i < n; i++) {
            int current = 0;
            for (int j = i; j < n; j++) {
                current = current + arr[j];
                res = Math.max(current,res);
            }
        }
        return res;
    }
    public static int efficientSolution(int[] arr, int n) {
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res,maxEnding);
        }
        return res;
    }
}
