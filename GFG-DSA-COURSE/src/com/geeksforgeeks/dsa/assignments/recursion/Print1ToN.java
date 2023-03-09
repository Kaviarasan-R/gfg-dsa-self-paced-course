/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

public class Print1ToN {
    /*
    Print numbers from 1 to N without the help of loops.

    Example 1:
    Input:
    N = 10
    Output: 1 2 3 4 5 6 7 8 9 10

    Example 2:
    Input:
    N = 5
    Output: 1 2 3 4 5
     */
    public static void main(String[] args) {
        printNos(5);
    }
    public static void printNos(int N) {
        if(N == 0) return;
        printNos(N-1);
        System.out.print(N + " ");
    }
}
