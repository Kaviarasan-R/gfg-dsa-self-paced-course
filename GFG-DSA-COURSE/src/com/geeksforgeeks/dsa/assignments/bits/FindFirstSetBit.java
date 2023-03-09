/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

public class FindFirstSetBit {
    /*
    Given an integer N. The task is to return the position of first set bit found from the right side in the binary representation of the number.
    Note: If there is no set bit in the integer N, then return 0 from the function.

    Example 1:
    Input: N = 18
    Output: 2
    Explanation: Binary representation of
    18 is 010010,the first set bit from the
    right side is at position 2.

    Example 2:
    Input: N = 12
    Output: 3
    Explanation: Binary representation
    of  12 is 1100, the first set bit
    from the right side is at position 3.
    */
    public static void main(String[] args) {
        System.out.println(getFirstSetBit(12));
    }
    public static int getFirstSetBit(int n){
        if(n == 0) return 0;
        int res = 1;
        while(n > 0) {
            if(n % 2 != 0) return res;
            else res ++;
            n = n / 2;
        }
        return res;
    }
}
