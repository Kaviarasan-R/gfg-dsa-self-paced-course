/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashSet;

public class J_SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {5,8,6,13,3,-1};
        int sum = 22;
        HashSet<Integer> set = new HashSet<>();
        int prev_sum = 0;
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            prev_sum += arr[i];
            if((prev_sum == sum) || set.contains(prev_sum-sum)) {
                flag = 1;
                System.out.println("true");
                break;
            }
            set.add(prev_sum);
        }
        if(flag == 0) {
            System.out.println("false");
        }
    }
}
