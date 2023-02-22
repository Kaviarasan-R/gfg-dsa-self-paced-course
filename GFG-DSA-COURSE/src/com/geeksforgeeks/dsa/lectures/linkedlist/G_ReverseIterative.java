/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

import java.util.ArrayList;

public class G_ReverseIterative {
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
        naiveSolution(head);
    }
    public static void print(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    public static void naiveSolution(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node curr;
        for(curr = head; curr != null; curr = curr.next) {
            arr.add(curr.data);
        }
        for(curr = head; curr != null; curr = curr.next) {
            curr.data = arr.remove(arr.size()-1); // removing from last
        }
        print(head);
    }
    /**
    public static Node efficientSolution(Node head) {
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
