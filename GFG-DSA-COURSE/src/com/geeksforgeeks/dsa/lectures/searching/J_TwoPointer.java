/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class J_TwoPointer {
    public static void main(String[] args) {
        // (5,12) = 17
        int[] arr = {2,5,8,12,30};
        int x = 17;
        System.out.println(naiveSolution(arr,arr.length,x));
        System.out.println(efficientSolution(arr,arr.length,x,0));
    }
    public static boolean naiveSolution(int[] arr, int n, int x) {
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] + arr[j] == x) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean efficientSolution(int[] arr, int n, int x, int i) {
        int j = n - 1;
        while(i < j) {
            if(arr[i] + arr[j] == x) {
                return true;
            } else if (arr[i] + arr[j] < x) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
