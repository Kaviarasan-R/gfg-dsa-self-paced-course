/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class ModularMultiplicativeInverse {
    /*
    Given two integers ‘a’ and ‘m’. The task is to find the smallest modular multiplicative inverse of ‘a’ under modulo ‘m’.

    Example 1:
    Input:
    a = 3
    m = 11
    Output: 4
    Explanation: Since (4*3) mod 11 = 1, 4
    is modulo inverse of 3. One might think,
    15 also as a valid output as "(15*3)
    mod 11"  is also 1, but 15 is not in
    ring {0, 1, 2, ... 10}, so not valid.

    Example 2:
    Input:
    a = 10
    m = 17
    Output: 12
    Explanation: Since (12*10) mod 17 = 1,
    12 is the modulo inverse of 10.
    */
    public static void main(String[] args) {
        System.out.println(modInverse(10,17));
    }
    public static int modInverse(int a, int m) {
        for(int i=1; i < m; i++) {
            if( ((a%m) * (i%m))%m == 1 ) return i;
        }
        return -1;
    }
}
