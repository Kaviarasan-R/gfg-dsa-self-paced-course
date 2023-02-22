/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.queue;

import java.util.Arrays;

/**
 * O (n) time complexity
 */
public class A_ArrayQueueNaive {
    int size;
    int capacity;
    int[] arr;

    public A_ArrayQueueNaive(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        arr = new int[capacity];
    }

    void enqueue(int x) {
        if(isFull()) return;
        this.arr[this.size] = x;
        this.size++;
    }

    void dequeue() {
        if(isEmpty()) return;
        for (int i = 0; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
    }

    int getFront() {
        if(isEmpty()) return -1;
        else return this.arr[0];
    }

    int getRear() {
        if(isEmpty()) return -1;
        else return this.arr[this.size-1];
    }

    boolean isFull() {
        return this.size == this.capacity;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    int size() {
        return this.size;
    }

    public static void main(String[] args) {
        A_ArrayQueueNaive queue = new A_ArrayQueueNaive(10);
        queue.enqueue(5);
        queue.enqueue(16);
        queue.enqueue(19);
        queue.dequeue();
        System.out.println("array : " + Arrays.toString(queue.arr));
        System.out.println("front : " + queue.getFront());
        System.out.println("rear : " + queue.getRear());
        System.out.println("size : " + queue.size());
        System.out.println("empty : " + queue.isEmpty());
        System.out.println("full : " + queue.isFull());
    }
}
