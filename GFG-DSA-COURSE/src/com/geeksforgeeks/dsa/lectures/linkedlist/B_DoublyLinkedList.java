/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class B_DoublyLinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        head.next = temp1; // head prev is null
        temp1.prev = head;
        temp1.next = temp2;
        temp2.next = temp3;
        temp2.prev = temp1;
        temp3.prev = temp2; // temp3 next is null

        System.out.print("Doubly LinkedList : "); print(head);
        System.out.print("\nInsert First : "); insertFirst(head,1);
        System.out.print("\nInsert Last : "); insertLast(head,50);
        System.out.print("\nDelete First : "); deleteFirst(head);
        System.out.print("\nDelete Last : "); deleteLast(head);
        System.out.print("\nReversed Doubly LinkedList : " + reverse(head).data);
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static Node reverse(Node head) {
        if(head == null || head.next == null) return head;
        Node temp = null;
        Node curr = head;
        while(curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        /** System.out.print(temp.prev.data); **/ // printing head node
        return temp.prev;
    }
    public static void insertLast(Node head, int x) {
        Node temp = new Node(x);
        if(head == null) head = temp;
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        print(head);
    }
    public static void insertFirst(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        if(head != null) {
            head.prev = temp;
        }
        print(temp);
    }
    public static void deleteFirst(Node head) {
        if(head == null) return;
        if(head.next == null) return; //return null
        else {
            head = head.next;
            head.prev = null;
            print(head);
        }
    }
    public static void deleteLast(Node head) {
        if(head == null) return;
        if(head.next == null) return; // return null
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        print(head);
    }

    static class Node {
        int data;
        Node prev;
        Node next;
        Node(int x) {
            data = x;
            prev = null;
            next = null;
        }
    }
}

