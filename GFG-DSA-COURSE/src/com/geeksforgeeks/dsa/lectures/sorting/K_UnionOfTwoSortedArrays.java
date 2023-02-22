/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class K_UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {2,3,3,3,4,4};
        int[] b = {4,4};
        naiveSolution(a,b,a.length,b.length);
        efficientSolution(a,b,a.length,b.length);
    }
    public static void naiveSolution(int[] a, int[] b, int n, int m) {
        int[] output = new int[n+m];
        for (int i = 0; i < n; i++) {
            output[i] = a[i];
        }
        for (int i = 0; i < m; i++) {
            output[n+i-1] = b[i];
        }
        Arrays.sort(output);
        for (int i = 1; i < n+m; i++) {
            if(output[i] != output[i-1]) {
                System.out.println(output[i]);
            }
        }
    }
    public static void efficientSolution(int[] a, int[] b, int n, int m) {
        int i = 0;
        int j = 0;
        while(i < n && i < m) {
            if(i > 0 && a[i] == a[i-1]) {
                i++;
                continue;
            }
            if(j > 0 && b[j] == b[j-1]) {
                j++;
                continue;
            }
            if(a[i] < b[j]) {
                System.out.println(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                System.out.println(b[i]);
                j++;
            } else if (a[i] == b[j]){
                System.out.println(a[i]);
                i++;
                j++;
            }
        }
        while(i < n) {
            if(i > 0 && a[i] != a[i-1]) {
                System.out.println(a[i]);
            }
            i++;
        }
        while(j < m) {
            if(j > 0 && b[j] != b[j-1]) {
                System.out.println(b[j]);
            }
            j++;
        }
    }
}
