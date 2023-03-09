/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

public class DigitalRoot {
    /*
    You are given a number n. You need to find the digital root of n.
    DigitalRoot of a number is the recursive sum of its digits until we get a single digit number.

    Example 1:
    Input:
    n = 1
    Output:  1
    Explanation: Digital root of 1 is 1

    Example 2:
    Input:
    n = 99999
    Output: 9
    Explanation: Sum of digits of 99999 is 45
    which is not a single digit number, hence
    sum of digit of 45 is 9 which is a single
    digit number.
    */
    public static void main(String[] args) {
        System.out.println(digitalRoot(99999));
    }
    public static int digitalRoot(int n) {
        int sum = sumOfDigits(n);
        int count = CountDigits.countDigit(sum);
        int roots = 0;
        while(sum > 0) {
            roots += sum % 10;
            sum = sum / 10;
            if(sum == 0 && CountDigits.countDigit(roots) > 1) {
                sum = roots;
                roots = 0;
            }
        }
        return roots;
    }
    public static int sumOfDigits(int n) {
        return n == 0 ? 0 : n%10 + sumOfDigits(n/10);
    }
}
