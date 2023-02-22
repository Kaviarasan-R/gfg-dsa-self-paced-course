/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class N_MinimumDifference {
    public static void main(String[] args) {
        int[] arr = {1,8,12,5,18};
        System.out.println(naiveSolution(arr,arr.length));
        System.out.println(efficientSolution(arr,arr.length));
    }
    public static int naiveSolution(int[] arr, int n) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                res = Math.min(res,Math.abs(arr[i]-arr[j]));
            }
        }
        return res;
    }
    public static int efficientSolution(int[] arr, int n) {
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res,Math.abs(arr[i]-arr[i-1]));
        }
        return res;
    }
}
