/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

public class B_PalindromeNumbers {
    public static void main(String[] args) {
        int num = 545;
        checkPalindromeIterative(num);
        int res = checkPalindromeRecursive(num,0);
        if(num == res) System.out.println("Palindrome");
        else System.out.println("Not Palindrome");
    }
    public static void checkPalindromeIterative(int n) {
        int sum = 0;
        int temp = n; // because after the loop, the n becomes zero.
        while(n > 0) {
            int rem = n % 10;
            sum = (sum * 10) + rem;
            n = n/10;
        }
        if(sum == temp) System.out.println("Palindrome");
        else System.out.println("Not Palindrome");
    }
    public static int checkPalindromeRecursive(int n, int temp) {
        if(n == 0) return temp;
        temp = (temp * 10) + (n % 10);
        return checkPalindromeRecursive(n/10, temp);
    }
}
