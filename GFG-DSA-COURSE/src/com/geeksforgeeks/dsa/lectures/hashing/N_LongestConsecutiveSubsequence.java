/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class N_LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr1 = {1,9,3,4,2,20};
        // 1,3,4,2 --> forms consecutive subsequence
        int[] arr2 = {8,20,7,30};
        // 8,7 --> forms consecutive subsequence
        int[] arr3 = {20,30,40};
        // 20 or 30 or 40 --> forms consecutive subsequence
        System.out.println(naiveSolution(arr1,arr1.length));
        System.out.println(efficientSolution(arr2,arr2.length));
    }
    public static int naiveSolution(int[] arr, int n) {
        Arrays.sort(arr); // mandatory
        int res = 1;
        int current = 1;
        for (int i = 1; i < n; i++) {
            // checks previous will become same as current if we add 1.
            if(arr[i] == arr[i-1]+1) {
                current++;
            } else if(arr[i] != arr[i-1]) {
                res = Math.max(res,current);
                current = 1;
            }
        }
        return Math.max(res,current);
    }
    public static int efficientSolution(int[] arr, int n) {
        /**
         * We first insert all elements in a hash table
         * then with 2n lookups, we find the result
         * do not insert duplicates in hashtable
         * */
        HashSet<Integer> hashtable = new HashSet<>();
        for(int x : arr) {
            hashtable.add(x);
        }
        int res = 1;
        for(Integer x : hashtable) {
            // only go through if it does not contain previous consecutive
            if(!hashtable.contains(x-1)) {
                int current = 1;
                // only go through if it contains next consecutive
                while(hashtable.contains(x+current)) {
                    current++;
                }
                res = Math.max(res,current);
            }
        }
        return res;
    }
}
