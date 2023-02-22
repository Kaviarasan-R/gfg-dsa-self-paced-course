/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class T_MergeTwoSortedLL {
    public static void main(String[] args) {
        Node headFirst = new Node(10);
        Node tempFirst1 = new Node(20);
        Node tempFirst2 = new Node(30);
        Node tempFirst3 = new Node(40);
        headFirst.next = tempFirst1;
        tempFirst1.next = tempFirst2;
        tempFirst2.next = tempFirst3;

        Node headSecond = new Node(5);
        Node tempSecond1 = new Node(15);
        Node tempSecond2 = new Node(17);
        Node tempSecond3 = new Node(18);
        Node tempSecond4 = new Node(35);
        headSecond.next = tempSecond1;
        tempSecond1.next = tempSecond2;
        tempSecond2.next = tempSecond3;
        tempSecond3.next = tempSecond4;

        //method1(headFirst,headSecond);
        method2(headFirst,headSecond);
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static void method1(Node head1, Node head2) {
        if(head1 == null || head2 == null) return;
        Node a = head1;
        Node b = head2;
        Node head = null;
        Node tail = null;
        boolean first = true;
        while(a != null && b != null) {
            if(a.data < b.data) {
                if(first) {
                    head = a;
                    tail = a;
                    first = false;
                } else {
                    tail.next = a;
                    tail = tail.next;
                }
                a = a.next;
                //System.out.println(" a < b : " + tail.data );
            } else {
                if(first) {
                    head = b;
                    tail = b;
                    first = false;
                } else {
                    tail.next = b;
                    tail = tail.next;
                }
                b = b.next;
                //System.out.println(" b < a : " + tail.data );
            }
        }
        while(a != null) {
            tail.next = a;
            a = a.next;
        }
        while(b != null) {
            tail.next = b;
            b = b.next;
        }
        print(head);
    }
    public static void method2(Node a, Node b) {
        if(a == null || b == null) return;
        Node head = null;
        Node tail = null;
        if(a.data <= b.data) {
            head = tail = a;
            a = a.next;
        } else {
            head = tail = b;
            b = b.next;
        }
        while(a != null && b != null) {
            if(a.data <= b.data) {
                tail.next = a;
                tail = a;
                a = a.next;
            } else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        if(a == null) tail.next = b;
        else tail.next = a;
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
