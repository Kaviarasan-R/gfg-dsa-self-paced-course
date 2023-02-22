/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import java.util.Arrays;

public class F_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr1 = {10,5,18,7,2,9};
        int[] arr2 = {8,100,150,10,12,14,110};
        System.out.println("NAIVE : " + naiveSolution(arr2,arr2.length));
        System.out.println("EFFICIENT : " + efficientSolution(arr2,arr2.length));
    }
    public static int naiveSolution(int[] arr, int n) {
        int[] lis = new int[n];
        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int res = lis[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(res,lis[i]);
        }
        return res;
    }
    public static int efficientSolution(int[] arr, int n) {
        int[] lis = new int[n];
        lis[0] = arr[0];
        int index = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] > lis[index-1]) {
                lis[index] = arr[i];
                index++;
            }
            else {
                int idx = ceilIdx(lis,0,index-1,arr[i]);
                lis[idx] = arr[i];
            }
        }
        System.out.println("LIS : " + Arrays.toString(lis));
        return index;
    }
    public static int ceilIdx(int[] arr, int l, int h, int x) {
        while(h > l) {
            int m = (l + h) / 2;
            if(arr[m] >= x) h = m;
            else l = m+1;
        }
        return h;
    }
}
