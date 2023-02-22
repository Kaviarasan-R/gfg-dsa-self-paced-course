/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Stack;

public class G_StockSpan {
    public static void main(String[] args) {
        /**
         * number of consecutive days which have values smaller or equal to current days.
         * op : 1,2,1,2,5,1,1,1,4,10
         * 0 : 1 (always first index will be 0)
         * 1 : 2 (13 <= 15)
         * 2 : 1 (13 and 15 should <= 12)
         * 3 : 2 (only 12 and 14 smaller than equal to current value {14})
         * ...
         * */
        int[] arr = {13,15,12,14,16,8,6,4,10,30};
        int n = arr.length;
        naiveSolution(arr,n);
        System.out.println();
        efficientSolution(arr,n);
    }
    public static void naiveSolution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int span = 1;
            for (int j = i-1; j >= 0 && (arr[j] <= arr[i]); j--) {
                span++;
            }
            System.out.print(span + " ");
        }
    }
    public static void efficientSolution(int[] arr, int n) {
        /**
         * arr[] = {60,10,20,40,35,30,50,70,65}
         * if(greater on left side compare to current element) {
         *      span = idx of current ele - idx of closest greater ele
         * } else {
         *      span = idx of current ele + 1
         * }
         * we can do this approach also in O(n * n)
         * */
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // pushing idx of array
        System.out.print(1 + " ");
        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            /**
             * in while loop, pop out the stack elements if peek is smaller than current.
             * if stack is empty then current element is greater than all previous element (current+1)
             * else the current element has closest greater element (current-peek())
             */
            int span = stack.isEmpty() ? i+1 : i-stack.peek();
            System.out.print(span+ " ");
            stack.push(i);
        }
    }
}
