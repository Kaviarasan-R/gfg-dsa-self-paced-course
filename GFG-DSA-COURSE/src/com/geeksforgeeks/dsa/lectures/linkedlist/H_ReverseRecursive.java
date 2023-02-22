/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

public class H_ReverseRecursive {
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
        System.out.println(naiveSolution(head).data);
        //System.out.println(efficientSolution(head,null).data);
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static Node naiveSolution(Node head) {
        if(head == null || head.next == null) return head;
        Node rest_head = naiveSolution(head.next);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }
    /**
    public static Node efficientSolution(Node curr, Node prev) {
        if(curr == null) return prev;
        Node next = curr.next;
        curr.next = prev;
        return efficientSolution(next,curr);
    }
     **/
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
}
