/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.bits;

public class CountTotalSetBits {
    /*
    You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

    Example 1:
    Input: N = 4
    Output: 5
    Explanation:
    For numbers from 1 to 4.
    For 1: 0 0 1 = 1 set bits
    For 2: 0 1 0 = 1 set bits
    For 3: 0 1 1 = 2 set bits
    For 4: 1 0 0 = 1 set bits
    Therefore, the total set bits is 5.

    Example 2:
    Input: N = 17
    Output: 35
    Explanation: From numbers 1 to 17(both inclusive),
    the total number of set bits is 35.
    */
    public static void main(String[] args) {
        System.out.println(countSetBits(17));
    }
    public static int countSetBits(int n){
        int count = 0;
        for(int i = 1; i <= n; i++) {
            int setBits = helper(i);
            count += setBits;
        }
        return count;
    }
    public static int helper(int n) {
        int[] table = new int[256];
        table[0] = 0;
        for(int i=1; i < 256; i++) {
            table[i] = (i&1) + table[i/2];
        }
        int res = table[n & 0xff];
        n = n >> 8;
        res = res + table[n & 0xff];
        n = n >> 8;
        res = res + table[n & 0xff];
        n = n >> 8;
        res = res + table[n & 0xff];
        return res;
    }
    public static int countSetBits1ToN(int n) {
        int count = 0;
        boolean flag = true;
        // 2 ^ 0 (initialize)
        int A = (n+1) / 2;
        count += A;
        // 2 ^ 1
        int power = 1;
        int powerOfTwo = (int) Math.pow(2,power);
        while(powerOfTwo < (n+1)) {
            A = (n+1) / powerOfTwo;
            flag = A % 2 == 0 ? false : true;
            A = A / 2;
            int B = A * powerOfTwo;
            if(flag) {
                int C = (n+1) % powerOfTwo;
                int BC = B + C;
                count += BC;
            } else {
                count += B;
            }
            power++;
            powerOfTwo = (int) Math.pow(2,power);
        }
        return count;
    }
}
