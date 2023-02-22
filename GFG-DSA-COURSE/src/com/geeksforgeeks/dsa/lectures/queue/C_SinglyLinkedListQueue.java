/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.queue;

import com.geeksforgeeks.dsa.lectures.stack.B_LinkedListStack;

public class C_SinglyLinkedListQueue {
    Node front;
    Node rear;
    int size;

    C_SinglyLinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    void enqueue(int x) {
        Node temp = new Node(x);
        size++;
        if(front == null) {
            front = temp;
            rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    void dequeue() {
        if(front == null) return;
        size--;
        front = front.next;
        if(front == null) rear = null;
    }
    void print() {
        C_SinglyLinkedListQueue.Node temp = this.front;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if(temp != null) System.out.print(" -> ");
        }
    }
    public static void main(String[] args) {
        C_SinglyLinkedListQueue queue = new C_SinglyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        //queue.dequeue();
        System.out.println("\nfront : " + queue.front.data);
        System.out.println("rear : " + queue.rear.data);
        System.out.println("size : " + queue.size);
    }
    class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
}
