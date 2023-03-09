/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

public class GrayToBinary {
    /*Given N in Gray Code, find its binary equivalent. Return the decimal representation of the binary equivalent.

    Example 1:
    Input: N = 4
    Output: 7
    Explanation:
    Given 4 representing gray code 110.
    Binary equivalent of gray code 110 is 100.
    Return 7 representing gray code 100.

    Example 2:
    Input: N = 15
    Output: 10
    Explanation:
    Given 15 representing gray code 1000.
    Binary equivalent of gray code 1000 is 1111.
    Return 10 representing gray code 1111
    ie binary 1010.*/
    public static void main(String[] args) {
        System.out.println(grayToBinary(15));
    }
    public static int grayToBinary(int n) {
        int res = n;
        while (n > 0) {
            n >>= 1;
            res ^= n;
        }
        return res;
    }
}
