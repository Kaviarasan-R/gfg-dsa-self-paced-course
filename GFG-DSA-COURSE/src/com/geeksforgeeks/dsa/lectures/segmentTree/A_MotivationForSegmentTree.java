/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.segmentTree;

public class A_MotivationForSegmentTree {
    /* THESE IMPLEMENTATIONS COST Theta(n) TIME */
    public static void main(String[] args) {

        /* METHOD 1 */
        int[] arr1 = {10,20,30,40,50};
        System.out.println("METHOD 1 : ");
        System.out.print(getSumMethod1(arr1,0,2) + " " + getSumMethod1(arr1,1,3) + " ");
        updateMethod1(arr1,1,60);
        System.out.print(getSumMethod1(arr1,0,2) + " " + getSumMethod1(arr1,1,3));

        /* METHOD 2 USING PREFIX SUM */
        int[] arr2 = {10,20,30,40,50};
        int[] pre_sum = new int[arr2.length];
        pre_sum[0] = arr2[0];
        for (int i = 1; i < arr2.length; i++) {
            pre_sum[i] = pre_sum[i-1] + arr2[i];
        }
        System.out.println("\nMETHOD 2 : ");
        System.out.print(getSumMethod2(arr2,pre_sum,0,2) + " " + getSumMethod2(arr2,pre_sum,1,3) + " ");
        updateMethod2(arr2,pre_sum,1,60);
        System.out.print(getSumMethod2(arr2,pre_sum,0,2) + " " + getSumMethod2(arr1,pre_sum,1,3));
    }
    /* METHOD 1 */
    public static int getSumMethod1(int[] arr, int s, int e) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static void updateMethod1(int[] arr, int i, int value) {
        arr[i] = value;
    }
    /* METHOD 2 */
    public static int getSumMethod2(int[] arr, int[] pre_sum, int s, int e) {
        if(s == 0) return pre_sum[e];
        else return (pre_sum[e] - pre_sum[s-1]);
    }
    public static void updateMethod2(int[] arr, int[] pre_sum, int i, int value) {
        int diff = value - arr[i];
        for (int j = i; j < arr.length; j++) {
            pre_sum[j] += diff;
        }
    }
}
