/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class B_Palindrome {
    public static void main(String[] args) {
        String str = "ABCDCBA";
        System.out.println(naiveSolution(str));
        System.out.println(efficientSolution(str));
    }
    public static boolean naiveSolution(String str) {
        String reverse = "";
        for (int i = str.length()-1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        if(str.equals(reverse)) return true;
        return false;
    }
    public static boolean efficientSolution(String str) {
        int low = 0;
        int high = str.length() - 1;
        while(low < high) {
            if(str.charAt(low) == str.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }
}
