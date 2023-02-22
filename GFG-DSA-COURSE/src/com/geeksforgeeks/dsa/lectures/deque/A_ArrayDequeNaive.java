/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.deque;

import java.util.Arrays;
/**
 * Circular array implementation
 * */

public class A_ArrayDequeNaive {
    int size;
    int capacity;
    int[] arr;
    public A_ArrayDequeNaive(int capacity) {
        this.size = 0;
        this.capacity = capacity;
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
        for (int i = size-1; i >= 0; i--) {
            arr[i+1] = arr[i];
        }
        arr[0] = x;
        size++;
    }
    void deleteFront() {
        if(isEmpty()) return;
        for (int i = 0; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
    }
    int getFront() {
        if(isEmpty()) return -1;
        else return arr[0];
    }
    void insertRear(int x) {
        if(isFull()) return;
        arr[size] = x;
        size++;
    }
    void deleteRear() {
        if(isEmpty()) return;
        size--;
    }
    int getRear() {
        if(isEmpty()) return -1;
        else return arr[size-1];
    }
    public static void main(String[] args) {
        A_ArrayDequeNaive deque = new A_ArrayDequeNaive(4);
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
