/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.strings;

import java.util.Arrays;

public class E_LeftmostRepeatingElement {
    public static void main(String[] args) {
        // geeksforgeeks --> letter g is repeating (output : 1)
        String str = "abbcc"; // letter b is repeated at index 3
        System.out.println(naiveSolution(str));
        System.out.println(efficientSolution(str));
        System.out.println(efficientSolution2(str));
        System.out.println(efficientSolution3(str));
    }
    public static int naiveSolution(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    return i;
                }
            }
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
            if(count[str.charAt(i)] > 1) return i;
        }
        return -1;
    }
    public static int efficientSolution2(String str) {
        final int CHAR = 256;
        int[] findex = new int[CHAR];
        Arrays.fill(findex,-1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int fi = findex[str.charAt(i)];
            if(fi == -1) {
                findex[str.charAt(i)] = i;
            } else {
                res = Math.min(res,fi);
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
    public static int efficientSolution3(String str) {
        final int CHAR = 256;
        boolean[] visited = new boolean[CHAR];
        int res = -1;
        for (int i = str.length()-1; i >= 0; i--) {
            if(visited[str.charAt(i)]) {
                res = i;
            } else {
                visited[str.charAt(i)] = true;
            }
        }
        return res;
    }
}
