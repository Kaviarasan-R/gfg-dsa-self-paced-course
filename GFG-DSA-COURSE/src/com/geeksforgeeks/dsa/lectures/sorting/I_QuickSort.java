/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class I_QuickSort {
    static int[] arr = {5,15,6,9,12,11,8};
    public static void main(String[] args) {
        quickSort(0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int low, int high) {
        if(low < high) {
            int pivot = hoarePartition(low,high);
            quickSort(low,pivot-1);
            quickSort(pivot+1,high);
        }
    }
    private static void naivePartition(int low, int high, int pivot) {
        int[] temp = new int[high - low + 1];
        int index = 0;
        for (int i = low; i < high; i++) {
            if(arr[i] <= arr[pivot]) {
                temp[index] = arr[i];
            } else {
                temp[index] = arr[i];
            }
            index++;
        }
        System.arraycopy(temp,0,arr,0,arr.length);
    }
    public static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high-1; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(i,j);
            }
        }
        swap(i+1,high);
        return (i+1);
    }
    private static int hoarePartition(int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while(true) {
            do {
                i++;
            } while(arr[i] < pivot);
            do {
                j--;
            } while(arr[j] > pivot);
            if (i >= j) return j;
            swap(i,j);
        }
    }
    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
