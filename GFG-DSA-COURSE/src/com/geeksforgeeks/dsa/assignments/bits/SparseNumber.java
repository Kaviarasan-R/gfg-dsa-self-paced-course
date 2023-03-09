/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

public class SparseNumber {
    /*
    Given a number N. The task is to check whether it is sparse or not. A number is said to be a sparse number if no two or more consecutive bits are set in the binary representation.

    Example 1:
    Input: N = 2
    Output: 1
    Explanation: Binary Representation of 2 is 10,
    which is not having consecutive set bits.
    So, it is sparse number.

    Example 2:
    Input: N = 3
    Output: 0
    Explanation: Binary Representation of 3 is 11,
    which is having consecutive set bits in it.
    So, it is not a sparse number.
    */
    public static void main(String[] args) {
        System.out.println(isSparse(2));
    }
    public static boolean isSparse(int n) {
        boolean flag = false;
        int previousBit = 0;
        int currentBit = 0;
        for(int k=1; k <= 32; k++) {
            if( (n & (1 << (k-1))) == 0) {
                currentBit = 0;
            } else {
                currentBit = 1;
            }
            if(currentBit == 1 && previousBit == 1) flag = true;
            previousBit = ((n & (1 << (k-1))) == 0) ? 0 : 1;
        }
        return flag ? false : true;
    }
}
