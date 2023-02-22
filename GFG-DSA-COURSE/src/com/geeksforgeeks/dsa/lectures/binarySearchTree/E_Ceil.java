/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

public class E_Ceil {
    public static void main(String[] args) {
        /** Largest smallest node to x or equal to node */
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(30);
        int x = 4;
        System.out.println(ceilEfficient(root,x).data);
    }
    public static Node ceilEfficient(Node root, int x) {
        Node res = null;
        while(root != null) {
            if(root.data == x) return root;
            if(root.data < x) root = root.right;
            else {
                res = root;
                root = root.left;
            }
        }
        return res;
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
