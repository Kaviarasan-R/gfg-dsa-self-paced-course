/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class ExactlyThreeDivisors {
    /*
    Given a positive integer value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.

    Example 1:
    Input:
    N = 6
    Output: 1
    Explanation: The only number less than 6 with
    3 divisors is 4.

    Example 2:
    Input:
    N = 10
    Output: 2
    Explanation: 4 and 9 have 3 divisors.
    */
    public static void main(String[] args) {
        System.out.println(exactly3Divisors(10));
    }
    public static int exactly3Divisors(int N) {
        if(N == 1) return 0;
        int count = 0;
        for(int n=2; n * n <= N; n++) {
            boolean out = isPrime(n);
            if(out) count++;
        }
        return count;
    }
    public static boolean isPrime(int n) {
        if(n == 1) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        for(int i=5; i * i <= n; i = i+6) {
            if(n%i == 0 || n%(i+2) == 0) return false;
        }
        return true;
    }

}
