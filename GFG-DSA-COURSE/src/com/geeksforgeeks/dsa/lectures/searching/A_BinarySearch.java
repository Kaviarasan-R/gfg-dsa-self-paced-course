/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class A_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int x = 30;
        System.out.println(binarySearchIterative(arr,arr.length,x));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,x));

    }
    public static int binarySearchIterative(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
    public static int binarySearchRecursive(int[] arr, int low, int high, int x) {
        if(low > high) return - 1;
        int mid = (low + high) / 2;
        if(arr[mid] == x) {
            return mid;
        }
        else if (arr[mid] > x) {
            return binarySearchRecursive(arr,low,mid-1,x);
        } else {
            return binarySearchRecursive(arr,mid+1,high,x);
        }
    }
}
