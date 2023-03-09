/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class GPTerm {
    /*
    Given the first 2 terms A and B of a Geometric Series. The task is to find the Nth term of the series.

    Example 1:
    Input:
    A = 2
    B = 3
    N = 1
    Output: 2
    Explanation: The first term is already
    given in the input as 2

    Example 2:
    Input:
    A = 1
    B = 2
    N = 5
    Output: 16
    Explanation: Common ratio = 2,
    Hence second term is 1*(2)(5-1) = 24 = 16 .
    */
    public static void main(String[] args) {
        System.out.println(termOfGP(1,2,5));
    }
    public static double termOfGP(int A,int B,int N) {
        double commonRatio = (double) B / (double) A;
        double nthTerm = A * Math.pow(commonRatio, N-1);
        return nthTerm;
    }
}
