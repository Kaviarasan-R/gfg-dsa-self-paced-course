/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class E_CountOnesInSortedBinaryArray {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,1,1,1};
        System.out.println(naiveSolution(arr,arr.length));
    }
    public static int naiveSolution(int[] arr, int n) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == 0) low = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return (n - mid);
                } else {
                    high = mid - 1;
                }
            }
        }
        return 0;
    }
}
