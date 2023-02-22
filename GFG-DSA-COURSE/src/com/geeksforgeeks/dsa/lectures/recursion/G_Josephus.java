/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.recursion;

public class G_Josephus {
    public static void main(String[] args) {
        /**
        * n = 7 & k = 3
        * OP : 3
        * Total 7 people and kill every 3rd person and return the survivor.
        * starts with 0 and ends with (n-1)
        */
        System.out.println(jose(5,3));
    }
    public static int jose(int n, int k) {
        /**
         * fn(5,3)  ====> 3
         * |----- fn(4,3) + 3 % 5 ====> {0 + 3 % 5 = 3}
         *         |----- fn(3,3) + 3 % 4  ====> {1 + 3 % 4 = 0}
         *                   |----- fn(2,3) + 3 % 3  ====> {1 + 3 % 3 = 1}
         *                             |----- fn(1,3) + 3 % 2  ====> {0 + 3 % 2 = 1}
         *                                       |----- return 0
         */
        if(n == 1) return 0;
        return (jose(n-1,k) + k) % n;
    }
}
