/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashMap;

public class M_LongestCommonSpanWithSameSum {
    public static void main(String[] args) {
        int[] arr1 = {0,1,0,0,0,0};
        int[] arr2 = {1,0,1,0,0,1};
        // arr1 = {0,1} & arr2 = {1,0} having same sum and res = 2
        // arr1 = {1,0,0,0} & arr2 = {0,1,0,0} having same sum and res = 4.
        // return longest sub array with having same sum.
        System.out.println(naiveSolution(arr1,arr2,arr1.length,arr2.length));
        System.out.println(efficientSolution(arr1,arr2,arr1.length,arr2.length));
    }
    public static int naiveSolution(int[] arr1, int[] arr2, int n, int m) {
        int res = 0;
        for (int i = 0; i < n;i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = i; j < n; j++) {
                sum1 += arr1[j];
                sum2 += arr2[j];
                if(sum1 == sum2) {
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }
    public static int efficientSolution(int[] arr1, int[] arr2, int n, int m) {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr1[i] - arr2[i];
        }
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        int pref_sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            pref_sum += temp[i];
            if(hashtable.containsKey(pref_sum) || pref_sum == 0) {
                res = Math.max(res,i);
            } else {
                hashtable.put(pref_sum,i);
            }
        }
        return res;
    }
}
