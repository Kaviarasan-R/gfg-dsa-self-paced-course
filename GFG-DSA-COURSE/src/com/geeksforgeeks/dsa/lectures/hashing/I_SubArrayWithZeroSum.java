/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashSet;

public class I_SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {1,4,13,-3,-10,5};
        // any sub array with sum zero.
        // contiguous sub array --> it can have any number of sub array length (2,3,4,...)
        // {13,-3,-10}
        System.out.println(naiveSolution(arr,arr.length));
        System.out.println(efficientSolution(arr,arr.length));
    }
    public static boolean naiveSolution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int current_sum = 0;
            for (int j = i; j < n; j++) {
                current_sum += arr[j];
                if(current_sum == 0) return true;
            }
        }
        return false;
    }
    public static boolean efficientSolution(int[] arr, int n) {
        HashSet<Integer> hashtable = new HashSet<>();
        int prev_sum = 0;
        for (int i = 0; i < n; i++) {
            prev_sum += arr[i];
            if(hashtable.contains(prev_sum) || (prev_sum == 0)) {
                System.out.println(prev_sum +" "+i);
                return true;
            }
            hashtable.add(prev_sum);
        }
        return false;
    }
}
