/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class PrimalityTest {
    /*
    A prime number is a number which is only divisible by 1 and itself.
    Given number N check if it is prime or not.

    Example 1:
    Input:
    N = 5
    Output: Yes
    Explanation: 5 is only divisible by 1
    and itself. So, 5 is a prime number.

    Example 2:
    Input:
    N = 4
    Output: No
    Explanation: 4 is divisible by 2.
    So, 4 is not a prime number.
    */
    public static void main(String[] args) {
        System.out.println(isPrime(5));
    }
    public static boolean isPrime(int N) {
        if ( N == 1 || N == 0) return false;
        for(int i=2; i * i <= N; i++) {
            if(N%i == 0) {
                return false;
            }
        }
        return true;
    }
}
