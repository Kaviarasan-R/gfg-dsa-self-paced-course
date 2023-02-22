/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

public class A_CountDigits {
    public static int temp = 0;
    public static void main(String[] args) {
        System.out.println(countDigits(18940328));
    }
    public static int countDigits(int n) {
        if(n == 0) return temp;
        temp++;
        return countDigits(n/10);
    }
}
