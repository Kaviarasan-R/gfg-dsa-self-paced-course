/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

public class RightMostDifferentBit {
    /*
    Given two numbers M and N. The task is to find the position of the rightmost different bit in the binary representation of numbers.

    Example 1:
    Input: M = 11, N = 9
    Output: 2
    Explanation: Binary representation of the given
    numbers are: 1011 and 1001,
    2nd bit from right is different.

    Example 2:
    Input: M = 52, N = 4
    Output: 5
    Explanation: Binary representation of the given
    numbers are: 110100 and 0100,
    5th-bit from right is different.
    */
    public static void main(String[] args) {
        System.out.println(posOfRightMostDiffBit(52,4));
    }
    public static int posOfRightMostDiffBit(int m, int n) {
        int res = 1;
        while(m >= 0 && n >= 0) {
            if(m % 2 == n % 2) {
                res++;
            }
            else {
                return res;
            }
            m = m / 2;
            n = n / 2;
            if(n == 0 && m == 0) return -1;
        }
        return res + 1;
    }
}
