/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.recursion;

public class I_Permutation {
    public static void main(String[] args) {
        String str = "ABC";
        permutation(str,0);
    }
    public static void permutation(String str, int i) {
        if(i == str.length()) {
            System.out.println(str);
            return;
        }
        for (int j = i; j < str.length(); j++) {
            str = swap(str,i,j);
            permutation(str,i+1);
            str = swap(str,i,j);
        }
    }

    private static String swap(String str, int i, int j) {
        char[] charArr = str.toCharArray();
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
        String s = "";
        for (int k = 0; k < str.length(); k++) {
            s += charArr[k];
        }
        return s;
    }
}
