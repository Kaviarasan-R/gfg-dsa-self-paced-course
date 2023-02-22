/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class L_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {10,20,30,40,50};
        int[] arr2 = {5,15,25,35,45,55,65,75,85};
//        int[] arr1 = {5,10};
//        int[] arr2 = {15,20,25};
        System.out.println(naiveSolution(arr1,arr2,arr1.length-1,arr2.length-1));
    }
    public static int naiveSolution(int[] arr1, int[] arr2, int n1, int n2) {
        int l1 = 0;
        int h1 = n1;
        while(l1 <= h1) {
            int i1 = (l1 + h1) / 2; // mid for array1
            int i2 = ((n1+n2 + 1) / 2) - i1; // mid for array2
            int mnR1 = (i1 == n1) ? Integer.MAX_VALUE : arr1[i1]; //right for array 1
            int mxL1 = (i1 == 0) ? Integer.MIN_VALUE : arr1[i1 - 1]; //left for array 1
            int mnR2 = arr2[i2]; // right for array 2
            int mxL2 = arr2[i2 - 1]; // left for array 2
            if(mxL1 <= mnR2 && mxL2 <= mnR1) {
                return ((Math.max(mxL1,mxL2) + Math.min(mnR1,mnR2)) / 2);
            } else if (mxL1 > mnR2) {
                h1 = i1 - 1;
            } else if (mxL2 > mnR1) {
                l1 = i1 + 1;
            } else {
                return Math.max(mxL1,mxL2);
            }
        }
        return -1;
    }
}
