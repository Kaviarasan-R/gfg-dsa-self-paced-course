/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

import java.util.Arrays;

public class N_LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        /**
         * "abac"
         * a,ab,aba,abac,b,bac,a,ac,c
         */
        String str = "abcdabc";
        System.out.println(naiveSolution(str));
        System.out.println(efficientSolution1(str));
        System.out.println(efficientSolution2(str));
    }
    public static int naiveSolution(String str) {
        int n = str.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(areDistinct(str,i,j)) {
                    res = Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }
    private static boolean areDistinct(String str, int i, int j) {
        boolean visited[] = new boolean[256];
        for (int k = i; k <= j; k++) {
            if(visited[str.charAt(k)] == true) {
                return false;
            }
            visited[str.charAt(k)] = true;
        }
        return true;
    }
    public static int efficientSolution1(String str) {
        int n = str.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean visited[] = new boolean[256];
            for (int j = i; j < n; j++) {
                if(visited[str.charAt(j)] == true) {
                    break;
                } else {
                    res = Math.max(res,j-i+1);
                    visited[str.charAt(i)] = true;
                }
            }
        }
        return res;
    }
    public static int efficientSolution2(String str) {
        int n = str.length();
        int res = 0;
        int visited[] = new int[256];
        Arrays.fill(visited,-1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i,visited[str.charAt(j)] + 1);
            int maxEnd = j - i + 1;
            res = Math.max(res,maxEnd);
            visited[str.charAt(j)] = j;
        }
        return res;
    }
}
