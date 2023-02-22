/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

import java.util.HashMap;

public class R_CloneRandomConnections {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(5);
        Node temp2 = new Node(20);
        Node temp3 = new Node(15);
        Node temp4 = new Node(20);
        // next connections
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        // random connections
        head.random = temp2;
        temp1.random = temp3;
        temp2.random = head;
        temp3.random = temp2;
        temp4.random = temp3;

        System.out.println(naiveSolution(head).data);
        System.out.println(efficientSolution(head).data);
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static Node naiveSolution(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        for(Node curr = head; curr != null; curr = curr.next) {
            hashMap.put(curr, new Node(curr.data));
        }
        for(Node curr = head; curr != null; curr = curr.next) {
            Node clone = hashMap.get(curr);
            clone.next = hashMap.get(curr.next);
            clone.random = hashMap.get(curr.random);
        }
        return hashMap.get(head);
    }
    public static Node efficientSolution(Node head) {
        /**
         * Insert clone nodes alternatively
         * Connect clone nodes with random
         * Separate original and clone nodes
         * */
        Node curr = head;
        while(curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = next;
            curr = next;
        }
        for(Node curr1 = head; curr != null; curr = curr.next.next) {
            curr.next.random = curr1.random == null ? null : curr1.random.next;
        }
        Node head2 = head.next;
        Node clone = head2;
        for(Node curr1 = head2; curr != null; curr = curr.next) {
            curr.next = curr1.next.next;
            clone.next = clone.next != null ? clone.next.next : null;
            clone = clone.next;
        }
        return head2;
    }
    static class Node {
        int data;
        Node next;
        Node random;
        Node(int x) {
            data = x;
            next = null;
            random = null;
        }
    }
}
