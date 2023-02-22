/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

public class M_LexicographicRank {
    public static void main(String[] args) {
        /**
         *  String      |       Rank
         *  abc         |       1
         *  acb         |       2
         *  bac         |       3
         *  bca         |       4
         *  cab         |       5
         *  cba         |       6
         *  naiveSolution : O(n * n!)
         *  efficientSolution : O(n)
         *  For example : DCBA
         *  A___    |   DB__    |   DCA_
         *  B___    |   DA__    |
         *  C___    |           |
         *  3*3!    |   2*2!    |   1*1!
         *  --> 23 + 1 --> 24
         */

        String str = "BAC";
        System.out.println(naiveSolution(str));
    }
    public static int naiveSolution(String str) {
        final int CHAR = 256;
        int res = 1;
        int n = str.length();
        int mul = factorial(n);
        int count[] = new int[CHAR];
        // Count number of characters in the string
        for (int i = 0; i < n; i++) {
            count[str.charAt(i)]++;
        }
        // Cumulative count array
        for (int i = 1; i < CHAR; i++) {
            count[i] += count[i-1];
        }
        for (int i = 0; i < n-1; i++) {
            mul = mul / (n-i);
            res = res + count[str.charAt(i)-1] * mul;
            for (int j = str.charAt(i); j < CHAR; j++) {
                count[j]--;
            }
        }
        return res;
    }
    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n-1);
    }
}
