/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class N_DeleteNodeByReference {
    static Node head = new Node(10);
    static Node temp1 = new Node(20);
    static Node temp2 = new Node(30);
    static Node temp3 = new Node(40);
    static Node temp4 = new Node(25);

    public static void main(String[] args) {
        /**
         * 10 -> 20 -> 30 -> 40 -> 25 -> NULL
         * IP : Pointer or Reference to node with value 30
         * OP : The list should change to 10 -> 20 -> 40 -> 25 -> NULL
         * */
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        deleteNodeByReference(temp2);
    }
    public static void print() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static void deleteNodeByReference(Node ref) {
        ref.data = ref.next.data;
        ref.next = ref.next.next;
        print();
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
