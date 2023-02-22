/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class C_LargestElement {

    public C_LargestElement(int[] arr, int n) {
        getLargest(arr,n);
    }
    public static void main(String[] args) {
        /**
         * arr[] = {10,5,20,8}
         * OP : 20
         * Naive approach : sort the array in ascending order & fetch last element and vice versa.
         * */
        int[] arr = {10,5,20,8};
        System.out.println(getLargest(arr,arr.length));
    }
    public static int getLargest(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] > arr[res]) res = i;
        }
        return arr[res];
    }
}
