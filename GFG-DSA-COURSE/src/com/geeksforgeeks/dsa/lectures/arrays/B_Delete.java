/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

import java.util.Arrays;

public class B_Delete {
    public static void main(String[] args) {
        int[] arr = {3,8,12,5,6};
        System.out.println(delete(arr,arr.length,12));
    }
    public static int delete(int[] arr, int n, int x) {
        int i;
        for (i = 0; i < n; i++) { // get the index of x
            if(arr[i] == x) break;
        }
        if(i == n) return n; // if index is last in index of array
        for (int j = i; j < n-1; j++) { // move all elements from right to left by one position.
            arr[j] = arr[j+1];
        }
        arr[arr.length-1] = 0; // make last element empty
        System.out.println(Arrays.toString(arr));
        return (n-1);
    }

}
