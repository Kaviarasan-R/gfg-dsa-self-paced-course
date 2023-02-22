/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import com.geeksforgeeks.dsa.lectures.queue.C_SinglyLinkedListQueue;

import java.util.Arrays;

public class B_LinkedListStack {
    Node head;
    int size;
    public B_LinkedListStack() {
        head = null;
        size = 0;
    }
    int size() {
        return size;
    }
    boolean isEmpty() {
        return (head == null);
    }
    void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }
    int pop() {
        if(head == null) {
            return Integer.MAX_VALUE;
        }
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }
    int peek() {
        if(head == null) {
            return Integer.MAX_VALUE;
        }
        return head.data;
    }
    void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if(temp != null) System.out.print(" -> ");
        }
    }
    public static void main(String[] args) {
        B_LinkedListStack stack = new B_LinkedListStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("peek : " + stack.peek());
        System.out.println("size : " + stack.size);
        System.out.println("isEmpty : " + stack.isEmpty());
        System.out.println("pop : " + stack.pop());
        System.out.println("after pop, peek : " + stack.peek());
        System.out.println("after pop, size : " + stack.size);
        stack.print();
    }
    class Node {
        int data;
        B_LinkedListStack.Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
}
