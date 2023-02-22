/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.Arrays;
import java.util.HashSet;

public class D_CountDistinct {
    public static void main(String[] args) {
        int[] arr = {10,20,10,20,30};
        HashSet<Integer> set = new HashSet<>(Arrays.asList(10,20,10,20,30));
        System.out.println(set.size());
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hashset.add(arr[i]);
        }
        System.out.println(hashset.size());
    }
}
