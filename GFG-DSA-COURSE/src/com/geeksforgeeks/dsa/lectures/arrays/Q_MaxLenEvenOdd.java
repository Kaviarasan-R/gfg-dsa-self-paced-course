/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class Q_MaxLenEvenOdd {
    public static void main(String[] args) {
        /**
         * IP : {10,12,14,7,8}
         * 10 - even
         * 12 - even
         * 14 - even
         * 7 - odd
         * 8 - even
         * Maximum even-odd sequence is 3 (14,7,8) it must be alternative
         * OP : 3
         **/
        int[] arr = {10,12,14,7,8};
        System.out.println(naiveSolution(arr,arr.length));
        System.out.println(efficientSolution(arr,arr.length));
    }
    public static int naiveSolution(int[] arr, int n) {
        int res = 1;
        for(int i=0; i < n; i++) {
            int current = 1;
            for (int j = i+1; j < n; j++) {
                if((arr[j]%2 == 0 && arr[j-1]%2 == 1) || (arr[j]%2 == 1 && arr[j-1]%2 == 0)) {
                    current++;
                } else {
                    break;
                }
            }
            res = Math.max(res,current);
        }
        return res;
    }
    public static int efficientSolution(int[] arr, int n) {
        int res = 1;
        int current = 1;
        for (int i = 1; i < n; i++) {
            if((arr[i]%2 == 0 && arr[i-1]%2 == 1) || (arr[i]%2 == 1 && arr[i-1]%2 == 0)) {
                current++;
                res = Math.max(res,current);
            }
        }
        return res;
    }
}
