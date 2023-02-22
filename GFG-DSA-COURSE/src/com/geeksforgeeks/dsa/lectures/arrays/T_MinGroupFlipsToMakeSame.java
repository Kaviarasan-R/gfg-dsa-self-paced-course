/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class T_MinGroupFlipsToMakeSame {
    public static void main(String[] args) {
        /**
         * arr[] = {1,1,0,0,0,1}
         * OP : from 2 to 4 indexes
         * arr[] = {1,0,0,0,1,0,0,1,1,1,1}
         * OP : from 1 to 3
         *      from 5 to 6
         * arr[] = {1,1,1}
         * OP : null
         * arr[] = {0,1}
         * OP : 0 to 0
         *      1 to 1
         *  METHODOLOGY :
         *  1. Group Counts Differ By One.
         *      When beginning & ending are same group, then differ by one group count. So, we
         *      should take the 2 group for min flips.
         *  2. Group Counts Are Same.
         *      When beginning & ending are not same group, then they have same group count. So, we
         *      should flip the second group.
         **/
        int[] arr = {0,0,1,1,0,0,1,1,0,1};
        naiveSolution(arr,arr.length);
    }

    public static void naiveSolution(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if(arr[i] != arr[i-1]) {
                if(arr[i] != arr[0]) {
                    System.out.print("From " + i + " to ");
                } else {
                    System.out.print((i-1) + " End.\n");
                }
            }
        }
        if(arr[n-1] != arr[0]) {
            System.out.print((n-1) + " End.\n");
        }
    }
}
