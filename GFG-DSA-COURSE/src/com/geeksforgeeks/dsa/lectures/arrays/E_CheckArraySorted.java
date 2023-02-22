/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class E_CheckArraySorted {
    public static void main(String[] args) {
        int[] arr = {8,12,15};
        System.out.println(checkArrayNaiveOne(arr));
        System.out.println(checkArrayNaiveTwo(arr));
        System.out.println(checkArrayEfficient(arr));

    }
    // NAIVE SOLUTION O(N^2)
    public static boolean checkArrayNaiveOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[i]) return false;
            }
        }
        return true;
    }
    // NAIVE SOLUTION O(N)
    public static boolean checkArrayNaiveTwo(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
    // EFFICIENT SOLUTION O(N)
    public static boolean checkArrayEfficient(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) return false;
        }
        return true;
    }
}
