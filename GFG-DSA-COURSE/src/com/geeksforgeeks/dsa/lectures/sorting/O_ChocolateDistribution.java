/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class O_ChocolateDistribution {
    public static void main(String[] args) {
        int[] arr = {7,3,2,4,9,12,56};
        int m = 3;
        // Pairs = (7,3,2) (7,3,4) (9,12,56) (3,2,4) ...
        // Get each pairs minimum & maximum to calculate min value from all pairs.
        // Max - Min = 4 - 2 = 2 (return minimum)
        //           = 59 - 9 = 47 ...
        System.out.println(naiveSolution(arr,arr.length,m));
    }
    public static int naiveSolution(int[] arr, int n, int m) {
        if(m > n) return -1;
        Arrays.sort(arr);
        int res = arr[m-1] - arr[0];
        for (int i = 1; i+m-1 < n; i++) {
            res = Math.min(res,Math.abs(arr[i+m-1]-arr[i]));
        }
        return res;
    }
}
