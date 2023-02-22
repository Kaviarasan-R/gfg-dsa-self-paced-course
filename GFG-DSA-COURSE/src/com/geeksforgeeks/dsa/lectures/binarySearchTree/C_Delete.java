/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

public class C_Delete {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.right.left = new Node(18);
        root.right.right = new Node(80);
        root.right.left.left = new Node(16);
        System.out.println(delete(root,15).data);
        display(root);
    }
    public static void display(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            display(root.left);
            display(root.right);
        }
    }
    public static Node delete(Node root, int x) {
        if(root == null) return null;
        if(root.data > x) root.left = delete(root.left,x);
        else if(root.data < x) root.right = delete(root.right,x);
        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                Node successor = findClosestGreater(root);
                root.data = successor.data;
                root.right = delete(root.right,successor.data);
            }
        }
        return root;
    }
    public static Node findClosestGreater(Node root) {
        Node curr = root.right;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
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
