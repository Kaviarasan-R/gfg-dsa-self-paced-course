/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class A_FrequencyOfStrings {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        naiveSolution(str);
    }
    public static void naiveSolution(String str) {
        int[] count = new int[26];
        // 'g' --> 103 && 'a' --> 97
        // 103 - 97 = 6
        // count[6]++
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                System.out.println((char) (i+'a') + " " + count[i]);
            }
        }
    }
}
