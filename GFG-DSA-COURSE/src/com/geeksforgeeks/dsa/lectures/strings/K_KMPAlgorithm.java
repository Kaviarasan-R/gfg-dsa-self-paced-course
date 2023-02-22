/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class K_KMPAlgorithm {
    public static void main(String[] args) {
        String str = "ababcababaad";
        String pattern = "ababa";
        KMPAlgorithm(str,pattern);
    }
    public static void KMPAlgorithm(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        int[] lps = new int[m];
        lps = J_LongestProperPrefixSuffixArray.efficientSolution(pattern,m,lps);
        int i = 0;
        int j = 0;
        while(i < n) {
            if(pattern.charAt(j) == str.charAt(i)) {
                i++;
                j++;
            }
            if(j == m) {
                System.out.println(i-j);
                j = lps[j-1];
            } else if (i < n && pattern.charAt(j) != str.charAt(i)) {
                if(j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }
    }
}
