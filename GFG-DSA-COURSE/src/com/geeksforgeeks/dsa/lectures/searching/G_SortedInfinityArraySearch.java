/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class G_SortedInfinityArraySearch {
    public static void main(String[] args) {
        int[] arr = {1,10,15,20,40,50,90,100,120,500};
        int x = 100;
        System.out.println(naiveSolution(arr,x));
        System.out.println(efficientSolution(arr,x));
    }
    public static int naiveSolution(int[] arr, int x) {
        // Theta ( POS )
        int i = 0;
        while(true) {
            if(arr[i] == x) return i;
            if(arr[i] > x) return -1;
            i++;
        }
    }
    public static int efficientSolution(int[] arr, int x) {
        // Unbounded Binary Search -> O ( LOG (POS) )
        if(arr[0] == x) return 0;
        int i = 1;
        while(arr[i] < x) {
            i = i * 2;
        }
        if(arr[i] == x) return i;
        return A_BinarySearch.binarySearchRecursive(arr,(i / 2) + 1, i-1, x);
    }
}
