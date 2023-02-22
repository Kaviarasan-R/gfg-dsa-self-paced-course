/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.deque;

import java.util.Deque;
import java.util.LinkedList;

public class D_MaxOfAllSubarraysSizeK {
    public static void main(String[] args) {
        int[] arr = {10,8,5,12,15,7,6};
        int k = 3;
        /**
         * {10,8,5} --> 10
         * {8,5,12} --> 12
         * {5,12,15} --> 15
         * {12,15,7} --> 15
         * {15,7,6} --> 15
         * */
        naiveSolution(arr,k);
        System.out.println();
        efficientSolution(arr,k);
    }
    public static void naiveSolution(int[] arr, int k) {
        for (int i = 0; i < arr.length-k+1; i++) {
            int max = arr[i];
            for (int j = i+1; j < i+k; j++) {
                max = Math.max(max,arr[j]);
            }
            System.out.print(max + " ");
        }
    }
    public static void efficientSolution(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> deque = new LinkedList<>();
        // Remove elements from last if current element is greater than all elements in deque.
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = k; i < n; i++) {
            System.out.print(arr[deque.peek()] + " ");
            // Remove first element if the length of k sized deque is full
            while(!deque.isEmpty() && deque.peek() <= i-k) {
                deque.removeFirst();
            }
            // Remove elements from last if current element is greater than all elements in deque.
            while(!deque.isEmpty() && arr[i] > arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        System.out.print(arr[deque.peek()] + " ");
    }
}
