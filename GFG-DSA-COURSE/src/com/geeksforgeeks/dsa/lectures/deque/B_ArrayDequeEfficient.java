/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.deque;

import java.util.Arrays;

public class B_ArrayDequeEfficient {
    int size;
    int capacity;
    int[] arr;
    int front;

    public B_ArrayDequeEfficient(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.front = 0;
        this.arr = new int[capacity];
    }
    boolean isFull() {
        return size == capacity;
    }
    boolean isEmpty() {
        return size == 0;
    }
    void insertFront(int x) {
        if(isFull()) return;
        front = (front + capacity - 1) % capacity;
        arr[front] = x;
        size++;
    }
    void deleteFront() {
        if(isEmpty()) return;
        front = (front + 1) % capacity;
        size--;
    }
    int getFront() {
        if(isEmpty()) return -1;
        else return arr[front];
    }
    void insertRear(int x) {
        if(isFull()) return;
        int rear = (front + size) % capacity;
        arr[rear] = x;
        size++;
    }
    void deleteRear() {
        if(isEmpty()) return;
        size--;
    }
    int getRear() {
        if(isEmpty()) return -1;
        else return arr[(front + size - 1) % capacity];
    }
    public static void main(String[] args) {
        B_ArrayDequeEfficient deque = new B_ArrayDequeEfficient(4);
        deque.insertFront(10);
        deque.insertRear(20);
        deque.insertFront(5);
        deque.insertRear(15);
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        deque.deleteFront();
        deque.deleteRear();
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        System.out.println(Arrays.toString(deque.arr));
    }
}
