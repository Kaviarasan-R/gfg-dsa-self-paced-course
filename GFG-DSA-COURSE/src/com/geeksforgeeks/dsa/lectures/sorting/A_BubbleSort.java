/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class A_BubbleSort {
    static int[] arr = {2,10,8,7};
    public static void main(String[] args) {
        //naiveSolution(arr,arr.length);
        efficientSolution(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void naiveSolution(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(j,j+1);
                }
            }
        }
    }
    public static void efficientSolution(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(j,j+1);
                    swapped = true;
                }
            }
            if(swapped == false) break;
        }
    }
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
