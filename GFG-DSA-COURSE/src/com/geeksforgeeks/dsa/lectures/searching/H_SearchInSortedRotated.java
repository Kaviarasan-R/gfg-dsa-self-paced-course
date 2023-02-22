/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class H_SearchInSortedRotated {
    public static void main(String[] args) {
        int[] arr = {100,200,300,400,20,30,40,50};
        int x = 30;
        System.out.println(naiveSolution(arr,arr.length,x));
    }
    public static int naiveSolution(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == x) return mid;
            else if (arr[low] < arr[mid]) { // LEFT HALF
                if( x >= arr[low] && x < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // RIGHT HALF
                if( x > arr[mid] && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
