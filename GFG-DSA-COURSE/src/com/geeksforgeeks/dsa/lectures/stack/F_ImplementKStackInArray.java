/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Arrays;

public class F_ImplementKStackInArray {
    int[] arr;
    int[] top;
    int[] next;
    int free_top = 0;
    int capacity;
    int k;
    public F_ImplementKStackInArray(int capacity, int k) {
        this.k = k;
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.next = new int[capacity];
        this.top = new int[k];
        Arrays.fill(top,-1);
        // example, k = 3 (3 stacks).
        // top[] = {-1,-1,-1}
        // next[] = {1,2,3,4,5,6,7,8,9,-1}
        for (int i = 0; i < capacity-1; i++) {
            next[i] = i+1;
        }
        next[capacity-1] = -1;
    }
    void push(int stack, int x) {
        /**
         * k = 2
         * capacity = 5
         * arr = []
         * top = [-1,-1]
         * next = [1,2,3,4,-1]
         * free_top = 0
         *
         * push(1,100)
         * i = 0
         * free_top = 1 --> free top changed to next free index
         * next[0] = -1 --> {-1,2,3,4,-1}
         * top[1] = 0 --> {-1,0}
         * arr[0] = 100 --> {100,_,_,_,_}
         * */
        int i = free_top; // get free top
        free_top = next[i]; // change free top for next push
        next[i] = top[stack]; // it denotes -1, which means the pos is occupied
        top[stack] = i; // it denotes the top idx of each stack, top --> {-1,0}
        arr[i] = x;
    }
    public int pop(int stack) {
        try {
            int i = top[stack]; // get the top value of the stack --> eg. {-1,0}
            top[stack] = next[i]; // change top value of the stack using i'th value of next --> {-1,2,3,4,-1}
            // now after changing top --> {-1,-1}
            next[i] = free_top; // next --> {1,2,3,4,-1}, because free_top = 1
            free_top = i; // now free_top back to 0
            return arr[i];
        } catch (Exception e) {
            return -1;
        }
    }
    boolean isEmpty(int stack) {
        return top[stack] == -1;
    }
    public static void main(String[] args) {
        F_ImplementKStackInArray stack = new F_ImplementKStackInArray(5,2);
        stack.push(1,100);
        stack.push(1,200);
        System.out.println(Arrays.toString(stack.arr));
        System.out.println("isEmpty(0) : " + stack.isEmpty(0));
        System.out.println("isEmpty(1) : " + stack.isEmpty(1));
        System.out.println("pop(0) : " + stack.pop(0));
        System.out.println("pop(1) : " + stack.pop(1));
        System.out.println("pop(1) : " + stack.pop(1));
    }
}
