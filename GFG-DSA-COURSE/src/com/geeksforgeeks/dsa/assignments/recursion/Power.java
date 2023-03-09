/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

public class Power {
    /*
    You are given two numbers n and p. You need to find np.

    Example 1:
    Input:
    n = 9 p = 9
    Output: 387420489
    Explanation: 387420489 is the value
    obtained when 9 is raised to the
    power of 9.

    Example 2:
    Input:
    n = 2 p = 9
    Output: 512
    Explanation: 512 is the value
    obtained when 2 is raised to
    the power of 9.
    */
    public static void main(String[] args) {
        System.out.println(RecursivePower(2,9));
    }
    public static int RecursivePower(int n,int p) {
        if( p == 0 ) return 1;
        if( p == 1 ) return n;
        return n * RecursivePower(n,p-1);
    }
}
