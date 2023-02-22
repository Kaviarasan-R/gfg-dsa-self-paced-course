/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

import java.util.Arrays;

public class G_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {10,20,20,30,30,30};
        //System.out.println(removeDuplicatesNaive(arr));
        System.out.println(removeDuplicatesEfficient(arr));
    }
    // NAIVE SOLUTION
    public static int removeDuplicatesNaive(int[] arr) {
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            if(temp[res-1] != arr[i]) {
                temp[res] = arr[i];
                res++;
            }
        }
        int i;
        for (i = 0; i < res; i++) {
            arr[i] = temp[i];
        }
        while(i < arr.length) {
            arr[i] = 0;
            i++;
        }
        System.out.println(Arrays.toString(arr));
        return res;
    }
    // EFFICIENT SOLUTION
    public static int removeDuplicatesEfficient(int[] arr) {
        /**
         * res = 1
         * i = 1 : 20 != 10 : [10,20,20,30,30,30] --> res = 2 --> replace (1,1)
         * i = 2 : 20 != 20 : [10,20,20,30,30,30] --> IGNORE
         * i = 3 : 20 != 30 : [10,20,30,30,30,30] --> res = 3 --> replace (2,3)
         * */
        int res = 1;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[res-1]) {
                arr[res] = arr[i];
                j = i;
                res++;
            }
        }
        while(j < arr.length) {
            arr[j] = 0;
            j++;
        }
        System.out.println(Arrays.toString(arr));
        return res;
    }
}
