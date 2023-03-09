/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

public class PowerOfNumbers {
    /*
    Given a number and its reverse. Find that number raised to the power of its own reverse.
    Note: As answers can be very large, print the result modulo 109 + 7.

    Example 1:
    Input:
    N = 2
    Output: 4
    Explanation: The reverse of 2 is 2
    and after raising power of 2 by 2
    we get 4 which gives remainder as
    4 by dividing 1000000007.

    Example 2:
    Input:
    N = 12
    Output: 864354781
    Explanation: The reverse of 12 is 21
    and 1221 , when divided by 1000000007
    gives remainder as 864354781.
     */
    public static void main(String[] args) {
        System.out.println(power(12,21)); // number & its reverse.
    }
    public static long power(int N,int R)
    {
        if(R==1)return N;
        if(R%2==0){
            long y=power(N,R/2);
            return (y*y)%1000000007;
        }
        return (N*power(N,R-1))%1000000007;
    }
}
