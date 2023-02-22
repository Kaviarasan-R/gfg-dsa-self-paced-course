/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static com.geeksforgeeks.dsa.lectures.dynamicProgramming.F_LongestIncreasingSubsequence.ceilIdx;

public class G_VariationsOfLIS {
    public static void main(String[] args) {
        int[] arr1 = {5,10,3,6,7,8};
        int n1 = arr1.length;
        int[] arr2 = {3,20,4,6,7,30};
        int n2 = arr2.length;
        int[] arr3 = {1,11,2,10,4,5,2,1};
        int n3 = arr3.length;
        System.out.println("MINIMUM DELETIONS TO MAKE AN ARRAY SORTED : " + arraySort(arr1,n1));
        System.out.println("-------------------------------------------------");
        System.out.println("MAXIMUM SUM INCREASING SUBSEQUENCE : " + increasingSubsequence(arr2,n2));
        System.out.println("-------------------------------------------------");
        System.out.println("MAXIMUM LENGTH BITONIC SUBSEQUENCE : " + bitonic(arr3,n3));
        System.out.println("-------------------------------------------------");
        System.out.println("BUILDING BRIDGES : " + buildingBridges());
        System.out.println("-------------------------------------------------");
        System.out.println("LONGEST CHAINS OF PAIRS : " + longestChains());
    }
    // MINIMUM DELETIONS TO MAKE AN ARRAY SORTED
    public static int arraySort(int[] arr, int n) {
        int[] lis = new int[n];
        lis[0] = arr[0];
        int index = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] > lis[index-1]) {
                lis[index] = arr[i];
                index++;
            }
            else {
                int idx = ceilIdx(lis,0,index-1,arr[i]);
                lis[idx] = arr[i];
            }
        }
        return n-index;
    }
    // MAXIMUM SUM INCREASING SUBSEQUENCE
    public static int increasingSubsequence(int[] arr, int n) {
        int[] msis = new int[n];
        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    // GETTING MAX OF ``CURR MSIS VALUE`` && ``CURR ARR I VALUE + CURR MSIS J VALUE``
                    msis[i] = Math.max(msis[i],arr[i]+msis[j]);
                }
            }
        }
        System.out.println("MSIS : " + Arrays.toString(msis));
        int res = msis[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res,msis[i]);
        }
        return res;
    }
    // MAXIMUM LENGTH BITONIC SUBSEQUENCE
    public static int bitonic(int[] arr, int n) {
        int i, j;
        /* Allocate memory for LIS[] and initialize LIS values as 1 for
            all indexes */
        int[] lis = new int[n];
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }
        /* Compute LIS values from left to right */
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        /* Allocate memory for lds and initialize LDS values for
            all indexes */
        int[] lds = new int [n];
        for (i = 0; i < n; i++) {
            lds[i] = 1;
        }
        /* Compute LDS values from right to left */
        for (i = n-2; i >= 0; i--) {
            for (j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        /* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = lis[0] + lds[0] - 1;
        for (i = 1; i < n; i++) {
            int i1 = lis[i] + lds[i] - 1;
            if (i1 > max) {
                max = i1;
            }
        }
        System.out.println("LIS : " + Arrays.toString(lis));
        System.out.println("LDS : " + Arrays.toString(lds));
        return max;
    }
    // BUILDING BRIDGES
    public static int buildingBridges() {
        ArrayList<Pair> arr = new ArrayList<>();
        arr.add(new Pair(6,2));
        arr.add(new Pair(4,3));
        arr.add(new Pair(2,6));
        arr.add(new Pair(1,5));
        arr.add(new Pair(1,3));
        Collections.sort(arr, new PairComparator());
        int[] lis = new int[arr.size()];
        int idx = 0;
        System.out.print("PAIRS : ");
        for (Pair pair : arr) {
            lis[idx] = pair.y;
            System.out.print("{ " + pair.x + "," + pair.y + " } ");
            idx++;
        }
        System.out.println();
        return F_LongestIncreasingSubsequence.efficientSolution(lis,lis.length);
    }
    // LONGEST CHAINS OF PAIRS
    public static int longestChains() {
        ArrayList<Pair> arr = new ArrayList<>();
        arr.add(new Pair(5,24));
        arr.add(new Pair(39,60));
        arr.add(new Pair(15,28));
        arr.add(new Pair(27,40));
        arr.add(new Pair(50,90));
        Collections.sort(arr, new PairComparator());
        System.out.print("PAIRS : ");
        for (Pair pair : arr) {
            System.out.print("{ " + pair.x + "," + pair.y + " } ");
        }
        System.out.println();
        int i, j, max = 0;
        int lis[] = new int[arr.size()];
        /* Initialize LIS values for all indexes */
        for (i = 0; i < arr.size(); i++) {
            lis[i] = 1;
        }
        /* Compute optimized chain length values in bottom up manner */
        for (i = 1; i < arr.size(); i++) {
            for (j = 0; j < i; j++) {
                if (arr.get(i).x > arr.get(j).y && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        /* Getting MAX value */
        for (i = 0; i < arr.size(); i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            // IF X BECOMES SAME, THEN SORT ACCORDING TO Y.
            return (p1.x - p2.x) == 0 ? (p1.y - p2.y) : (p1.x - p2.x);
        }
    }
}
