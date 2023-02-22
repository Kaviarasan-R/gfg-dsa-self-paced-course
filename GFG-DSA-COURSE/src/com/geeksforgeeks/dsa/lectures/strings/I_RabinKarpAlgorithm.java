/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class I_RabinKarpAlgorithm {
    public static void main(String[] args) {
        String str = "132456";
        String pattern = "3245";
        int m = pattern.length();
        int d = 10; // Random Weights
        int q = 101; // Random Prime Number
        rabinKarpAlgorithm(str,pattern,m,d,q);
    }
    public static void rabinKarpAlgorithm(String str, String pattern, int m, int d, int q) {
        // Calculate hash value for the all characters in pattern.
        int h = 1;
        for (int i = 1; i < m; i++) {
            h = (h * d) % q;
        }
        // Calculate hash value's for pat & txt.
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        for (int i = 0; i < m; i++) {
            p = ((p * d) + pattern.charAt(i)) % q;
            t = ((t * d) + str.charAt(i)) % q;
        }
        // Omit last element from pattern
        for (int i = 0; i <= str.length()-m; i++) {
            // Checking matched value
            if(p == t) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if(str.charAt(i+j) != pattern.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) System.out.println(i);
            }
            // Finding next value Ti - 1
            if(i < (str.length()-m)) {
                t = ( (d * (t - str.charAt(i) * h) + str.charAt(i+m)) % q );
                if(t < 0) t = t + q;
            }
        }
    }
}
