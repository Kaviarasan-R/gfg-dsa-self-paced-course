/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.bits;

public class A_Check_Kth_Bit_Set {
    public static void main(String[] args) {
        /**
        * n = 5 --> 0 1 0 1
        * k = 3 --> 8 4 2 1
        * Output : Yes (3rd bit is a set)
        */
        usingLeftShift(5,3);
        usingRightShift(13,3);
    }
    public static void usingLeftShift(int n, int k) {
        /**
        * n = 5 & k = 3
        *      1 : 0 0 0 0 .... 0 0 0 1
        * -----------------------------
        * 1 << 2 : 0 0 0 0 .... 0 1 0 0     (left shift 1 by 2)
        *      5 : 0 0 0 0 .... 0 1 0 1
        * -----------------------------
        *      & : 0 0 0 0 .... 0 1 0 0
        * Now, 4 is not equal to 0.
        */
        if( ( n & (1 << (k-1)) ) != 0) System.out.println(true);
        else System.out.println(false);

    }
    public static void usingRightShift(int n, int k) {
        /**
         * n = 5 & k = 3
         *      5 : 0 0 0 0 .... 0 1 0 1
         * -----------------------------
         * 5 >> 2 : 0 0 0 0 .... 0 0 0 1    (right shift 5 by 2)
         *      1 : 0 0 0 0 .... 0 0 0 1
         * -----------------------------
         *      & : 0 0 0 0 .... 0 0 0 1
         * Now, 1 is equal to 1.
        */
        if( ( (n >> (k-1)) & 1 ) == 1) System.out.println(true);
        else System.out.println(false);
    }
}
