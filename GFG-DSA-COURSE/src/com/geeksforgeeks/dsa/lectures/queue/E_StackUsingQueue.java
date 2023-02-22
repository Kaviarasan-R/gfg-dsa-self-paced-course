/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Question variations on " Implementation of stack using queue "
 * 1. Implement stack using queue by making pop operation only
 * 2. Implement stack using only one queue (use recursion call stack here)
 * 3. Implement queue using stack.
 *      3.1. By making enqueue() operation only
 *      3.2  By making dequeue() operation only
 *      3.3  By using one stack (And one recursion call stack)
 * */

public class E_StackUsingQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public E_StackUsingQueue() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        E_StackUsingQueue stack = new E_StackUsingQueue();
        stack.push(10);
        stack.push(5);
        stack.push(15);
        System.out.println("stack : " + stack.queue1);
        System.out.println("size : " + stack.size());
        System.out.println("top : " + stack.top());
        System.out.println("pop : " + stack.pop());
        System.out.println("stack : " + stack.queue1);
    }
    int top() {
        return this.queue1.peek();
    }
    void push(int x) {
        // copy all elements from queue 1 to queue 2
        while(!this.queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        queue1.offer(x);
        // copy all elements back from queue 2 to queue 1
        while(!this.queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
    }
    int pop() {
        return this.queue1.poll();
    }
    int size() {
        return this.queue1.size();
    }
}
