/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Arrays;

public class E_ImplementTwoStackInArray {
    int[] arr;
    int capacity;
    int top1;
    int top2;
    public E_ImplementTwoStackInArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.top1 = -1;
        this.top2 = this.arr.length;
    }

    boolean push1(int x) {
        if(top1 < top2-1) {
            this.top1++;
            this.arr[this.top1] = x;
            return true;
        }
        return false;
    }
    boolean push2(int x) {
        if(top1 < top2-1) {
            this.top2--;
            this.arr[this.top2] = x;
            return true;
        }
        return false;
    }
    int pop1() {
        if(top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        return -1;
    }
    int pop2() {
        if(top2 < capacity) {
            int x = arr[top2];
            top2++;
            return x;
        }
        return -1;
    }
    int size1() {
        return this.top1 + 1;
    }
    int size2() {
        return this.capacity - this.top1;
    }

    public static void main(String[] args) {
        E_ImplementTwoStackInArray stack = new E_ImplementTwoStackInArray(10);
        stack.push1(10);
        stack.push1(20);
        stack.push1(30);
        stack.push1(40);
        stack.push1(50);
        stack.push1(60);
        stack.push2(100);
        stack.push2(90);
        stack.push2(80);
        stack.push2(70);
        System.out.println(Arrays.toString(stack.arr));
        System.out.println(stack.size1());
        System.out.println(stack.size2());
    }
}
