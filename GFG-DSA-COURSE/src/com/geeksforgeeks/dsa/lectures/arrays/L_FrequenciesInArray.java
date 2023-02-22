/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class L_FrequenciesInArray {
    public static void main(String[] args) {
        int[] arr = {10,10,10,25,30,30};
        /**
         * 10 : 3
         * 25 : 1
         * 30 : 2
         **/
        mySolution(arr,arr.length);
        gfgSolution(arr,arr.length);
    }
    public static void mySolution(int[] arr, int n) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i-1] == arr[i]) count++;
            else {
                System.out.println(arr[i - 1] + " : " + count);
                count = 1;
            }
        }
        System.out.println(arr[n-1] + " : " + count);
    }
    public static void gfgSolution(int[] arr, int n) {
        int frequency = 1;
        int i = 1;
        while(i < n) {
            while( i < n && arr[i] == arr[i-1]) {
                frequency++;
                i++;
            }
            System.out.println(arr[i-1] + " : " + frequency);
            i++;
            frequency = 1;
        }
        if(n == 1 || arr[n-1] != arr[n - 2]) {
            System.out.println(arr[n-1] + " : " + frequency);
        }
    }
}
