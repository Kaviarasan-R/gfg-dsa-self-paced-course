/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

import java.util.Arrays;

public class F_ReverseArray {
    public static void main(String[] args) {
        int[] arr = {10,5,7,30};
        System.out.println(Arrays.toString(reverse(arr)));
    }
    public static int[] reverse(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        while(low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }
}
