/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

public class BitDifference {
    /*
    You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.

    Example 1:
    Input: A = 10, B = 20
    Output: 4
    Explanation:
    A  = 01010
    B  = 10100
    As we can see, the bits of A that need
    to be flipped are 01010. If we flip
    these bits, we get 10100, which is B.

    Example 2:
    Input: A = 20, B = 25
    Output: 3
    Explanation:
    A  = 10100
    B  = 11001
    As we can see, the bits of A that need
    to be flipped are 10100. If we flip
    these bits, we get 11001, which is B.
    */
    public static void main(String[] args) {
        System.out.println(countBitsFlip(10100,11001));
    }
    public static int countBitsFlip(int a, int b){
        int count = 0;
        for(int k = 0; k <= 32; k++) {
            if( (a & (1 << (k-1))) != (b & (1 << (k-1))) ) count++;
        }
        return count;
    }
}
