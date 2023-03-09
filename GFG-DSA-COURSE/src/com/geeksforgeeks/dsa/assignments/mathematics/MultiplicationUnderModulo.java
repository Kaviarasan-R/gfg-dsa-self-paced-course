/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class MultiplicationUnderModulo {
    /*
    You are given two numbers a and b. You need to find the multiplication of a and b under modulo M (M as 109+7).

    Example 1:
    Input:
    a = 92233720368547758
    b = 92233720368547758
    Output: 484266119
    Explanation: Multiplication of a and b
    under modulo M will be 484266119.

    Example 2:
    Input:
    a = 1000000007
    b = 1000000007
    Output: 0
    Explanation: Multiplication of a and b
    under modulo M is 0.
    */
    public static void main(String[] args) {
        System.out.println(multiplicationUnderModulo(1000000007,1000000007));
    }
    static long multiplicationUnderModulo(long a, long b) {
        long mul1 = (long)(a) % (long)(1000000007);
        long mul2 = (long)(b) % (long)(1000000007);
        return (long)(mul1*mul2) % (long)(1000000007);
    }
}
