/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

import java.util.ArrayList;
import java.util.Collections;

public class LongestConsecutive1 {
    /*
    Given a number N. Find the length of the longest consecutive 1s in its binary representation.

    Example 1:
    Input: N = 14
    Output: 3
    Explanation:
    Binary representation of 14 is
    1110, in which 111 is the longest
    consecutive set bits of length is 3.

    Example 2:
    Input: N = 222
    Output: 4
    Explanation:
    Binary representation of 222 is
    11011110, in which 1111 is the
    longest consecutive set bits of length 4.
    */
    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(222));
    }
    public static int maxConsecutiveOnes(int n) {
        int countFromOne = 1;
        int previousBit = 0;
        int currentBit = 0;
        ArrayList<Integer> totalConsecutives = new ArrayList<Integer>();
        for(int k=1; k <= 32; k++) {
            if( (n & (1 << (k-1))) == 0) {
                currentBit = 0;
            } else {
                currentBit = 1;
            }
            if(currentBit == 1 && previousBit == 1) countFromOne++;
            if(currentBit != previousBit && countFromOne > 1) {
                totalConsecutives.add(countFromOne);
                countFromOne = 1;
            }
            previousBit = ((n & (1 << (k-1))) == 0) ? 0 : 1;
        }
        if(currentBit == 1 && previousBit == 1 && countFromOne > 1) totalConsecutives.add(countFromOne);
        int max = totalConsecutives.size() == 0 ? 1 : Collections.max(totalConsecutives);
        return max;
    }
}
