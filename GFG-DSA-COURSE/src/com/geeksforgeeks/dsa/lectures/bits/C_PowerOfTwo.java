/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.bits;

public class C_PowerOfTwo {
    public static void main(String[] args) {
        /**
        * n = 4 --> OP : YES
        * 2^0 = 1, 2^1 = 2, 2^2 = 4, 2^3 = 8,...
        * n = 6 --> OP : NO
        */
        System.out.println(isPowerNaive(6));
        System.out.println(isPowerEfficient(4));
    }
    // NAIVE SOLUTION
    public static boolean isPowerNaive(int n) {
        if(n == 0) return false;
        while(n != 1) {
            if(n % 2 != 0) { // CHECKS FOR ODD NUMBER
                return false;
            }
            n = n / 2; // REDUCE BY HALF
        }
        return true;
    }
    // EFFICIENT SOLUTION
    public static boolean isPowerEfficient(int n) {
        /**
        * 4 : 0 0 ... 1 0 0
        * 3 : 0 0 ... 0 1 1
        * -----------------
        * & : 0 0 ... 0 0 0
        * -----------------
        */
        if(n == 0) return false;
        return ( ( n & (n-1) ) == 0 );
    }
}
