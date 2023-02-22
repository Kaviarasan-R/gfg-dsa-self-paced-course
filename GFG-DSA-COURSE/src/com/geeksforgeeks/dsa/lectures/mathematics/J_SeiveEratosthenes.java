/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

import java.util.Arrays;

public class J_SeiveEratosthenes {
    public static void main(String[] args) {
        /**
        * n = 10
        * 2 3 5 7 (prime numbers <= 10)
        * we create an boolean array and fills with true
        * if we at i = 2, we will mark false for all multiples of 2
        * if we at i = 3, we will mark false for all multiples of 3
        * we will print only if indexes are true
        */
        seiveNaive(10);
        System.out.println();
        seiveEfficient(10);
    }
    // NAIVE SOLUTION
    public static void seiveNaive(int n) {
        /**
        * array with 11 elements but consider only starts with idx 1 and ignore idx 0.
        * [ ___ , true, true, true, false, true, false, true, false, false, false]
        */
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,true);
        for(int i=2; i*i <= n; i++) {
            if(arr[i]) {
                for(int j=2*i; j <= n; j = j + i) {
                    arr[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if(arr[i]) System.out.println(i);
        }
    }
    // EFFICIENT SOLUTION
    public static void seiveEfficient(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,true);
        for(int i=2; i <= n; i++) {
            if(arr[i]) System.out.println(i);
            for (int j = i * i; j <= n; j = j + i) { // mark multiples of i as false
                arr[j] = false;
            }
        }
    }

}
