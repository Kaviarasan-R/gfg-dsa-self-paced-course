/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.heap;

import java.util.PriorityQueue;

public class E_BuyMaxItemsWithGivenSum {
    public static void main(String[] args) {
        // count maximum items that we can purchase with the given sum.
        int sum = 10;
        int res = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(1);
        minHeap.add(12);
        minHeap.add(5);
        minHeap.add(111);
        minHeap.add(200);
        while(minHeap.peek() <= sum) {
            sum -= minHeap.poll();
            res++;
        }
        System.out.println(res);
    }
}
