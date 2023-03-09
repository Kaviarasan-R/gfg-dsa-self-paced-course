/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

public class SwapAllOddEvenBits {
    /*
    Given an unsigned integer N. The task is to swap all odd bits with even bits. For example, if the given number is 23 (00010111), it should be converted to 43(00101011). Here, every even position bit is swapped with an adjacent bit on the right side(even position bits are highlighted in the binary representation of 23), and every odd position bit is swapped with an adjacent on the left side.

    Example 1:
    Input: N = 23
    Output: 43
    Explanation:
    Binary representation of the given number
    is 00010111 after swapping
    00101011 = 43 in decimal.

    Example 2:
    Input: N = 2
    Output: 1
    Explanation:
    Binary representation of the given number
    is 10 after swapping 01 = 1 in decimal.
    */
    public static void main(String[] args) {
        System.out.println(swapBits(2));
    }
    public static int swapBits(int n) {
        int even_bits = n & 0xAAAAAAAA;
        int odd_bits = n & 0x55555555;
        even_bits >>= 1;
        odd_bits <<= 1;
        return (even_bits | odd_bits);
    }
}
