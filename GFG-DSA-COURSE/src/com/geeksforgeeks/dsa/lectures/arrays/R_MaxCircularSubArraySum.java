/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class R_MaxCircularSubArraySum {
    public static void main(String[] args) {
        /**
         * IP : {10,-5,5}
         * normal sub array : (10) (5) (-5) (10,5) (5,-5) (10,5,-5)
         * circular sub array : (5,-5,10) (-5,10) (-5,10,5)
         **/
        int[] arr = {5,-2,3,4};
        int[] arr1 = {1,2,3,4,5};
        //System.out.println(naiveSolution(arr,arr.length));
        System.out.println(efficientSolution(arr1,arr1.length));
    }
    /** FALSE OUTPUT FOR SOME CASES
     public static int naiveSolution(int[] arr, int n) {
        int res = arr[0];
        for (int i = 0; i < n; i++) {
            int current_max = arr[i];
            int current_sum = arr[i];
            for (int j = 1; j < n; j++) {
                int index = (i+j) % n;
                current_max += arr[index];
                current_sum = Math.max(current_max,current_sum);
            }
            res = Math.max(res,current_max);
        }
        return res;
    }*/
    public static int efficientSolution(int[] arr, int n) {
        int max_normal = standardKadaneAlgorithm(arr,n);
        if(max_normal < 0) return max_normal;
        // INVERTING THE ARRAY + SUM OF THE ARRAY
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            arr[i] = -arr[i];
        }
        // PASS THE INVERTED ARRAY TO KADANE ALGORITHM
        int circular_sum = sum + standardKadaneAlgorithm(arr,n);
        return Math.max(circular_sum,max_normal);
    }
    /** SUM OF NORMAL SUB ARRAY */
    private static int standardKadaneAlgorithm(int[] arr, int n) {
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(arr[i],maxEnding+arr[i]);
            res = Math.max(res,maxEnding);
        }
        return res;
    }
}
