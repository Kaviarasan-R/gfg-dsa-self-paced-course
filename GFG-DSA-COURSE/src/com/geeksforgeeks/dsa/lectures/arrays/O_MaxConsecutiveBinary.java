/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class O_MaxConsecutiveBinary {
    public static void main(String[] args) {
        /**
         * IP : {0,1,1,0,1,0}
         * OP : 2
         **/
        int[] arr = {0,1,1,0,1,0};
        System.out.println(naiveSolution(arr));
        System.out.println(efficientSolution(arr));

    }
    public static int naiveSolution(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int current = 0;
            for (int j = i; j < n; j++) {
                if(arr[j] == 1) current++;
                else break;
            }
            res = Math.max(current,res);
        }
        return res;
    }
    public static int efficientSolution(int[] arr) {
        int current = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) current = 0;
            else {
                current++;
                res = Math.max(current,res);
            }
        }
        return res;
    }
}
