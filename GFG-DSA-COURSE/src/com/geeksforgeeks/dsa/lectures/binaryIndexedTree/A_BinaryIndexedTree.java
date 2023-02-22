/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binaryIndexedTree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A_BinaryIndexedTree {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90,100,110};
        int n = arr.length;
        int[] BIT = new int[n+1];
        constructBIT(arr,BIT,n);
        System.out.println("BINARY INDEX TREE : " + Arrays.toString(BIT));
        System.out.println("GET SUM : " + getSum(BIT,2));
        int index = 2;
        int diff = 35 - arr[index];
        update(arr,BIT,index,diff,n);
        System.out.println("UPDATE : " + Arrays.toString(BIT));
        System.out.println("GET SUM : " + getSum(BIT,2));
    }
    public static void constructBIT(int[] arr, int[] BIT, int n) {
        for (int i = 0; i < n; i++) {
            update(arr,BIT,i,arr[i],n);
        }
    }
    public static void update(int[] arr, int[] BIT, int i, int x, int n) {
        arr[i] = x;
        i = i + 1;
        while(i <= n) {
            BIT[i] += x;
            i = i + (i & -i);
        }
    }
    public static int getSum(int[] BIT, int i) {
        i = i + 1;
        int res = 0;
        while(i > 0) {
            res += BIT[i];
            i = i - (i & -i);
        }
        return res;
    }
}
