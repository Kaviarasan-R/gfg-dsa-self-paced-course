/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

public class G_BalancedTree {
    public static void main(String[] args) {
        // Difference between left subtree and right subtree should <= 1
        Node root = new Node(18);
        root.left = new Node(4);
        root.right = new Node(20);
        root.left.left = new Node(13);
        root.left.right = new Node(70);
        System.out.println(naiveSolution(root));
        System.out.println(efficientSolution(root));
    }
    public static boolean naiveSolution(Node root) {
        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.left);
        return (Math.abs(lh - rh) <= 1 && naiveSolution(root.left) && naiveSolution(root.right));
    }
    public static int efficientSolution(Node root) {
        if(root == null) return 0;
        // check for left subtree and also get left height
        int lh = efficientSolution(root.left);
        if(lh == -1) return -1;
        // check for left subtree and also get right height
        int rh = efficientSolution(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;
        else return Math.max(lh,rh)+1;
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
