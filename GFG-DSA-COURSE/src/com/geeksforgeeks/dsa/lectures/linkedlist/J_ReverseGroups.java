/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class J_ReverseGroups {
    public static void main(String[] args) {
        /**
         * 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> 70
         * k = 3
         * 30 -> 20 -> 10 -> 60 -> 50 -> 40 -> 70
         * |-------------| |---------------|
         * if (k > n) reverse all
         * */
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        Node temp4 = new Node(50);
        Node temp5 = new Node(60);
        Node temp6 = new Node(70);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;
        System.out.println(reverseGroupsRecursive(head,3).data);
        System.out.println(reverseGroupsIterative(head,3).data);
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static Node reverseGroupsRecursive(Node head, int k) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null) {
            Node rest_head = reverseGroupsRecursive(next,k);
            head.next = rest_head;
        }
        return prev;
    }
    public static Node reverseGroupsIterative(Node head, int k) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        Node curr = head;
        Node prevFirst = null;
        boolean isFirstpass = true;
        while(curr != null) {
            Node first = curr; // 1
            Node prev = null;
            int count = 0;
            while(curr != null && count < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if(isFirstpass) {
                /**
                 * used to set the head as previous once count reaches k.
                 * after changing head as prev, we'll change boolean as false.
                 * this will be run only for first group.
                 * **/
                head = prev;
                isFirstpass = false;
            } else {
                /**
                 * this part will run for subsequent group of 1st group.
                 * for connecting individual groups, we'll use prevFirst next as prev
                 * from 2nd group, 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8
                 * prevFirst = 1
                 * prevFirst.next = 6
                 * */
                prevFirst.next = prev;
            }
            /**
             *  after every completion of group loop, it will set as curr node.
             *  prevFirst = 1 --> after 1st k group.
             *  prevFirst = 4 --> after 2nd k group.
             * */
            prevFirst = first;
        }
        return head;
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
