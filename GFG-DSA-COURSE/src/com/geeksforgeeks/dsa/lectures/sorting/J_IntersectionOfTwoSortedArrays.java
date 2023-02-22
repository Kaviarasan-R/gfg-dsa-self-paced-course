/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

public class J_IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {3,5,10,10,10,15,15,20};
        int[] b = {5,10,10,15,30};
        naiveSolution(a,b,a.length,b.length);
        efficientSolution(a,b,a.length,b.length);
    }
    public static void naiveSolution(int[] a, int[] b, int n, int m) {
        for (int i = 0; i < n; i++) {
            if(i > 0 && a[i] == a[i-1]) continue;
            for (int j = 0; j < m; j++) {
                if(a[i] == b[j]) {
                    System.out.println(a[i]);
                    break;
                }
            }
        }
    }
    public static void efficientSolution(int[] a, int[] b, int n, int m) {
        int i = 0;
        int j = 0;
        while(i < n && j < m) {
            if(i > 0 && a[i] == a[i-1]) {
                i++;
                continue;
            }
            if(a[i] < b[j]) i++;
            else if(a[i] > b[j]) j++;
            else if(a[i] == b[j]) {
                System.out.println(a[i]);
                i++;
                j++;
            }
        }
    }
}
