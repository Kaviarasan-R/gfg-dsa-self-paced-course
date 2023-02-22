/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashMap;
import java.util.HashSet;

public class L_LongestSubArrayWithEqual0s1s {
    public static void main(String[] args) {
        int[] arr1 = {1,0,1,1,1,0,0};
        // from index 1 to 6 --> equal zero's and one's having 3 each.
        int[] arr2 = {1,1,1,1};
        // output --> zero, because there is no zero.
        System.out.println(naiveSolution(arr1, arr1.length));
        System.out.println(efficientSolution(arr1,arr1.length));
    }
    public static int naiveSolution(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int c0 = 0;
            int c1 = 0;
            for (int j = i; j < n; j++) {
                if(arr[j] == 0) c0++;
                else c1++;
                if(c0 == c1) res = Math.max(res,j-i+1);
            }
        }
        return res;
    }
    public static int efficientSolution(int[] arr, int n) {
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        int prev_sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            prev_sum += arr[i] == 0 ? -1 : arr[i];
            if(hashtable.containsKey(prev_sum)) {
                res = Math.max(res,i);
            } else {
                hashtable.put(prev_sum,i);
            }
        }
        return res;
    }
}
