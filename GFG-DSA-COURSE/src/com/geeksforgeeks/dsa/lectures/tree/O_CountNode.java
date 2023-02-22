/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

public class O_CountNode {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);
        System.out.println(lengthNaive(root));
        System.out.println(lengthEfficient(root));
    }
    // O (n)
    public static int lengthNaive(Node root) {
        if(root == null) return 0;
        else return 1 + lengthNaive(root.left) + lengthNaive(root.right);
    }
    // O (logn * logn)
    public static int lengthEfficient(Node root) {
        int lh = 0;
        int rh = 0;
        Node curr = root;
        while(curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while(curr != null) {
            rh++;
            curr = curr.right;
        }
        if(lh == rh) {
            return (int) (Math.pow(2,lh) - 1);
        }
        return 1 + lengthEfficient(root.left) + lengthEfficient(root.right);
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
