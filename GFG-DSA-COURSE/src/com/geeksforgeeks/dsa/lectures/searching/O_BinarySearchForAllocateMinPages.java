/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class O_BinarySearchForAllocateMinPages {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int k = 2;
        System.out.println(naiveSolution(arr,arr.length,k));
    }
    public static int naiveSolution(int[] arr, int n, int k) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max,arr[i]);
        }
        int low = max;
        int high = sum;
        int res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(isFeasible(arr,n,k,mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    private static boolean isFeasible(int[] arr, int n, int k, int mid) {
        int required = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(sum + arr[i] > mid) {
                required++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return (required <= k);
    }
}
