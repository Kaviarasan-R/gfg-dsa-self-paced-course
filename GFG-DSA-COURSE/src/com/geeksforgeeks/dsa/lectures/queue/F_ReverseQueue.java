/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class F_ReverseQueue {
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        queue.offer(10);
        queue.offer(5);
        queue.offer(15);
        queue.offer(20);
        //iterativeSolution(queue);
        recursiveSolution(queue);
        System.out.println(queue);
    }
    public static void iterativeSolution(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        System.out.println(queue);
    }
    public static void recursiveSolution(Queue<Integer> queue) {
        if(queue.isEmpty()) return;
        int x = queue.poll();
        recursiveSolution(queue);
        queue.offer(x);
    }
}
