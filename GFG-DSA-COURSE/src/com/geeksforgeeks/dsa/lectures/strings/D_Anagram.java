/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class D_Anagram {
    public static void main(String[] args) {
        // every character in STRING 1 should be in STRING 2
        // str1 = aab
        // str2 = bab
        // output : false
        // contiguous not matter
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(efficientSolution(str1,str2));
    }
    public static boolean efficientSolution(String str1, String str2) {
        final int CHAR = 256;
        if(str1.length() != str2.length()) {
            return false;
        }
        int[] count = new int[CHAR];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int i = 0; i < CHAR; i++) {
            if(count[i] != 0) return false;
        }
        return true;
    }
}
