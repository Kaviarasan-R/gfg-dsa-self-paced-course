/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

public class G_PrimeNumbers {
    public static void main(String[] args) {
        System.out.println(isPrimeNaive(7));
        System.out.println(isPrimeEfficient(37));
        System.out.println(isPrimeOptimized(1031));
    }
    // NAIVE SOLUTION
    public static boolean isPrimeNaive(int n) {
        if(n == 1) return false;
        for(int i=2; i < n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    // EFFICIENT SOLUTION
    public static boolean isPrimeEfficient(int n) {
        if(n == 1) return false;
        for(int i=2; i * i <= n; i++ ) {
            if(n % i == 0) return false;
        }
        return true;
    }
    // OPTIMIZED SOLUTION
    public static boolean isPrimeOptimized(int n) {
        if(n == 1) return false;
        if(n == 2 || n ==3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(int i=5; i <= Math.sqrt(n); i++) {
            if(n % i == 0 || n % (i+2) == 0) return false;
        }
        return true;
    }

}
