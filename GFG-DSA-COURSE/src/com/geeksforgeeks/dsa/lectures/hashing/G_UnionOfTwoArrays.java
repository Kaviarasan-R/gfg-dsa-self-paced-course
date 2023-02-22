/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashSet;

public class G_UnionOfTwoArrays {
    public static void main(String[] args) {
        int[] a = {15,20,5,15};
        int[] b = {15,15,15,20,10};
        // output -> total distinct elements
        // a + b = 3 + 1 = 4
        System.out.println(naiveSolution(a,b,a.length,b.length));
        System.out.println(efficientSolution(a,b,a.length,b.length));
    }
    public static int naiveSolution(int[] a, int[] b, int n, int m) {
        int[] c = new int[n+m];
        for (int i = 0; i < n; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < m; i++) {
            c[n+i] = b[i];
        }
        int res = 0;
        for (int i = 0; i < n+m; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if(c[i] == c[j]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) res++;
        }
        return res;
    }
    public static int efficientSolution(int[] a, int[] b, int n, int m) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            set.add(b[i]);
        }
        return set.size();
    }
}
