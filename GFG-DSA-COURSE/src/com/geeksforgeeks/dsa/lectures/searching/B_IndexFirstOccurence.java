/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class B_IndexFirstOccurence {
    public static void main(String[] args) {
        int[] arr = {1,10,10,10,20,20,40};
        int x = 20;
        int low = 0;
        int high = arr.length-1;
        System.out.println(naiveSolution(arr,low,high,x));
        System.out.println(efficientSolution(arr,x));
    }
    public static int naiveSolution(int[] arr, int low, int high, int x) {
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if(x > arr[mid]) return naiveSolution(arr,mid+1,high,x);
        else if (x < arr[mid]) return naiveSolution(arr,low, mid-1,x);
        else {
            if(mid == 0 || arr[mid-1] != arr[mid]) {
                return mid;
            } else {
                return naiveSolution(arr,low,mid-1,x);
            }
        }
    }
    public static int efficientSolution(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(x > arr[mid]) low = mid + 1;
            else if (x < arr[mid]) high = mid - 1;
            else {
                if(mid == 0 || arr[mid-1] != arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
