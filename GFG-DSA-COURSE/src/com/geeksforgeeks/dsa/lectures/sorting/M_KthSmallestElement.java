/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class M_KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {10,5,30,12};
        int k = 3;
        System.out.println(naiveSolution(arr,k));
        System.out.println(efficientSolution(arr,0,arr.length-1,k));
    }
    public static int naiveSolution(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k-1];
    }
    public static int efficientSolution(int[] arr, int l, int h, int k) {
        if(l < h) {
            int pivot = I_QuickSort.lomutoPartition(arr,l,h);
            if(pivot == (k-1)) return arr[pivot];
            efficientSolution(arr,l,pivot-1,k);
            return efficientSolution(arr,pivot+1,h,k);
        } else {
            return arr[k-1];
        }
    }
}
