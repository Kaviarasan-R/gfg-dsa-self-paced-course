/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashMap;
import java.util.Map;

public class E_FrequencyArrays {
    public static void main(String[] args) {
        int[] arr = {10,12,10,15,10,20,12,12};
        naiveSolution(arr,arr.length);
        efficientSolution(arr,arr.length);
        efficientSolution2(arr,arr.length);
    }
    public static void naiveSolution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if(arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if(flag == true) continue;
            int freq = 1;
            for (int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]) freq++;
            }
            System.out.println(arr[i] + " " + freq);
        }
    }
    public static void efficientSolution(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int freq = 1;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                freq = map.get(arr[i]);
                freq++;
                map.put(arr[i],freq);
            } else {
                freq = 1;
                map.put(arr[i],freq);
            }
        }
        System.out.println(map);
    }
    public static void efficientSolution2(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : arr) {
            // x --> getOrDefault will get x key's value.
            // getOrDefault --> if x is not present, then put default value as 0 and adding 1.
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
