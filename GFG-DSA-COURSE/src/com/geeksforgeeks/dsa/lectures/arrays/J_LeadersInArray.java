/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class J_LeadersInArray {
    public static void main(String[] args) {
        /**
         * arr[] = {7,10,4,3,6,5,2}
         * OP : 10,6,5,2
         * arr[] = {10,20,30}
         * OP : 30
         * arr[] = {30,20,10}
         * OP : 30,20,10
         * Right most element not having largest element
         **/
        int[] arr1 = {7,10,4,3,6,5,2};
        int[] arr2 = {10,20,30};
        naiveSolution(arr1,arr1.length);
        efficientSolution(arr2,arr2.length);
    }
    public static void naiveSolution(int[] arr, int n) {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            flag = false;
            for (int j = i+1; j < n; j++) {
                if(arr[i] >= arr[j]) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println(arr[i]);
        }
        System.out.println(arr[n-1]);
    }
    public static void efficientSolution(int[] arr, int n) {
        int current_leader = arr[n-1];
        System.out.println(current_leader);
        for (int i = n-2; i >= 0 ; i--) {
            if(current_leader < arr[i]) {
                current_leader = arr[i];
                System.out.println(current_leader);
            }
        }
    }
}
