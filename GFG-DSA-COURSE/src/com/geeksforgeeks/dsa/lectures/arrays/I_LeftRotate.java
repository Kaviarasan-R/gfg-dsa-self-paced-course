/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

import java.util.Arrays;

public class I_LeftRotate {
    public static void main(String[] args) {
        /**
         * LEFT ROTATE BY ONE :
         * [] -> {1,2,3,4,5}
         * OP : {2,3,4,5,1}
         * */
        int[] arr1 = {1,2,3,4,5};
        System.out.println(Arrays.toString(leftRotateByOneMethod1(arr1)));
        int[] arr2 = {1,2,3,4,5};
        leftRotateByOneMethod2(arr2);
        /**
         * [] -> {1,2,3,4,5}
         * D = 2
         * OP : {3,4,5,1,2}
         * */
        int[] arr3 = {1,2,3,4,5};
        leftRotateByDMethod1(arr3,2);
        int[] arr4 = {1,2,3,4,5};
        leftRotateByDMethod2(arr4,2);
        int[] arr5 = {1,2,3,4,5};
        leftRotateByDMethod3(arr5,3);

    }

    // LEFT ROTATE BY ONE METHOD 1
    public static int[] leftRotateByOneMethod1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    // LEFT ROTATE BY ONE METHOD 2
    public static void leftRotateByOneMethod2(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
        System.out.println(Arrays.toString(arr));
    }
    // LEFT ROTATE BY D METHOD 1
    public static void leftRotateByDMethod1(int[] arr, int d) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < d; i++) {
            int[] returnArray = leftRotateByOneMethod1(arr);
            System.arraycopy(returnArray,0,temp,0,arr.length);
        }
        System.out.println(Arrays.toString(temp));
    }
    // LEFT ROTATE BY D METHOD 2
    public static void leftRotateByDMethod2(int[] arr, int d) {
        int[] temp = new int[d];
        // temp[] = {1,2}
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        // arr[] = {3,4,5,4,5}
        for (int i = d; i < arr.length; i++) {
            arr[i-d] = arr[i];
        }
        // arr[] = {3,4,5,1,2}
        for (int i = 0; i < d; i++) {
            arr[arr.length-d+i] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }
    // LEFT ROTATE BY D METHOD 3
    public static void leftRotateByDMethod3(int[] arr, int d ) {
        arr = reverse(arr,0,d-1); // [1,2] -> [2,1]
        arr = reverse(arr,d,arr.length-1); // [3,4,5] -> [5,4,3]
        // arr[] = [2,1,5,4,3]
        arr = reverse(arr,0,arr.length-1); // [3,4,5,1,2]
        System.out.println(Arrays.toString(arr));
    }
    public static int[] reverse(int[] arr, int low, int high) {
        while(low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }

}
