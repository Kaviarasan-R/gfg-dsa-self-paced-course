/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class V_SlidingWindowCheckingSum {
    public static void main(String[] args) {
        int[] arr = {1,4,20,3,10,5};
        int sum = 33;
        System.out.println(naiveSolution(arr,arr.length,sum));
    }
    public static boolean naiveSolution(int[] arr, int n, int sum) {
        int current_sum = arr[0];
        int start = 0;
        for (int end = 1; end < n; end++) {
            while(current_sum > sum && start < end-1) {
                current_sum -= arr[start];
                start++;
            }
            if(current_sum == sum) return true;
            if(end < n) {
                current_sum += arr[end];
            }
        }
        return (current_sum == sum);
    }
}
