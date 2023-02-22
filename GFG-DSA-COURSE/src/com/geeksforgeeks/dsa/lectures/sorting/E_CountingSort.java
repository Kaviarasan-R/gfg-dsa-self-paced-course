/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class E_CountingSort {
    public static void main(String[] args) {
        int[] arr = {1,4,4,1,0,1};
        int k = 5; // elements form 1 to 5
        naiveSolution(arr,arr.length,k);
        efficientSolution(arr, arr.length,k);
    }
    public static void naiveSolution(int[] arr, int n, int k) {
        int[] count = new int[k];
        // Initially makes every element to 0 in count array.
        for (int i = 0; i < k; i++) {
            count[i] = 0;
        }
        // Increment the count array when ever repeated numbers in the array.
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        // Replaces the original array with number of repeated elements.
        // count[] = {1,3,0,0,2}
        // 0 appears 1 time
        // 1 appears 3 times
        // 2 & 3 appears 0 time
        // 4 appears 2 times
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index] = i;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void efficientSolution(int[] arr, int n, int k) {
        int[] count = new int[k];
        // Initially makes every element to 0 in count array.
        for (int i = 0; i < k; i++) {
            count[i] = 0;
        }
        // Increment the count array when ever repeated numbers in the array.
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        // Cumulative sum array
        for (int i = 1; i < k; i++) {
            count[i] = count[i-1] + count[i];
        }
        int[] output = new int[n];
        // arr[] = {1,4,4,1,0,1}
        // count[] = {1,4,4,4,6}
        // i = 5
        // arr[i] --> arr[5] = 1
        // count[previous] --> count[1] = 4
        // output[previous-1] --> output[3] = 1
        for (int i = n-1; i >= 0; i--) {
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--; // Decrement count value once added
        }
        System.arraycopy(output,0,arr,0,n);
        System.out.println(Arrays.toString(arr));
    }
}
