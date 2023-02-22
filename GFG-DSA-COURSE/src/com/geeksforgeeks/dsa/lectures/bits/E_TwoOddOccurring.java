/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.bits;

public class E_TwoOddOccurring {
    public static void main(String[] args) {
        /**
        * [] = {3,4,3,4,5,4,4,6,7,7}
        * groups having last bit as set : {3,3,5,7,7}
        * groups having last bit as not set : {4,4,4,4,6}
        */
        int[] arr = {3,4,3,4,5,4,4,6,7,7};
        twoOddOccurring(arr,arr.length);
    }
    // NAIVE SOLUTION IS SAME AS ONE ODD OCCURRING
    // EFFICIENT SOLUTION
    public static void twoOddOccurring(int[] arr, int n) {
        int XOR = 0;
        int res1 = 0; //for right most set bit groups
        int res2 = 0; //for right most not a set bit groups
        /**
        * XOR = 3 ^ 4 ^ 3 ^ 4 ^ 5 ^ 4 ^ 4 ^ 6 ^ 7 ^ 7
        * XOR = 5 ^ 6
        * 5 : 0 1 0 1
        * 6 : 0 1 1 0
        * -----------
        * ^ : 0 0 1 1
        * -----------
        * XOR = 3
        */
        for (int i = 0; i < n; i++) {
            XOR = XOR ^ arr[i];
        }
        /**
        * rmb = 3 & ~(2)
        *  3 : 0 0 1 1
        * ~2 : 1 1 0 1
        * ------------
        *  & : 0 0 0 1
        * ------------
        * rmb = 1
        */
        int rmb = XOR & ~(XOR-1); // RIGHT MOST BIT
        /**
        * put all elements having last set bits to RES1 & not set bits to RES2
        *   3 : 0011
        * rmb : 0001
        * ----------
        *   & : 0001
        * ----------
        * res 1 = res 1 ^ 3
        */
        for (int i = 0; i < n; i++) {
            if ((arr[i] & rmb) != 0) {
                res1 = res1 ^ arr[i];
            } else {
                res2 = res2 ^ arr[i];
            }
        }
        System.out.println(res1 + " " + res2);
    }
}
