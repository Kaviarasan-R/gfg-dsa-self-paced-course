/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

public class L_DiameterOfBinaryTree {
    static int res = 0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(60);
        root.right.right.right = new Node(70);
        root.right.left.left = new Node(60);

        System.out.println(naiveSolution(root));
        System.out.println(efficientSolution(root));
    }
    public static int naiveSolution(Node root) {
        /** height of deep left node + height of deep right node + current node = Max(1+lh+rh) */
        if(root == null) return 0;
        int diameter = 1 + height(root.left) + height(root.right);
        int lh = naiveSolution(root.left);
        int rh = naiveSolution(root.right);
        return Math.max(diameter,Math.max(lh,rh));
    }
    public static int efficientSolution(Node root) {
        /** Using hashmap, precompute height of every node and store it in map*/
        if(root == null) return 0;
        int lh = efficientSolution(root.left);
        int rh = efficientSolution(root.right);
        res = Math.max(res,1+lh+rh);
        return 1 + Math.max(lh,rh);
    }
    public static int height(Node root) {
        if(root == null) return 0;
        else return Math.max(height(root.left),height(root.right)) + 1;
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
