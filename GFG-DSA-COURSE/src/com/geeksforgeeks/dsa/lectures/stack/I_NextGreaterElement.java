/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Stack;

public class I_NextGreaterElement {
    public static void main(String[] args) {
        /**
         * next closest greater element on right side
         * output : 15,18,12,12,12,18,18,-1
         * */
        int[] arr = {5,15,10,8,6,12,9,18};
        naiveSolution(arr,arr.length);
        System.out.println();
        efficientSolution(arr,arr.length);
    }
    public static void naiveSolution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int j;
            for (j = i; j < n; j++) {
                if(arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
            if(j == n) System.out.print(-1 + " ");
        }
    }

    /** prints in reverse order */
    public static void efficientSolution(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);
        for (int i = n-2; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            int next_greater = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(next_greater + " ");
            stack.push(arr[i]);
        }
        System.out.print(-1);
    }
}
