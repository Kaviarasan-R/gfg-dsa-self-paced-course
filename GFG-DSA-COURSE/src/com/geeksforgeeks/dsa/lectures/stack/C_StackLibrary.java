/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class C_StackLibrary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> arrayDequeStack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("stack : " + stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        arrayDequeStack.push(10);
        arrayDequeStack.push(20);
        arrayDequeStack.push(30);
        System.out.println("array deque stack : " + arrayDequeStack);
        System.out.println(arrayDequeStack.peek());
        System.out.println(arrayDequeStack.pop());
        System.out.println(arrayDequeStack.peek());
    }
}
