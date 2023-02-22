/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class K_MaximumDifference {
    public static void main(String[] args) {
        /**
         * arr[] = {2,3,10,6,4,8,1}
         * OP : 8
         * ----- ONE WINDOW -----
         * 3 - 2 = 1
         * 10 - 3 = 7
         * 6 - 10 = -4
         * 4 - 6 = -2
         * 8 - 4 = 4
         * 1 - 8 = -7
         * ----- TWO WINDOW -----
         * 10 - 2 = 8
         **/
        int[] arr = {2,3,10,6,4,8,1};
        naiveSolution(arr,arr.length);
        efficientSolution(arr,arr.length);
    }
    public static void naiveSolution(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if((arr[j] - arr[i]) > max) {
                    max = arr[j] - arr[i];
                }
            }
        }
        System.out.println(max);
    }
    public static void efficientSolution(int[] arr, int n) {
        // SUBTRACTING MAXIMUM VALUE & MINIMUM VALUE
        int max = arr[1] - arr[0];
        int minVal = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max,arr[i]-minVal);
            minVal = Math.min(minVal,arr[i]);
        }
        System.out.println(max);
    }
}
