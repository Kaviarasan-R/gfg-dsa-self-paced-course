/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

import java.util.HashSet;

public class P_IntersectionPoint {
    public static void main(String[] args) {
        /**
         * 6 -> 8 -> 7 -> 10 -> 12 -> 15 -> NULL
         * 9 -> 10
         * two nodes intersect at 10.
         * so, return 10.
         **/
        Node headFirst = new Node(6);
        Node tempFirst1 = new Node(8);
        Node tempFirst2 = new Node(7);
        Node tempFirst3 = new Node(10);
        Node tempFirst4 = new Node(12);
        Node tempFirst5 = new Node(15);
        headFirst.next = tempFirst1;
        tempFirst1.next = tempFirst2;
        tempFirst2.next = tempFirst3;
        tempFirst3.next = tempFirst4;
        tempFirst4.next = tempFirst5;

        Node headSecond = new Node(17);
        headSecond.next = tempFirst3;
        System.out.println(naiveSolution(headFirst,headSecond));
        System.out.println(efficientSolution(headFirst,headSecond));
    }

    public static int naiveSolution(Node head1, Node head2) {
        /**
         * Create empty hash set and put all of its.
         * Traverse the first list and put all of its nodes into the hash set.
         * Traverse the second list and look for every node in the hash set.
         * As soon as we find a node present in hash set, we return value of it.
         **/
        HashSet<Integer> hash = new HashSet<>();
        Node curr1 = head1;
        Node curr2 = head2;
        while(curr1 != null) {
            hash.add(curr1.data);
            curr1 = curr1.next;
        }
        while(curr2 != null) {
            if(hash.contains(curr2.data)) {
                return curr2.data;
            }
            curr2 = curr2.next;
        }
        return -1;
    }
    public static int efficientSolution(Node head1, Node head2) {
        /**
         * Count nodes in both the lists, let counts be C1 and C2.
         * Traverse the first list [d = abs(C1 - C2)] up to d.
         * Traverse both the lists simultaneously until we find common node.
         * */
        int count1 = 0;
        int count2 = 0;
        Node curr1 = head1;
        Node curr2 = head2;
        while(curr1 != null) {
            count1++;
            curr1 = curr1.next;
        }
        while(curr2 != null) {
            count2++;
            curr2 = curr2.next;
        }
        int d = Math.abs(count1 - count2);
        curr1 = head1;
        curr2 = head2;
        if(count1 > count2) {
            while(d > 0) {
                curr1 = curr1.next;
                d--;
            }
        } else {
            while(d > 0) {
                curr2 = curr2.next;
                d--;
            }
        }
        while(curr1 != null && curr2 != null) {
            if(curr1 == curr2) {
                return curr1.data;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return -1;
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
