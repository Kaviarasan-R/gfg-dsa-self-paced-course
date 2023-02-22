/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class Q_PairwiseSwap {
    public static void main(String[] args) {
        /**
         * Swap nodes by pair
         * 1 -> 2 -> 3 -> 4 -> 5
         * 2 -> 1 -> 4 -> 3 -> 5
         * */
        Node head = new Node(1);
        Node temp1 = new Node(2);
        Node temp2 = new Node(3);
        Node temp3 = new Node(4);
        Node temp4 = new Node(5);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        //naiveSolution(head);
        efficientSolution(head);
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static void naiveSolution(Node head) {
        /**
         * Run a loop while we have at least one node ahead
         * a) swap data of current node with its next node
         * b) move current two nodes ahead and check if curr and current next is null
         * */
        Node curr = head;
        while(curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
        print(head);
    }
    public static void efficientSolution(Node head) {
        if(head == null || head.next == null) {
            print(head);
        }
        Node curr = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;
        while(curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;
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
