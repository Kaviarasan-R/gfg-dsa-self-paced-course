/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class C_Subsequence {
    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "AD";
        // AD is a subsequence of ABCD
        System.out.println(naiveSolution(str1,str2,str1.length(),str2.length()));
    }
    public static boolean naiveSolution(String str1, String str2, int n, int m) {
        if(m == 0) return true;
        if(n == 0) return false;
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return naiveSolution(str1,str2,n-1,m-1);
        } else {
            return naiveSolution(str1,str2,n-1,m);
        }
    }
}
