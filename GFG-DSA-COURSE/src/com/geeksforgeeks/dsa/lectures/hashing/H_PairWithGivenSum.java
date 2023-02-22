/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashSet;

public class H_PairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {11,5,6};
        int[] arr2 = {3,2,8,15,-8};
        int sum = 10;
        int sum2 = 17;
        boolean flag = false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            if(set.contains(sum2-arr2[i])) {
                flag = true;
                System.out.println("true");
            }
            set.add(arr2[i]);
        }
        if(!flag) System.out.println("false");
    }
}
