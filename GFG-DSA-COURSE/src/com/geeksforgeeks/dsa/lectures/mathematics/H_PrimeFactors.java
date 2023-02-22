/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

public class H_PrimeFactors {
    public static void main(String[] args) {
        /**
        * 12 -> 2 * 2 * 3
        * 13 -> 1 * 13
        * 315 -> 3 * 3 * 5 * 7
        */
        primeFactorsNaive(12);
        System.out.println("----------------------");
        primeFactorsEfficient(13);
        System.out.println("----------------------");
        primeFactorsOptimized(315);
    }
    // NAIVE SOLUTION
    public static void primeFactorsNaive(int n) {
        /**
        * n = 12
        * i == 2, 12 % 2 = 0 ✔
        * i == 2, 12 % 4 = 0 ✔
        * x = 8 (12 % 8 === 1.5)
        * i == 3, 12 % 3 = 0 ✔
        * x = 9 (12 % 9 === 1.3)
        */
        for(int i = 2; i < n; i++) {
            if(isPrime(i)) {
                int x = i;
                while(n % x == 0) {
                    System.out.println(i);
                    x = x * i;
                }
            }
        }
    }
    public static boolean isPrime(int n) {
        if(n == 1) return false;
        if(n == 2 || n ==3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(int i=5; i <= Math.sqrt(n); i++) {
            if(n % i == 0 || n % (i+2) == 0) return false;
        }
        return true;
    }
    // EFFICIENT SOLUTION
    public static void primeFactorsEfficient(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            while(n % i == 0) {
                System.out.println(i);
                n = n / i;
            }
        }
        if(n > 1) System.out.println(n); // print last prime number
    }
    // OPTIMIZED SOLUTION
    public static void primeFactorsOptimized(int n) {
        while(n % 2 == 0) {
            System.out.println(2);
            n = n / 2;
        }
        while(n % 3 == 0) {
            System.out.println(3);
            n = n / 3;
        }
        for(int i = 5; i <= Math.sqrt(n); i++) {
            while(n % i == 0) {
                System.out.println(i);
                n = n / i;
            }
            while(n % (i + 2) == 0) {
                System.out.println(i+2);
                n = n / (i+2);
            }
        }
        if(n > 3) System.out.println(n);
    }
}
