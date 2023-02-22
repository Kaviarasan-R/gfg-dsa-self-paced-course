/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class C_PriorityQueue {
    public static void main(String[] args) {
        minHeap();
        maxHeap();
    }
    public static void minHeap() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(15);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());
    }
    public static void maxHeap() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(15);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.peek());
    }
}
