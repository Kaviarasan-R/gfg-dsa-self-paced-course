/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

import java.util.TreeSet;

public class G_CeilingLeftSide {
    public static void main(String[] args) {
        /** smallest element greater than equal to current element
         *  2,  8, 30, 15, 25, 12
         * -1, -1, -1, 30, 30, 15
         * */
        int[] arr = {2,8,30,15,25,12};
        int n = arr.length;
        naiveSolution(arr,n);
        System.out.println();
        efficientSolution(arr,n);
    }
    public static void naiveSolution(int[] arr, int n) {
        System.out.print(-1 + " ");
        for (int i = 1; i < n; i++) {
            int diff = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if(arr[j] >= arr[i]) {
                    diff = Math.min(diff,arr[j]-arr[i]);
                }
            }
            if(diff == Integer.MAX_VALUE) System.out.print(-1 + " ");
            else System.out.print(arr[i]+diff + " ");
        }
    }
    public static void efficientSolution(int[] arr, int n) {
        System.out.print(-1 + " ");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if(treeSet.ceiling(arr[i]) != null && treeSet.contains(treeSet.ceiling(arr[i]))) {
                System.out.print(treeSet.ceiling(arr[i]) + " ");
            } else {
                System.out.print(-1 + " ");
            }
            treeSet.add(arr[i]);
        }
    }
}
