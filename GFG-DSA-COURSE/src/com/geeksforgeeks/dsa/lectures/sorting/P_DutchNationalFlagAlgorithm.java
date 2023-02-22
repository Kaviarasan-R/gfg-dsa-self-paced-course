/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class P_DutchNationalFlagAlgorithm {
    public static void main(String[] args) {
        /**
         * Sort An Array With Two Types
         * int[] arr1 = {15,-3,-2,18}; // segregate pos & neg
         * int[] arr2 = {15,14,13,12}; // segregate even & odd
         * int[] arr3 = {0,1,1,1,0}; // segregate binary
         **/
        int[] arr = {0,1,0,2,1,2};
        sortArrayWithThreeTypes(arr, arr.length);
    }
    public static void sortArrayWithThreeTypes(int[] arr, int n) {
        int l = 0;
        int h = n - 1;
        int m = 0;
        while(m <= h) {
            if(arr[m] == 0) {
                int temp = arr[l];
                arr[l] = arr[m];
                arr[m] = temp;
                l++;
                m++;
            } else if(arr[m] == 1) {
                m++;
            } else {
                int temp = arr[m];
                arr[m] = arr[h];
                arr[h] = temp;
                h--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
