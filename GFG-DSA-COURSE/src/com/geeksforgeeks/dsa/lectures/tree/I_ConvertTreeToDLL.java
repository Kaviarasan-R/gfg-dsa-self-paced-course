/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

public class I_ConvertTreeToDLL {
    static Node prev = null;
    public static void main(String[] args) {
        // Similar to Inorder traversal
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        System.out.println(convertTreeDLL(root).data);
    }
    public static Node convertTreeDLL(Node root) {
        if(root == null) return root;
        Node head = convertTreeDLL(root.left);
        if(prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertTreeDLL(root.right);
        return head;
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
