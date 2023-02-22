/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

import java.util.Arrays;

public class H_MoveAllZerosToEnd {
    public static void main(String[] args) {
        /**
         * [] -> {8,5,0,10,0,20}
         * OP : {8,5,10,20,0,0}
         * */
        int[] arr = {8,5,0,10,0,20};
        moveZerosNaive(arr,arr.length);
        moveZerosEfficient(arr,arr.length);
    }
    // NAIVE SOLUTION
    public static void moveZerosNaive(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0) { // only swap if elements are zero
                for (int j = i+1; j < n; j++) {
                    if(arr[j] != 0) { // only swap if next element is not zero
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    // EFFICIENT SOLUTION
    public static void moveZerosEfficient(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
