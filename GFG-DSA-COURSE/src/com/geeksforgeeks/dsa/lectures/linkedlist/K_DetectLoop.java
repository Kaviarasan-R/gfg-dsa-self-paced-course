/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

import java.util.HashSet;

public class K_DetectLoop {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        //temp3.next = temp1;
        System.out.println(naiveSolution1(head));
        System.out.println(naiveSolution2(head));
        System.out.println(efficientSolution(head));

        /** NODE MODIFIED */
        NodeModified headModified = new NodeModified(10);
        NodeModified temp1Modified = new NodeModified(20);
        NodeModified temp2Modified = new NodeModified(30);
        NodeModified temp3Modified = new NodeModified(40);
        headModified.next = temp1Modified;
        temp1Modified.next = temp2Modified;
        temp2Modified.next = temp3Modified;
        temp3Modified.next = temp1Modified;
        System.out.println(naiveSolution3(headModified));

    }
    /** O (N ^ 2) by using reference */
    public static boolean naiveSolution1(Node head) {
        Node i = head;
        Node ref = null;
        boolean visited = false;
        while(i != null) {
            ref = i.next;
            Node j = head;
            while(j != i) { // loop till i'th node
                if(j == ref) visited = true;
                j = j.next;
            }
            if(visited) break;
            i = i.next;
        }
        return visited;
    }

    /** O (N) with O (N) Aux Space by using hashing */
    public static boolean naiveSolution2(Node head) {
        HashSet<Node> hash = new HashSet<>();
        for(Node curr = head; curr != null; curr = curr.next) {
            if(hash.contains(curr)) return true;
            hash.add(curr);
        }
        return false;
    }

    /** O (N) with node modified */
    public static boolean naiveSolution3(NodeModified head) {
        NodeModified curr = head;
        while(curr != null) {
            if(curr.visited) {
                return true;
            }
            curr.visited = true;
            curr = curr.next;
        }
        return false;
    }

    /** O (N) without extra space */
    public static boolean efficientSolution(Node head) {
        /**
         * 1. keep traversing the linked list, store the curr.next and change curr.next to temp
         * 2. If the curr.next is already pointing to temp, then it has loop.
         * */
        Node temp = new Node(999); // dummy node
        Node curr = head;
        while(curr != null) {
            if(curr.next == null) return false;
            if(curr.next == temp) return true;
            Node curr_next = curr.next;
            curr.next = temp;
            curr = curr_next;
        }
        return false;
    }

    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
    static class NodeModified {
        int data;
        NodeModified next;
        boolean visited;
        NodeModified(int x) {
            data = x;
            next = null;
            visited = false;
        }
    }
}
