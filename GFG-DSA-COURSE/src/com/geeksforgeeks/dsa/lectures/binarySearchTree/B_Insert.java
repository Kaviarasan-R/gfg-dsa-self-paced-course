/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

public class B_Insert {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.right.left = new Node(18);
        root.right.right = new Node(80);
        root.right.left.left = new Node(16);
        insertRecursive1(root,1);
        display(root);
        System.out.println("\n----------------------");
        insertIterative1(root,4);
        display(root);
        System.out.println("\n----------------------");
        insertRecursive2(root,6);
        display(root);
        System.out.println("\n----------------------");
        insertIterative2(root,19);
        display(root);
    }
    public static void display(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            display(root.left);
            display(root.right);
        }
    }
    public static boolean insertRecursive1(Node root, int x) {
        if(root.data == x) {
            return true;
        }
        else if(x < root.data) {
            root.left = root.left == null ? new Node(x) : root.left;
            return insertRecursive1(root.left,x);
        }
        else {
            root.right = root.right == null ? new Node(x) : root.right;
            return insertRecursive1(root.right,x);
        }
    }
    public static void insertIterative1(Node root, int x) {
        while(root.data != x) {
            if(root.data == x) return;
            if(x < root.data) {
                root.left = root.left == null ? new Node(x) : root.left;
                root = root.left;
            } else {
                root.right = root.right == null ? new Node(x) : root.right;
                root = root.right;
            }
        }
    }
    public static Node insertRecursive2(Node root, int x) {
        if(root == null) {
            return new Node(x);
        }
        if(root.data > x) {
            root.left = insertRecursive2(root.left,x);
        } else if(root.data < x) {
            root.right = insertRecursive2(root.right,x);
        }
        return root;
    }
    public static void insertIterative2(Node root, int x) {
        Node temp = new Node(x);
        Node parent = null;
        Node curr = root;
        while(curr != null) {
            parent = curr;
            if(curr.data > x) {
                curr = curr.left;
            } else if(curr.data < x) {
                curr = curr.right;
            } else {
                return;
            }
        }
        if(parent == null) return;
        if(parent.data > x) parent.left = temp;
        else parent.right = temp;
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
