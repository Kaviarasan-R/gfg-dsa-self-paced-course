/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class D_QueueLibrary {
    public static void main(String[] args) {
        Queue<Integer> linkedListQueue = new LinkedList<>();
        Queue<Integer> arrayQueue = new ArrayDeque<>();
        arrayQueue.offer(10); // alternative add() throws exception
        arrayQueue.offer(20);
        arrayQueue.offer(30);
        System.out.println(arrayQueue.peek()); // alternative element() throws exception
        System.out.println(arrayQueue.poll()); // alternative remove() throws exception
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue);
    }
}
