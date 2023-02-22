/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class A_SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        head.next = temp1;
        temp1.next = temp2; //head.next.next = temp2;
        temp2.next = temp3; //head.next.next.next = temp3;

        System.out.print("Traverse Iterative : "); traverseIterative(head);
        System.out.print("\nTraverse Recursive : "); traverseRecursive(head);
        System.out.print("\nInsert First : "); insertFirst(head,1);
        System.out.print("\nInsert At K : "); insertKth(head,5,45);
        System.out.print("\nInsert Last : "); insertLast(head,50);
        System.out.print("\nSearch Iterative : " + searchIterative(head,45));
        System.out.print("\nSearch Recursive : " + searchRecursive(head,30));
        System.out.print("\nDelete First : "); deleteFirst(head);
        System.out.print("\nDelete Last : "); deleteLast(head);
    }
    public static void traverseIterative(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static void traverseRecursive(Node head) {
        if(head == null) return;
        System.out.print(head.data + " ");
        traverseRecursive(head.next);
    }
    public static void insertFirst(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        traverseIterative(temp);
    }
    public static void insertLast(Node head, int x) {
        Node temp = new Node(x);
        if(head == null) traverseIterative(temp);
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        traverseIterative(head);
    }
    public static void insertKth(Node head, int pos, int data) {
        Node temp = new Node(data);
        if(pos == 1) {
            temp.next = head;
        }
        Node curr = head;
        for (int i = 1; i <= pos-2 && curr != null; i++) {
            curr = curr.next;
        }
        if(curr == null) {
            System.out.print("Couldn't find position");
            return;
        }
        temp.next = curr.next;
        curr.next = temp;
        traverseIterative(head);
    }
    public static void deleteFirst(Node head) {
        if(head == null) return;
        head = head.next;
        traverseIterative(head);
    }
    public static void deleteLast(Node head) {
        if(head == null) return;
        if(head.next == null) return;
        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        traverseIterative(head);
    }
    public static int searchIterative(Node head, int x) {
        int idx = 1;
        Node curr = head;
        while(curr != null) {
            if(curr.data == x) return idx;
            curr = curr.next;
            idx++;
        }
        return (curr == null) ? -1 : idx;
    }
    public static int searchRecursive(Node head, int x) {
        if(head == null) return -1;
        if(head.data == x) return 1;
        else {
            int res = searchRecursive(head.next,x);
            if(res == -1) return -1;
            else return res+1;
        }
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
