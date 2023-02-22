/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_MoreThanOccurrences {
    public static void main(String[] args) {
        int[] arr1 = {30,10,20,20,10,20,30,30};
        int k1 = 4;
        int n1 = arr1.length;
        // n = 8 & n / k = 2
        // calculate frequencies which are appears more than (n/k).
        // 20 & 30 appears more than 2 times.
        int[] arr2 = {30,10,20,20,20,10,40,30,30};
        int k2 = 4;
        int n2 = arr2.length;
        naiveSolution(arr1,n1,k1);
        System.out.println();
        efficientSolution(arr1,n1,k1);
        System.out.println();
        efficientSolution2(arr2,n2,k2);
    }
    // O(n * logn) + Theta(n)
    public static void naiveSolution(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int i = 1;
        int count = 1;
        while(i < n) {
            while(i < n && (arr[i] == arr[i-1])) {
                count++;
                i++;
            }
            if(count > (n/k)) {
                System.out.print(arr[i-1] + " ");
            }
            count = 1;
            i++;
        }
    }
    // Theta(n) --> performs poor when n is very large and k is very less.
    public static void efficientSolution(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        for(int x : arr) {
            hashtable.put(x,hashtable.getOrDefault(x,0)+1);
        }
        for(Map.Entry<Integer,Integer> e : hashtable.entrySet()) {
            if(e.getValue() > (n/k)) {
                System.out.print(e.getKey() + " ");
            }
        }
    }
    // Theta(nK) --> Performs better when n is very large and k is very less.
    public static void efficientSolution2(int[] arr, int n, int k) {
        HashMap<Integer,Integer> hashtable = new HashMap<>();
        int freq = 0;
        for (int i = 0; i < n; i++) {
            // case 1 : increase the frequency if already present
            if(hashtable.containsKey(arr[i])) {
                freq = hashtable.get(arr[i]) + 1;
                hashtable.put(arr[i],freq);
            }
            // case 2 : if size < (k-1), add value to hashtable with freq 1.
            // why (k-1) ? number of elements in the output is not more than (k-1).
            else  if (hashtable.size() <= (k-1)) {
                hashtable.put(arr[i],1);
            } else {
                // case 3 : decrease all values by 1. if any value becomes 0, then remove the value.
                for (int j = 0; j < k; j++) {
                    freq = hashtable.get(arr[j]);
                    if(freq == 0) {
                        hashtable.remove(arr[j]);
                    } else {
                        hashtable.put(arr[j],freq-1);
                    }
                }
            }
            //System.out.println(i +" : "+ hashtable);
        }
        //System.out.println(hashtable);
        for (Map.Entry<Integer,Integer> e : hashtable.entrySet()) {
            if(e.getValue() > (n/k)) {
                System.out.print(e.getKey() + " ");
            }
        }
    }
}
