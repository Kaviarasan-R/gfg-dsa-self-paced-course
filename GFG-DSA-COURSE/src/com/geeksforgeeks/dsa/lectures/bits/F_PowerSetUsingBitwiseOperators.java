/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.bits;

public class F_PowerSetUsingBitwiseOperators {
    public static void main(String[] args) {
        /**
        * str = "abc"
        * OP : "","a","b","c","ab","bc","ac","abc"
        */
        print("abc");
    }
    public static void print(String str) {
        int n = str.length(); // 3
        int power = (int) Math.pow(2,n); // 2^3 = 8
        /**
        * binary representation of each bit represent each index of string.
        * EG: 0 0 1 -> a
        *     0 1 0 -> b
        *     1 0 1 -> ac
        * COUNTER (DECIMAL) | COUNTER (BINARY)  | SUBSET
        * ----------------------------------------------
        *         0         |       0 0 0       |   ""
        *         1         |       0 0 1       |   "a"
        *         2         |       0 1 0       |   "b"
        *         3         |       0 1 1       |   "ab"
        *         4         |       1 0 0       |   "c"
        *         5         |       1 0 1       |   "ac"
        *         6         |       1 1 0       |   "bc"
        *         7         |       1 1 1       |   "abc"
        * FOR EXAMPLE :
        * 1 << 0 : 0 0 1
        * 1 << 1 : 0 1 0
        * 1 << 2 : 1 0 0
        *
        * counter = 3 :
        *      3 : 0 1 1
        * 1 << 0 : 0 0 1
        * --------------
        *      & : 0 0 1  --> a
        * --------------
        *
        *      3 : 0 1 1
        * 1 << 1 : 0 1 0
        * --------------
        *      & : 0 1 0 --> b
        * --------------
        *
        *      3 : 0 1 1
        * 1 << 2 : 1 0 0
        * --------------
        *      & : 0 0 0
        * --------------
        */
        for (int counter = 0; counter < power; counter++) {
            for (int i = 0; i < n; i++) { // check every bit
                if ((counter & (1 << i)) != 0) {
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
