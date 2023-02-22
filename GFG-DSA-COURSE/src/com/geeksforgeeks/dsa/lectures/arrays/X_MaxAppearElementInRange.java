/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class X_MaxAppearElementInRange {
    public static void main(String[] args) {
        /**
         * left[] = {1,2,5,15}
         * right[] = {5,8,7,18}
         * OP : 5
         * EXPLANATION :
         * 1 - 5 --> 1,2,3,4,5
         * 2 - 8 --> 2,3,4,5,6,7,8
         * 5 - 7 --> 5,6,7
         * 15 - 18 --> 15,16,17,18
         * Number 5 appears the most.
         **/
        int[] left = {1,2,5,15};
        int[] right = {5,8,7,18};
        System.out.println(naiveSolution(left,right,left.length));
    }
    public static int naiveSolution(int[] left, int[] right, int n) {
        int[] arr = new int[1000];
        // [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        // [0,1,1,0,0,1,-1,0,-1,-1,0,0,0,0,0,1,0,0,0,-1]
        for (int i = 0; i < n; i++) {
            arr[left[i]]++;
            arr[right[i]+1]--;
        }
        // Initialization
        int max = arr[0];
        int res = 0;

        for (int i = 1; i < 1000 ; i++) {
            // Calculate the prefix sum
            // [0,1,2,0,0,3,2,0,1,0,0,0,0,0,0,1,0,0,0,0]
            arr[i] += arr[i-1];
            // set the max value
            /**
             * m = 0 < 1 (m = 1 & r = 1)
             * m = 1 < 2 (m = 2 & r = 2)
             * m = 2 < 0
             * m = 2 < 0
             * m = 2 < 3 (m = 3 & r = 5)
             * m = 3 < 2
             **/
            if(max < arr[i]) {
                max = arr[i];
                res = i;
            }
        }
        return res;
    }
}
