/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import com.geeksforgeeks.dsa.lectures.searching.A_BinarySearch;

import java.util.Arrays;

public class B_SelectionSort {
    static int[] arr = {10,5,8,20,2,18};
    public static void main(String[] args) {
        naiveSolution(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void naiveSolution(int[] arr, int n) {
        int min_val = 0;
        for (int i = 0; i < n-1; i++) {
            min_val = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[min_val]) {
                    min_val = j;
                }
            }
            swap(i,min_val);
        }
    }
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
