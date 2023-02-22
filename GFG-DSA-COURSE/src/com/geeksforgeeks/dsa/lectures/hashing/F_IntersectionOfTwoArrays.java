/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashSet;

public class F_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] a = {10,15,20,15,30,30,5};
        int[] b = {30,5,30,80};
        // output -> distinct common elements
        System.out.println(naiveSolution(a,b,a.length,b.length));
        System.out.println(efficientSolution(a,b,a.length,b.length));
    }
    public static int naiveSolution(int[] a, int[] b, int n, int m) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            // check left of the array from i, if it already presents skip.
            for (int j = 0; j <= i-1; j++) {
                if(a[j] == a[i]) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if(a[i] == b[j]) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
    public static int efficientSolution(int[] a, int[] b, int n, int m) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        // set = {10,15,20,30,5}
        // b = {30,5,30,80}
        int res = 0;
        for (int i = 0; i < m; i++) {
            if(set.contains(b[i])) {
                res++;
                set.remove(b[i]);
            }
        }
        return res;
    }
}
