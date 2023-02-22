/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.recursion;

public class C_PalindromeString {
    public static void main(String[] args) {
        String str =  "abbcbba";
        System.out.println(isPalindrome(str,0,str.length()-1));
    }
    public static boolean isPalindrome(String str, int start, int end) {
        if(start >= end) {
            return true;
        }
        return (str.charAt(start) == str.charAt(end)) && isPalindrome(str,start+1,end-1);
    }
}
