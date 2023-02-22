/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

public class F_ChildrenSum {
    public static void main(String[] args) {
        // sum of left and right node of children should match the parent
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        System.out.println(childrenSumProperty(root));
    }
    public static boolean childrenSumProperty(Node root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int sum = 0;
        if(root.left != null) sum += root.left.data;
        if(root.right != null) sum += root.right.data;
        return (root.data == sum && childrenSumProperty(root.left) && childrenSumProperty(root.right));
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
