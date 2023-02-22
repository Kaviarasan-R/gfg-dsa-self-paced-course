/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Stack;

public class H_PreviousGreaterElement {
    public static void main(String[] args) {
        /**
         * previous closest greater element
         * OP : -1,15,-1,18,12,12,6,12
         * */
        int[] arr = {15,10,18,12,4,6,2,8};
        naiveSolution1(arr,arr.length);
        System.out.println();
        naiveSolution2(arr,arr.length);
        System.out.println();
        efficientSolution(arr,arr.length);
    }
    public static void naiveSolution1(int[] arr, int n) {
        if(n >= 1) System.out.print(-1 + " ");
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                } else if(j == 0 && !(arr[j] > arr[i])) {
                    System.out.print(-1 + " ");
                }
            }
        }
    }
    public static void naiveSolution2(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int j;
            for (j = i-1; j >= 0; j--) {
                if(arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
            if(j == -1) System.out.print(-1 + " ");
        }
    }
    public static void efficientSolution(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        System.out.print(-1 + " ");
        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            int prev_greater = (stack.isEmpty()) ? -1 : stack.peek();
            System.out.print(prev_greater + " ");
            stack.push(arr[i]);
        }
    }
}
