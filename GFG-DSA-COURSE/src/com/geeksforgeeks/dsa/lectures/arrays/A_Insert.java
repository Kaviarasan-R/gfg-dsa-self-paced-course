/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

import javax.lang.model.type.NullType;
import java.util.Arrays;

public class A_Insert {
    public static void main(String[] args) {
        /**
         * [] ={5,7,10,20,_}
         * x = 3
         * pos = 2
         * capacity = 5
         * n = 4
         * OP : {5,3,7,10,20}
         * */
        int[] arr = {5,7,10,20,0};
        System.out.println(insert(arr,4,3,5,2));
    }
    public static int insert(int[] arr, int n, int x, int capacity, int position) {
        if(n == capacity) return n; //check for if there is any space left
        int idx = position-1;
        /**
         * idx = 1
         * i=3: [] -> {5,7,10,_,20}
         * i=2: [] -> {5,7,_,10,20}
         * i=1: [] -> {5,_,7,10,20}
         * arr[idx] = 3
         * [] -> {5,3,7,10,20}
         * */
        for (int i = n-1; i >= idx ; i--) { //traverse from right to left
            arr[i+1] = arr[i];
        }
        arr[idx] = x;
        System.out.println(Arrays.toString(arr));
        return (n+1);
    }
}
