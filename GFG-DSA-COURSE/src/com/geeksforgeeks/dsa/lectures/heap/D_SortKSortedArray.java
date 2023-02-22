/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class D_SortKSortedArray {
    public static void main(String[] args) {
        int[] arr = {9,8,7,18,19,17};
        int k = 2;
        // An element at index i will be present between the indexes i-k to i+k in sorted array.
        minHeap(arr,k);
    }
    public static void minHeap(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // copy elements up to k from array to heap.
        for (int i = 0; i <= k; i++) {
            priorityQueue.add(arr[i]);
        }
        int index = 0;
        // from k+1, remove min from heap and replace in array, at the same time add nodes.
        for (int i = k+1; i < arr.length; i++) {
            arr[index++] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
        // remove min from heap and replace in array at continuous index.
        while(priorityQueue.isEmpty() == false) {
            arr[index++] = priorityQueue.poll();
        }
        System.out.println(Arrays.toString(arr));
    }
}
