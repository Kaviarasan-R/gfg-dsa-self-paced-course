/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class D_CycleSort {
    static int[] arr = {20,40,50,10,30};
    public static void main(String[] args) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int item = i;
            int pos = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[item]) {
                    pos++;
                }
            }
            swap(item,pos);
            while(pos != i) {
                pos = i;
                for (int j = i+1; j < n; j++) {
                    if(arr[j] < arr[item]) {
                        pos++;
                    }
                }
                swap(item,pos);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
