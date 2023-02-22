/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

import java.util.Arrays;

public class F_LeftmostNonRepeatingElement {
    public static void main(String[] args) {
        String str1 = "geeksforgeeks"; //f is not repeating, so output is 5 (index of left most non-repeating character)
        String str2 = "abcabc"; //every character is repeating, so output is -1
        String str3 = "apple"; //a is not repeating, so output is 0 (index of non-repeating character)
        System.out.println(naiveSolution(str1));
        System.out.println(efficientSolution(str1));
        System.out.println(efficientSolution2(str1));
    }
    public static int naiveSolution(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < str.length(); j++) {
                if(i != j && str.charAt(i) == str.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) return i;
        }
        return -1;
    }
    public static int efficientSolution(String str) {
        final int CHAR = 256;
        int[] count = new int[CHAR];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if(count[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
    public static int efficientSolution2(String str) {
        final int CHAR = 256;
        int[] fi = new int[CHAR];
        Arrays.fill(fi,-1);
        for (int i = 0; i < str.length(); i++) {
            if(fi[str.charAt(i)] == -1) {
                fi[str.charAt(i)] = i;
            } else {
                fi[str.charAt(i)] = -2;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < CHAR; i++) {
            if(fi[i] >= 0) {
                res = Math.min(res,fi[i]);
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
