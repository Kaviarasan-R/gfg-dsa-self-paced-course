/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class D_CountOccurences {
    public static void main(String[] args) {
        int[] arr = {10,20,20,20,30,30};
        int x = 20;
        int n = arr.length - 1;
        System.out.println(naiveSolution(arr,n,x));
    }
    public static int naiveSolution(int[] arr, int n, int x) {
        // Subtracting last by first and then add 1 to prevent zeros.
        int first = B_IndexFirstOccurence.efficientSolution(arr,x);
        if(first == -1) return 0;
        else return (C_IndexLastOccurence.naiveSolution(arr,0,n,x) - first + 1);
    }
}
