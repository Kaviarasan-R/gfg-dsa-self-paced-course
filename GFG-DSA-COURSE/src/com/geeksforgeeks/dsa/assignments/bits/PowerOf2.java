/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

public class PowerOf2 {
    /*
    Given a non-negative integer N. The task is to check if N is a power of 2. More formally, check if N can be expressed as 2x for some x.

    Example 1:
    Input: N = 1
    Output: YES
    Explanation:1 is equal to 2
    raised to 0 (20 = 1).

    Example 2:
    Input: N = 98
    Output: NO
    Explanation: 98 cannot be obtained
    by any power of 2.
    */
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(98));
    }
    public static boolean isPowerOfTwo(long n){
        if(n == 0) return false;
        while(n > 1) {
            if(n % 2 != 0) return false;
            n = n / 2;
        }
        return true;
    }
}
