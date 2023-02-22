/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class F_KLargestElements {
    public static void main(String[] args) {
        int[] arr = {5,15,10,20,8,25,18};
        int k = 3;
        // output : 18 25 20
        efficientSolution(arr,k);
    }
    public static void efficientSolution(int[] arr, int k) {
        /**
         * Build a min heap of first k elements
         * Traverse from (k+1)th element
         *      (a) compare current element with top of heap, If smaller than top, ignore it.
         *      (b) else remove the top element and insert the current element in the min heap.
         * Print contents of the min heap
         * Time complexity :
         * Max Heap : O (n + k logn) --> naive solution
         * Min Heap : O (k + (n-k) logk) --> efficient solution
         **/
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(arr[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        System.out.println(Arrays.toString(priorityQueue.toArray()));
    }
}
