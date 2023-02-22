/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class K_Triplets {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 8, 9, 20, 40};
        int x = 32;
        System.out.println(naiveSolution(arr, arr.length, x));
        System.out.println(efficientSolution(arr, arr.length, x));
    }

    public static boolean naiveSolution(int[] arr, int n, int x) {
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == x) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean efficientSolution(int[] arr, int n, int x) {
        /**
         * [2,3,4,8,9,20,40]
         * n = 7
         * x = 32
         * i = 0 < 5 : fn(30,1)
         * i = 1 < 5 : fn(29,2) ¶
         * i = 2 < 5 : fn(28,3)
         * i = 3 < 5 : fn(26,4)
         * i = 4 < 5 : fn(25,5)
         **/
        for (int i = 0; i < n - 2; i++) {
            if (J_TwoPointer.efficientSolution(arr, n, x - arr[i], i + 1)) {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }
}
