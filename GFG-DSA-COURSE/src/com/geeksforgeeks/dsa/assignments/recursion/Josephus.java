/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

public class Josephus {
    /*
    Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle in a fixed direction.
    After each operation, the count will start from k+1th person. The task is to choose the safe place in the circle so that when you perform these operations starting from 1st place in the circle, you are the last one remaining and survive.

    Example 1:
    Input:
    n = 3 k = 2
    Output: 3
    Explanation: There are 3 persons so
    skipping 1 person i.e 1st person 2nd
    person will be killed. Thus the safe
    position is 3.

    Example 2:
    Input:
    n = 5 k = 3
    Output: 4
    Explanation: There are 5 persons so
    skipping 2 person i.e 3rd person will
    be killed. Thus the safe position is 4.
    */
    public static void main(String[] args) {
        System.out.println(josephusZeroIndex(5,3));
        System.out.println(josephusFirstIndex(5,3));
    }
    public static int josephusZeroIndex(int n, int k) {
        if(n == 1) return 0;
        return (josephusZeroIndex(n-1, k) + k) % n;
    }
    public static int josephusFirstIndex(int n, int k) {
        if(n == 1) return 1;
        return (josephusFirstIndex(n-1,k) + k - 1) % n + 1;
    }
}
