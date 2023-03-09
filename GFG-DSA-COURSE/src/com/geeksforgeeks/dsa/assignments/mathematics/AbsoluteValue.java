/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class AbsoluteValue {
    /*
    You are given an integer I, find the absolute value of the integer I.
    Example 1:
    Input:
    I = -32
    Output: 32
    Explanation: The absolute value of -32 is 32.
    */

    public static void main(String[] args) {
        System.out.println(absolute(-20));
    }
    public static int absolute(int I) {
        // code here
        return Math.abs(I);
    }
}
