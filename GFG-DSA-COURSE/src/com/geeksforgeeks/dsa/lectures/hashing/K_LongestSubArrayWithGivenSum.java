/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class K_LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {8,3,1,5,-6,6,2,2};
        int sum = 4;
        // {8,-4,-4} = 0
        // {-2,2} = 0
        // longest length of the sub array is 3
        System.out.println(naiveSolution(arr,arr.length,sum));
        System.out.println(efficientSolution1(arr,arr.length,sum));
        System.out.println(efficientSolution2(arr,arr.length,sum));
    }
    public static int naiveSolution(int[] arr, int n, int sum) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int current_sum = 0;
            for (int j = i; j < n; j++) {
                current_sum += arr[j];
                if(current_sum == sum) {
                    res = Math.max(res, (j-i+1));
                }
            }
        }
        return res;
    }
    public static int efficientSolution1(int[] arr, int n, int sum) {
        int[] pref_arr = new int[n];
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        int pref_sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            pref_sum += arr[i];
            pref_arr[i] = pref_sum;
        }
        for (int i = 0; i < n; i++) {
            if(!hashtable.containsKey(pref_arr[i])) {
                hashtable.put(pref_arr[i],i);
            }
            if(hashtable.containsKey(pref_arr[i]-sum)) {
                // int idx = i - hashtable.get(pref_arr[i]-sum);
                int idx = hashtable.get(pref_arr[i]) - hashtable.get(pref_arr[i]-sum);
                res = Math.max(res,idx);
            }
        }
        return res;
    }
    public static int efficientSolution2(int[] arr, int n, int sum) {
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        int prev_sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            prev_sum += arr[i];
            if(prev_sum == sum) {
                res = i + 1;
            }
            if(!hashtable.containsKey(prev_sum)) {
                hashtable.put(prev_sum,i);
            }
            if(hashtable.containsKey(prev_sum - sum)) {
                res = Math.max(res,i-hashtable.get(prev_sum-sum));
            }
        }
        return res;
    }
}
