/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

public class C_PrintKthNode {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);
        print(root,2);
    }
    public static void print(Node root, int k) {
        if(root == null) return;
        if(k == 0) System.out.print(root.data + " ");
        else {
            print(root.left,k-1);
            print(root.right,k-1);
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
