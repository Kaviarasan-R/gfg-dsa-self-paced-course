/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class N_TrappingRainWater {
    public static void main(String[] args) {
        /**
         * IP : 2,0,2
         * OP : 2
         * IP : 1,2,3 or 3,2,1 --> OP : will have zero
         **/
        int[] arr = {3,0,1,2,5};
        System.out.println(naiveSolution(arr,arr.length));
        System.out.println(efficientSolution(arr,arr.length));
    }
    public static int naiveSolution(int[] arr, int n) {
        int res = 0;
        for (int i = 1; i < n-1; i++) {
            int leftMax = arr[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax,arr[j]);
            }
            int rightMax = arr[i];
            for (int j = i+1; j < n; j++) {
                rightMax = Math.max(rightMax,arr[j]);
            }
            res += (Math.min(leftMax,rightMax) - arr[i]);
        }
        return res;
    }
    public static int efficientSolution(int[] arr, int n) {
        int res = 0;
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
        // leftMax[] = {3,0,0,0,0}
        // leftMax[] = {3,3,3,3,5}
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i],leftMax[i-1]);
        }
        int[] rightMax = new int[n];
        rightMax[n-1] = arr[n-1];
        // rightMax[] = {0,0,0,0,5}
        // rightMax[] = {5,5,5,5,5}
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i],rightMax[i+1]);
        }
        // (i=1) res = 0 + 3 - 0 = 3
        // (i=2) res = 3 + 3 - 1 = 5
        // (i=3) res = 5 + 3 - 2 = 6
        for (int i = 1; i < n-1; i++) {
            res += Math.min(leftMax[i],rightMax[i]) - arr[i];
        }
        return res;
    }
}
