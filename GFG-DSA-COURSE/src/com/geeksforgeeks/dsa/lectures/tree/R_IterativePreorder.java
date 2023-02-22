/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

import java.util.Stack;

public class R_IterativePreorder {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);
        iterativeNaive(root);
        System.out.println();
        iterativeEfficient(root);
    }
    public static void iterativeNaive(Node root) {
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
    }
    public static void iterativeEfficient(Node root) {
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                System.out.print(curr.data + " ");
                if(curr.right != null) {
                    stack.push(curr.right);
                }
                curr = curr.left;
            }
            if(!stack.isEmpty()) {
                curr = stack.pop();
            }
        }
    }
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }
}
