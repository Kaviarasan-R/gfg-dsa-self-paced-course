/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.ArrayList;
import java.util.Arrays;

public class A_ArrayStack {
    ArrayList<Integer> dynamicArray = new ArrayList<>();
    int arr[];
    int capacity;
    int top;
    public A_ArrayStack(int capacity) {
        this.arr = new int[capacity];
        this.top = -1;
        this.capacity = capacity;
    }
    void push(int x) {
        /** Dynamic array implementation */
        this.dynamicArray.add(x);
        /** Static array implementation */
        if(top == capacity-1) return;
        top++;
        arr[top] = x;
    }
    int pop() {
        /** Dynamic array implementation */
        int dynamicRes = this.dynamicArray.get(this.dynamicArray.size()-1);
        this.dynamicArray.remove(this.dynamicArray.size()-1);
        /** Static array implementation */
        if(top == -1) {
            return -1;
        }
        int staticRes = arr[top];
        top--;
        return dynamicRes;
    }
    int peek() {
        /** Static array implementation */
        int res = arr[top];
        /** Dynamic array implementation */
        return this.dynamicArray.get(this.dynamicArray.size()-1);
    }
    int size() {
        /** Dynamic array implementation */
        int res = this.dynamicArray.size();
        /** Static array implementation */
        return top + 1;
    }
    boolean isEmpty() {
        /** Dynamic array implementation */
        boolean res = this.dynamicArray.isEmpty();
        /** Static array implementation */
        return (top == -1);
    }
    public static void main(String[] args) {
        A_ArrayStack stack = new A_ArrayStack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("static array : " + Arrays.toString(stack.arr));
        System.out.println("dynamic array : " + Arrays.toString(stack.dynamicArray.toArray()));
        System.out.println("top : " + stack.top);
        System.out.println("pop : " + stack.pop());
        System.out.println("size : " + stack.size());
        System.out.println("isEmpty : " + stack.isEmpty());
    }
}
