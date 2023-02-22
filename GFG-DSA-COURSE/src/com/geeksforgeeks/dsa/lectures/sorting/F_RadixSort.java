/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class F_RadixSort {
    public static void main(String[] args) {
        // Radix sort is sorted in digit wise from least to most.
        int[] arr = {319,212,6,8,100,50};
        radixSort(arr,arr.length);
    }
    public static void radixSort(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        // Exp stands for digit (ones, tens, hundreds)
        for (int exp = 1; max/exp > 0; exp*=10) {
            countingSort(arr,n,exp);
            //fn(arr,6,1)
            //fn(arr,6,10)
            //fn(arr,6,100)
        }
    }
    public static void countingSort(int[] arr, int n, int exp) {
        int[] count = new int[10]; // 0 - 9
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
        // If exp = 1, 319 / 1 = 319 % 10 = 9 (ones)
        // If exp = 10, 319 / 10 = 31 % 10 = 1 (tens)
        // If exp = 100, 319 / 100 = 3 % 10 = 3 (hundreds)
        // count[] = {2,0,1,0,0,0,1,0,1,1}
        for (int i = 0; i < n; i++) {
            count[(arr[i]/exp)%10]++;
        }
        // Cumulative counts[] = {2,2,3,3,3,3,4,4,5,6}
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i-1];
        }
        // If i = 5 --> ( arr[i] / exp ) % 10 = (50 / 1 ) % 10 = 0
        // count[previous] = count[0] = 2
        // output[previous-1] = output[2-1] = 50
        for (int i = n-1; i >= 0; i--) {
            output[ count[ ( arr[i] / exp ) % 10] - 1 ] = arr[i];
            count[ ( arr[i] / exp ) % 10 ]--;
        }
        System.arraycopy(output,0,arr,0,n);
        System.out.println(Arrays.toString(arr));
    }
}
