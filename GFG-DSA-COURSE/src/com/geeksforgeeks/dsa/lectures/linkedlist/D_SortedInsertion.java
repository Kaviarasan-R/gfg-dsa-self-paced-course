/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class D_SortedInsertion {
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
        insert(head,60);
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static void insert(Node head, int x) {
        Node temp = new Node(x);
        if(head == null) {
            print(temp);
            return;
        }
        if(x < head.data) {
            temp.next = head;
            print(temp);
            return;
        }
        Node curr = head;
        while(curr.next != null && curr.next.data < x) {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
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
