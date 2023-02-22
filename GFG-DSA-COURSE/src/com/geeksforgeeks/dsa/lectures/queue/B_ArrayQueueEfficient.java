package com.geeksforgeeks.dsa.lectures.queue;
/**
 * Created By Kavi Arasan
 */

import java.util.Arrays;

/**
 * O (1) time complexity
 * implementation of circular array
 * */

public class B_ArrayQueueEfficient {
    int size;
    int capacity;
    int front;
    int[] arr;

    public B_ArrayQueueEfficient(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        arr = new int[capacity];
    }

    void enqueue(int x) {
        if(isFull()) return;
        // calculate rear to insert
        int rear = getRear();
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    void dequeue() {
        if(isEmpty()) return;
        // calculate new front
        this.front = (this.front + 1) % this.capacity;
        size--;
    }

    int getFront() {
        if(isEmpty()) return -1;
        else return this.front;
    }

    int getRear() {
        if(isEmpty()) return -1;
        else return (this.front + this.size - 1) % this.capacity;
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
        B_ArrayQueueEfficient queue = new B_ArrayQueueEfficient(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        System.out.println("array : " + Arrays.toString(queue.arr));
        System.out.println("front : " + queue.getFront());
        System.out.println("rear : " + queue.getRear());
        System.out.println("size : " + queue.size());
        System.out.println("empty : " + queue.isEmpty());
        System.out.println("full : " + queue.isFull());
    }
}
