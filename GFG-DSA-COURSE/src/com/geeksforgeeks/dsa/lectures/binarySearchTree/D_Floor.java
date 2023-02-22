/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

public class D_Floor {
    public static void main(String[] args) {
        /** Largest smallest node to x or equal to node */
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(30);
        int x = 4;
        System.out.println(floorNaive(root,x));
        System.out.println(floorEfficient(root,6).data);
    }
    public static Node floorNaive(Node root, int x) {
        if(root == null) return null;
        if(root.data < x && root.left == null) return root;
        if(x > root.data) return floorNaive(root.right,x);
        else if(x < root.data) return floorNaive(root.left,x);
        else return root;
    }
    public static Node floorEfficient(Node root, int x) {
        Node res = null;
        while(root != null) {
            if(root.data == x) return root;
            else if(root.data > x) root = root.left;
            else {
                res = root;
                root = root.right;
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
