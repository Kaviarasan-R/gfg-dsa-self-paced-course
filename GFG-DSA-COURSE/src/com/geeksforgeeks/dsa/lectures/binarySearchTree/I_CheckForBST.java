/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

public class I_CheckForBST {
    static int prev = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(18); // 18 should be greater than 20 and lesser than 30
        root.right.right = new Node(35);
        System.out.println(efficientSolution(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println(efficientSolution2(root));
    }
    public static boolean naiveSolution(Node root) {
        /**
         * Naive solution
         * for every node,
         * find max in left subtree
         * find min in right subtree
         * check if current node is greater than the max and smaller than the minimum.
         * */
        return true;
    }
    public static boolean efficientSolution(Node root, int min, int max) {
        /**
         * pass a range for every node
         * for root, range is - infinity to + infinity
         * for left child of a node, in range we change upper bound as node's value
         * for right child of a node, in range we change lower bound as node's value
         * */
        if(root == null) return true;
        return (root.data > min && root.data < max &&
                efficientSolution(root.left,min,root.data) &&
                efficientSolution(root.right,root.data,max));
    }
    public static boolean efficientSolution2(Node root) {
        /**
         * A binary tree is BST iff inorder traversal of it is in increasing order
         * 1st method : add all inorder traversal values to aux array and check prev element
         *              is smaller than current element.
         * 2nd method :
         * */
        if(root == null) return true;
        if(!efficientSolution2(root.left)) return false;
        if(root.data <= prev) return false;
        prev = root.data;
        return efficientSolution2(root.right);
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
