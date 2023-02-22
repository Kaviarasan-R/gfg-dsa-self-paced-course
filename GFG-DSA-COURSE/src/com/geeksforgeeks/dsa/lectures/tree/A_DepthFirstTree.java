/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

public class A_DepthFirstTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.print("In Order : "); inOrder(root);
        System.out.print("\nPre Order : "); preOrder(root);
        System.out.print("\nPost Order : "); postOrder(root);
        System.out.print("\nHeight : " + height(root));
        System.out.print("\nSize : " + size(root));
    }
    public static void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    public static void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
    public static int height(Node root) {
        if(root == null) return 0;
        else return Math.max(height(root.left),height(root.right)) + 1;
    }
    public static int size(Node root) {
        if(root == null) return 0;
        else return size(root.left) + size(root.right) + 1;
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
