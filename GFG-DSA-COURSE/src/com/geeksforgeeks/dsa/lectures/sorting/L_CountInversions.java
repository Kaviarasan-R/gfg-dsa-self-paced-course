/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

public class L_CountInversions {
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        // (4,1) (4,3) (2,1)
        naiveSolution(arr,arr.length);
        System.out.println(efficientSolution(arr,0,arr.length-1));
    }
    public static void naiveSolution(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < (n-1); i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] > arr[j]) res++;
            }
        }
        System.out.println(res);
    }
    public static int efficientSolution(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            res += efficientSolution(arr,l,m);
            res += efficientSolution(arr,m+1,r);
            res += countAndMerge(arr,l,m,r);
        }
        return res;
    }
    private static int countAndMerge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low+i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid+i+1];
        }
        int res = 0;
        int i = 0;
        int j = 0;
        int k = low;
        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                //res++;
                res += n1 - i;
                j++;
            }
            k++;
        }
        while(i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return res;
    }
}
