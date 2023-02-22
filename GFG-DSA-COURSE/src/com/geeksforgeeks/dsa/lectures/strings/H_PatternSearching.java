/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class H_PatternSearching {
    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String pattern1 = "eks";
        String str2 = "ABCABCDABCD";
        String pattern2 = "ABCD";
        //naiveSolution(str1,pattern1);
        efficientSolution(str2,pattern2);
    }
    public static void naiveSolution(String str, String pattern) {
        int m = pattern.length();
        int n = str.length();
        for (int i = 0; i <= n-m; i++) {
            int j;
            for(j = 0; j < m; j++) {
                if(pattern.charAt(j) != str.charAt(i+j)) {
                    break;
                }
            }
            if(j == m) System.out.println(i);
        }
    }
    public static void efficientSolution(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        for (int i = 0; i <= n-m;) {
            int j;
            for(j = 0; j < m; j++) {
                if(pattern.charAt(j) != str.charAt(i+j)) {
                    break;
                }
            }
            if(j == m) {
                System.out.println(i);
                i++;
            } else if (j == 0) {
                i++;
            } else {
                i = i + j;
            }
        }
    }
}
