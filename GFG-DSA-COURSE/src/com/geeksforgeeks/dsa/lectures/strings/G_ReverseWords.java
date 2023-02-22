/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class G_ReverseWords {
    public static void main(String[] args) {
        String str = "hi there!";
        naiveSolution(str);
    }
    public static void naiveSolution(String str) {
        String reverse = "";
        for (int i = str.length()-1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        System.out.println(reverse);
    }
}
