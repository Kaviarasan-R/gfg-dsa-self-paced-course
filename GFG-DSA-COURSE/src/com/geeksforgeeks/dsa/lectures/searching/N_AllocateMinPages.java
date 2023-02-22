/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class N_AllocateMinPages {
    public static void main(String[] args) {
        /**
         * k = 2
         * OP : 60
         * ____________________________________
         *      k1      |       k2            |
         *      0       |  10 + 20 + 30 + 40  |
         *     10       |  20 + 30 + 40       |
         *   10 + 20    |  30 + 40            |
         * 10 + 20 + 30 |  40                 |
         * ------------------------------------
         **/
        int[] arr = {10,20,30,40};
        int k = 2;
        System.out.println(naiveSolution(arr,arr.length,k));
    }
    public static int naiveSolution(int[] arr, int n, int k) {
        if(k == 1) {
            return sum(arr,0,n-1);
        }
        if(n == 1) {
            return arr[0];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res,Math.max(naiveSolution(arr,i,k-1),sum(arr,i,n-1)));
        }
        return res;
    }
    private static int sum(int[] arr, int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
