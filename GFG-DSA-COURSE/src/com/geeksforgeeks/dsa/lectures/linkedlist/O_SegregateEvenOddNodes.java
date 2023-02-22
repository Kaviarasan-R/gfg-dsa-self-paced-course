/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class O_SegregateEvenOddNodes {
    public static void main(String[] args) {
        /**
         * IP : 17 -> 15 -> 8 -> 12 -> 5
         * OP : 8 -> 12 -> 17 -> 15 -> 5
         * If all nodes are even or odd then no need to chaning
         * */
        Node head = new Node(17);
        Node temp1 = new Node(15);
        Node temp2 = new Node(8);
        Node temp3 = new Node(12);
        Node temp4 = new Node(5);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    /** Naive Solution
     * 1. find the last node and save it in reference by doing first traversal.
     * 2. traverse from the first and if the node is odd then change the next of
     *    the last node by moving the odd node, if any of the node is even then ignore.
     **/
    public static void efficientSolution(Node head) {
        /**
         * es -> reference to start the even sublist
         * ee -> reference to end the even sublist
         * os -> reference to start the odd sublist
         * oe -> reference to end the odd sublist
         * All the above are initialized as null
         * While traversing :
         *  (a) If current node is even, we insert it after ee and update ee.
         *      Also update es if this is the first node.
         *  (b) Similar to (a) for the odd nodes.
         *  (c) After the loop, connect the two lists.
         *      ee.next = os
         * */
        Node es = null;
        Node ee = null;
        Node os = null;
        Node oe = null;
        for(Node curr = head; curr != null; curr = curr.next) {
            int x = curr.data;
            if(x % 2 == 0) {
                if(es == null) {
                    es = curr;
                    ee = curr;
                } else {
                    ee.next = curr;
                    ee = ee.next;
                }
            } else {
                if(os == null) {
                    os = curr;
                    oe = curr;
                } else {
                    oe.next = curr;
                    oe = oe.next;
                }
            }
        }
        if(os == null || es == null) {
            print(head);
        }
        ee.next = os;
        oe.next = null;
        print(es);
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
