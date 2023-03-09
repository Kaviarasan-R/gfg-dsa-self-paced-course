/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class AdditionUnderModulo {
    /*
    Given two numbers a and b, find the sum of a and b. Since the sum can be very large, find the sum modulo 109+7.

    Example 1:
    Input:
    a = 9223372036854775807
    b = 9223372036854775807
    Output: 582344006
    Explanation:
    9223372036854775807 + 9223372036854775807
    = 18446744073709551614.
    18446744073709551614 mod (109+7)
    = 582344006

    Example 2:
    Input:
    a = 1000000007
    b = 1000000007
    Output: 0
    Explanation: 1000000007 + 1000000007 =
    (2000000014) mod (109+7) = 0
    */
    public static void main(String[] args) {
        System.out.println(sumUnderModulo(1000000007,1000000007));
    }
    public static long sumUnderModulo(long a, long b){
        long mod1 = a % (long)(1000000007);
        long mod2 = b % (long)(1000000007);
        return (long)(mod1+mod2) % (long)(1000000007);
    }
}
