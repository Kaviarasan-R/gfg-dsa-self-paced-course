/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class L_CheckRotation {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "cdab"; // cd comes before ab
        System.out.println(effectiveSolution(str1,str2));
    }
    public static boolean effectiveSolution(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        return ((str1 + "" + str1).indexOf(str2) >= 0);
    }
}
