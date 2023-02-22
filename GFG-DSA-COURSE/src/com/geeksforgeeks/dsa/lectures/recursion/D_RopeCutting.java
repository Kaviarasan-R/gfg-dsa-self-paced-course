/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.recursion;

public class D_RopeCutting {
    public static void main(String[] args) {
        /**

         CHECK DP PACKAGE FOR DYNAMIC APPROACH

        * n = 5, a = 2, b = 5, c = 1
        * OP : 5 --> (we make 5 pieces of length 1 each)
        *----------------------------------------------------
        * n = 23, a = 12, b = 9, c = 11
        * OP : 2 --> (we can make 2 pieces of length 11 & 12)
        *----------------------------------------------------
        * n = 5, a = 4, b = 2, c = 6
        * OP: -1 --> (we cannot cut the rope)
        *----------------------------------------------------
        * n = 5 :
        * a = 2 : we cannot cut the rope successfully.
        *         Because if we cut using (a=2), then we will have remaining length 1.
        * b = 5 : we can able to cut the rope, if we use (b=5), then we have 1 successful cut.
        * c = 1 : we can able to cut the rope, if we use (c=1), then we have 5 successful cut.
        *----------------------------------------------------
        * return the maximum cut, in this case using (C=1) we will have 5 cuts maximum.
        */
        System.out.println(rope(5,2,5,1));
    }
    public static int rope(int n, int a, int b, int c) {
        /**
        * fn(5)
        * |------fn(5-2)
        * |         |----fn(3-2)
        * |         |       |---- fn(1-2) return -1
        * |         |       |---- fn(1-5) return -1
        * |         |       |---- fn(1-1) return  0
        * |         |       |---- res = 0
        * |         |       |---- return res + 1 (1)
        * |         |----fn(3-5)
        * |         |       |---- return -1
        * |         |----fn(3-1)
        * |         |       |---- fn(2-2) return 0
        * |         |       |---- fn(2-5) return -1
        * |         |       |---- fn(2-1) return 1
        * |         |       |---- res = 1
        * |         |       |---- return res + 1 (2)
        * |         |----res = 2
        * |         |----return 3
        * |
        * |------fn(5-5)
        * |         |------ res = 0
        * |         |------ return 1
        * |
        * |------fn(5-1)
        * |         |
        * |         .
        * |         .
        * |         |---- return 4
        * |
        * |------ res = Max(3,1,4) = 4
        * |------ return 5
        */

        if (n == 0) return 0;
        if (n < 0) return -1;
        int max = Math.max(rope(n-a,a,b,c), rope(n-b,a,b,c));
        int res = Math.max(max, rope(n-c,a,b,c));
        if(res == -1) return -1;
        return res + 1;
    }
}
