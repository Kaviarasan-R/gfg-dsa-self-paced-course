/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

public class MaximumANDValue {
    /*
    Given an array arr[] of N positive elements. The task is to find the Maximum AND Value generated by any pair(arri, arrj) from the array such that i != j.
    Note: AND is bitwise '&' operator.

    Example 1:
    Input:
    N = 4
    arr[] = {4, 8, 12, 16}
    Output: 8
    Explanation:
    Pair (8,12) has the Maximum AND Value 8.

    Example 2:
    Input:
    N = 4
    arr[] = {4, 8, 16, 2}
    Output: 0
    Explanation: Any two pairs of the array has
    Maximum AND Value 0.
    */
    public static void main(String[] args) {
        int[] arr = {4,8,16,2};
        System.out.println(maxAND(arr,4));
    }
    public static int maxAND (int arr[], int N) {
        int res = 0, count;

        // iterate over total of 32bits
        // from msb to lsb
        for (int bit = 31; bit >= 0; bit--)
        {
            // find the count of element
            // having set msb
            count = checkBit(res | (1 << bit), arr, N);

            // if count >= 2 set particular
            // bit in result
            if ( count >= 2 )
                res |= (1 << bit);
        }

        return res;
    }
    static int checkBit(int pattern, int arr[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            if ((pattern & arr[i]) == pattern)
                count++;
        return count;
    }
}
