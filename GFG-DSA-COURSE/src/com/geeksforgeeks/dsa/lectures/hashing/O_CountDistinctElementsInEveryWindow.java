/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashMap;

public class O_CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[] arr = {10,20,20,10,30,40,10};
        int k = 4;
        // there are four windows in the array
        // count distinct elements in each window
        // first window = {10,20,20,10} --> 2
        // second window = {20,20,10,30} --> 3
        // third window = {20,10,30,40} --> 4
        // fourth window = {10,30,40,10} --> 3
        // output : 2 3 4 3
        naiveSolution(arr,arr.length,k);
        System.out.println();
        efficientSolution(arr,arr.length,k);
    }
    public static void naiveSolution(int[] arr, int n, int k) {
        for (int i = 0; i <= n-k; i++) {
            int count = 0;
            // loop for current window (n * n) for checking distinct
            for (int j = 0; j < k; j++) {
                boolean flag = false;
                for (int p = 0; p < j; p++) {
                    if(arr[i+j] == arr[i+p]) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) count++;
            }
            System.out.print(count + " ");
        }
    }
    public static void efficientSolution(int[] arr, int n, int k) {
        // create frequency map for first k window
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        int freq = 0;
        // calculate frequencies for first k window
        for (int i = 0; i < k; i++) {
            if(hashtable.containsKey(arr[i])) {
                freq = hashtable.get(arr[i]) + 1;
                hashtable.put(arr[i],freq);
            } else {
                freq = 0;
                hashtable.put(arr[i],freq);
            }
        }
        System.out.print(hashtable.size() + " ");
        // calculate frequencies for next windows
        for (int i = k; i < n; i++) {
            // case 1 : decrease the frequency of previous window's first element.
            freq = hashtable.get(arr[i-k]);
            // case 2 : remove element after if freq becomes 0 or decrease the element if not 0.
            if(freq == 0) {
                hashtable.remove(arr[i-k]);
            } else {
                hashtable.put(arr[i-k],freq-1);
            }
            // case 3 : increase freq if hashtable contains element or add it to hashtable with 0 frequency.
            if(hashtable.containsKey(arr[i])) {
                freq = hashtable.get(arr[i]) + 1;
                hashtable.put(arr[i],freq);
            } else {
                hashtable.put(arr[i],0);
            }
            // case 4 : print size of the hashtable
            System.out.print(hashtable.size() + " ");
        }
    }
}
