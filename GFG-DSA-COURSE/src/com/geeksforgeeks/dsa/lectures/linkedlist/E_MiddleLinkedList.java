/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class E_MiddleLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        Node temp4 = new Node(50);
        //Node temp5 = new Node(60);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        //temp4.next = temp5;
        System.out.println(naiveSolution(head));
        System.out.println(efficientSolution(head));
    }
    public static int naiveSolution(Node head) {
        if(head == null) return -1;
        int count = 0;
        Node curr = head;
        while(curr != null) {
            curr = curr.next;
            count++;
        }
        curr = head;
        for (int i = 0; i < count/2; i++) {
            curr = curr.next;
        }
        return curr.data;
    }
    public static int efficientSolution(Node head) {
        /** Two pointers approach
         * slow moves at 1 window whereas fast moves at 2 window slides.
         * In even length nodes, stop when fast reaches null and return slow.
         * In odd length nodes, stop when fast's next node is null and return slow.
         * */
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
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
