/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

import java.util.Arrays;

public class J_LongestProperPrefixSuffixArray {
    public static void main(String[] args) {
        /** proper prefix of "abc"
         * " ", " a ", " ab "
         * proper suffix of "abcd"
         * " ", " d ", " cd ", " bcd ", " abcd "
         * Explanation : aba
         * --> First entry is always going to be zero
         * --> Second entry is depends on first entry, whether they both are same or not (1 or 0)
         * --> Third entry : aba (prefix & suffix)
         * prefix : "","a","ab","aba"
         * suffix : "a","ba","aba",""
         * ab ≠ ba
         * So, for third it will be 1. (ans : [0,0,1])
         */
        String str = "ababc";
        int n = str.length();
        int[] lps = new int[n];
        naiveSolution(str,n);
        efficientSolution(str,n,lps);
    }
    public static void naiveSolution(String str, int n) {
        int[] lps = new int[n];
        for (int i = 0; i < str.length(); i++) {
            lps[i] = longProperPrefixSuffix(str,i+1);
        }
        System.out.println(Arrays.toString(lps));
    }
    private static int longProperPrefixSuffix(String str, int n) {
        for (int len = n-1; len > 0; len--) {
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                if(str.charAt(i) != str.charAt(n-len+i)) {
                    flag = false;
                }
            }
            if(flag == true) {
                return len;
            }
        }
        return 0;
    }
    public static int[] efficientSolution(String str, int n, int[] lps) {
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while(i < n) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len-1];
                }
            }
        }
        System.out.println(Arrays.toString(lps));
        return lps;
    }
}
