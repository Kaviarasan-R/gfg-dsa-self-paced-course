/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class F_PrintNthNodeFromEnd {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        Node temp4 = new Node(50);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        System.out.println(naiveSolution(head,3));
        System.out.println(efficientSolution(head,4));
    }
    public static int naiveSolution(Node head, int n) {
        if(head == null) return -1;
        Node curr = head;
        int length = 0;
        while(curr != null) {
            curr = curr.next;
            length++;
        }
        if(n > length) return -1;
        int idx = length - n + 1;
        int count = 1;
        curr = head;
        while(count < idx) {
            curr = curr.next;
            count++;
        }
        return curr.data;
    }
    public static int efficientSolution(Node head, int n) {
        /**
         * Two pointer approach
         * 1. move 'first' n position ahead
         * 2. start 'second' pointer from head
         * 3. move both 'first' and 'second' at same speed. When 'first' returns
         *    NULL, 'second' returns the required node
         * */
        if(head == null) return -1;
        Node first = head;
        Node second = head;
        int count = 1;
        while(count <= n) {
            first = (first == null) ? null : first.next;
            count++;
        }
        if(first == null) return -1;
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        return second.data;
    }
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
}
