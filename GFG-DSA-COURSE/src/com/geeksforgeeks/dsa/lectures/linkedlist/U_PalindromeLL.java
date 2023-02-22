/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class U_PalindromeLL {
    public static void main(String[] args) {
        Node head = new Node('R');
        Node temp1 = new Node('A');
        Node temp2 = new Node('D');
        Node temp3 = new Node('A');
        Node temp4 = new Node('R');
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        System.out.println(naiveSolution(head));
        System.out.println(efficientSolution(head));
    }
    public static boolean naiveSolution(Node head) {
        Deque<Character> stack = new ArrayDeque<>();
        for(Node curr = head; curr != null; curr = curr.next) {
            stack.push(curr.data);
        }
        for(Node curr = head; curr != null; curr = curr.next) {
            if(stack.pop() != curr.data) {
                return false;
            }
        }
        return true;
    }
    public static boolean efficientSolution(Node head) {
        if(head == null) return true;
        Node slow = head;
        Node fast = head;
        // to find middle node
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse from the middle node
        Node rev = reverse(slow.next);
        Node curr = head;
        // compare from the head and after the reversed middle node
        while(rev != null) {
            if(rev.data != curr.data) return false;
            rev = rev.next;
            curr = curr.next;
        }
        return true;
    }
    public static Node reverse(Node head) {
        ArrayList<Character> arr = new ArrayList<>();
        Node curr;
        for(curr = head; curr != null; curr = curr.next) {
            arr.add(curr.data);
        }
        for(curr = head; curr != null; curr = curr.next) {
            curr.data = arr.remove(arr.size()-1); // removing from last
        }
        return head;
    }
    static class Node {
        char data;
        Node next;

        Node(char x) {
            data = x;
            next = null;
        }
    }
}
