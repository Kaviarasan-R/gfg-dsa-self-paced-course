/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class S_MajorityElement {
    public static void main(String[] args) {
        /**
         * arr[] = {8,3,4,8,8}
         * OP : 0 or 3 or 4
         * Exp : {8 has 3 times} so we're returning indexes of 8.
         **/
        int[] arr = {8,3,4,8,8};
        System.out.println(mySolution(arr, arr.length));
        System.out.println(naiveSolution(arr,arr.length));
        System.out.println(mooreyVotingAlgorithm(arr,arr.length));
    }
    public static int mySolution(int[] arr, int n) {
        double t = n / 2;
        double count = 1.00;
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }
            }
            if(count > t) {
                res = i;
            }
        }
        return res;
    }
    public static int naiveSolution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }
            }
            if(count > n/2) return i;
        }
        return -1;
    }
    public static int mooreyVotingAlgorithm(int[] arr, int n) {
        int res = 0;
        int count = 1;
        // PHASE I --> Find a candidate
        for (int i = 1; i < n; i++) {
            if(arr[res] == arr[i]) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                res = i;
                count = 1;
            }
        }
        // PHASE II --> Check if the candidate is actually a majority
        count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[res] == arr[i]) {
                count++;
            }
        }
        if(count <= n/2) res = -1;
        return res;
    }
}
