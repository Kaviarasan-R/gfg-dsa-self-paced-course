/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class M_DetectAndRemoveLoop {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp1;
        detectAndRemoveLoop(head);
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static void detectAndRemoveLoop(Node head) {
        /**
         * Using Floyd's Cycle Detection Algorithm.
         * Detect loop and remove loop.
         * 1. Break the loop when they both meet at same.
         * 2. If slow is not equal to fast then there is no loop, because fast become null.
         * 3. Change slow to head because loop is found and need to remove.
         *    Move fast and slow at 1 node at a time till they don't meet together
         *    If they meet at a point, then change fast.next to NULL.
         * */
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(slow != fast) {
            System.out.print("No loop found : ");
            print(head);
            return;
        }
        slow = head;
        while(slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        System.out.print("Loop found : ");
        print(head);
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
