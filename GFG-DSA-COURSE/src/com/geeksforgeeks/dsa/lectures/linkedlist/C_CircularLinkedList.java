/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class C_CircularLinkedList {
    public static void main(String[] args) {
        /** Circular Singly Linked List */
        NodeSingly head = new NodeSingly(10);
        NodeSingly temp1 = new NodeSingly(20);
        NodeSingly temp2 = new NodeSingly(30);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = head;
        System.out.print("Circular Singly Linked List : "); print(head);
        System.out.print("\nInsert First : "); insertFirst(head,1);
        System.out.print("\nDelete First : "); deleteFirst(head);
        System.out.print("\nDelete Kth Position: "); deleteKth(head,2);
        System.out.print("\nInsert Last : "); insertLast(head,40);

        /** Circular Doubly Linked List */
        NodeDoubly headDouble = new NodeDoubly(1);
        NodeDoubly temp1Double = new NodeDoubly(2);
        NodeDoubly temp2Double = new NodeDoubly(3);
        headDouble.next = temp1Double;
        temp1Double.prev = headDouble;
        temp1Double.next = temp2Double;
        temp2Double.next = headDouble;
        temp2Double.prev = temp1Double;
        System.out.print("\n\nCircular Doubly Linked List : "); printDouble(headDouble);
        System.out.print("\nInsert First : "); insertFirstDoubly(headDouble,0);
    }
    public static void print(NodeSingly head) {
        if(head == null) return;
        /**
         Using for loop :-
         System.out.print(head.data + " ");
         for (NodeSingly r = head.next; r != head; r = r.next) {
            System.out.print(r.data + " ");
         }
         Using do-while loop :-
         * */
         NodeSingly curr = head;
         do {
            System.out.print(curr.data + " ");
            curr = curr.next;
         } while(curr != head);
        /**
        NodeSingly curr = head;
        while(curr.next != head) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
         **/
    }
    public static void printDouble(NodeDoubly head) {
        System.out.print(head.data + " ");
        for (NodeDoubly r = head.next; r != head; r = r.next) {
            System.out.print(r.data + " ");
        }
    }
    public static void insertFirst(NodeSingly head, int x) {
        /** Naive Insertion
        NodeSingly temp = new NodeSingly(x);
        if(head == null) {
            temp.next = temp;
        } else {
            NodeSingly curr = head;
            while(curr.next != head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
            print(temp);
        }
         **/
        /** Efficient Insertion */
        NodeSingly temp = new NodeSingly(x);
        if(head == null) {
            temp.next = temp;
        } else {
            temp.next = head.next;
            head.next = temp;
            int t = head.data; // swap head with temp data
            head.data = temp.data;
            temp.data = t;
            print(head);
        }
        /**
         NodeSingly temp = new NodeSingly(x);
         temp.next = head;
         NodeSingly curr = head;
         while(curr.next != head) {
            curr = curr.next;
         }
         curr.next = temp;
         print(temp);
         **/
    }
    public static void insertLast(NodeSingly head, int x) {
        /** Naive Solution
        NodeSingly temp = new NodeSingly(x);
        if(head == null) {
            temp.next = temp;
        }
        else {
            NodeSingly curr = head;
            while(curr.next != head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
            print(head);
        }
        **/
        /** Efficient Solution */
        NodeSingly temp = new NodeSingly(x);
        if(head == null) {
            temp.next = temp;
        } else {
            temp.next = head.next;
            head.next = temp;
            int t = temp.data; // swap temp with head data
            temp.data = head.data;
            head.data = t;
            print(temp);
        }
    }
    public static void deleteFirst(NodeSingly head) {
        if(head == null) return;
        if(head.next == null) return;
        /** Naive Deletion
        NodeSingly curr = head;
        while(curr.next != head) {
            curr = curr.next;
        }
        curr.next = head.next;
        print(curr.next);
        **/
        /** Efficient Deletion */
        head.data = head.next.data;
        head.next = head.next.next;
        print(head);
    }
    public static void deleteKth(NodeSingly head, int pos) {
        if(head == null) return;
        if(pos == 1) deleteFirst(head);
        NodeSingly curr = head;
        // stop at before 2 steps
        for (int i = 0; i < pos-2; i++) {
            curr = curr.next;
        }
        /**
         * now change chain from current to after next 2 steps
         * 10 --> 20 --> 30
         *  ________
         * |       |
         * 10  20  30
         * */
        curr.next = curr.next.next;
        print(head);
    }
    public static void insertFirstDoubly(NodeDoubly head, int x) {
        NodeDoubly temp = new NodeDoubly(x);
        if(head == null) {
            temp.next = temp;
            temp.prev = temp;
        }
        temp.prev = head.prev;
        temp.next = head;
        head.prev = temp;
        head.prev.next = temp;
        printDouble(temp);
    }
    static class NodeSingly {
        int data;
        NodeSingly next;
        NodeSingly(int x) {
            data = x;
            next = null;
        }
    }
    static class NodeDoubly {
        int data;
        NodeDoubly prev;
        NodeDoubly next;
        NodeDoubly(int x) {
            data = x;
            prev = null;
            next = null;
        }
    }
}
