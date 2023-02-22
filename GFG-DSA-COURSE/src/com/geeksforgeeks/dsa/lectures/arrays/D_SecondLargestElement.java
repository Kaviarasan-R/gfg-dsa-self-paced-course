/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class D_SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {10,12,8,20};
        System.out.println(getSecondLargestNaive(arr));
        System.out.println(getSecondLargestEfficient(arr,arr.length));
    }
    // NAIVE SOLUTION
    public static int getSecondLargestNaive(int[] arr) {
        int res = -1;
        int largest = getLargest(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != largest) {
                if(res == -1) res = i;
                else if(arr[i] > arr[res]) res = i;
                // ignore if less than or equal to.
            }
        }
        return arr[res];
    }
    public static int getLargest(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] > arr[res]) res = i;
        }
        return arr[res];
    }
    // EFFICIENT SOLUTION
    public static int getSecondLargestEfficient(int[] arr, int n) {
        /**
         * [] -> {5,20,12,20,8}
         * largest = 0
         * res = -1
         * i = 1 : res = 0 (5), largest = 1 (20) : IF
         * i = 2 : res = 2 (12) : ELSE IF
         * i = 3 : IGNORE
         * i = 4 : IGNORE
         * return 2
         * */
        int res = -1;
        int largest = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[largest]) {
                res = largest;
                largest = i;
            }
            else if(arr[i] != arr[largest]) {
                if(res == -1 || arr[i] > arr[res]) {
                    res = i;
                }
            }
        }
        return res;
    }
}
