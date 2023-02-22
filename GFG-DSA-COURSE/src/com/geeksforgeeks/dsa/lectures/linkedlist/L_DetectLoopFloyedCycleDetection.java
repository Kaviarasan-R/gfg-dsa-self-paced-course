/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class L_DetectLoopFloyedCycleDetection {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp1;
        System.out.println(detectLoopUsingFloydCycleDetection(head));
    }
    public static boolean detectLoopUsingFloydCycleDetection(Node head) {
        /**
         * Using two pointer approach, slow and fast.
         * slow moves ahead by 1 position and fast moves at 2.
         * when slow and fast met together then there is a loop.
         * */
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
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
}
