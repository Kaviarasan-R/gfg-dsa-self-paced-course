/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

public class J_FixBST2NodesSwapped {
    static int[] arr = new int[7];
    static int idx = 0;
    static Node prev = null, first = null, second = null;
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(60);
        root.right = new Node(80);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right.left = new Node(8);
        root.right.right = new Node(100);
        naiveSolution(root);
        efficientSolution(root);
        swapNodes();
        display(root);
    }
    public static void display(Node root) {
        if(root != null) {
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }
    public static void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            arr[idx++] = root.data;
            inOrder(root.right);
        }
    }
    public static void naiveSolution(Node root) {
        /**
         * Inorder traversal, increasing order to check for BST
         * if any of the 2 prev nodes violates the rule then swap using auxiliary array
         * */
        inOrder(root);
        int prev = Integer.MIN_VALUE;
        int first = -1;
        int second = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < prev) {
                if(first == -1) {
                    first = prev;
                }
                second = arr[i];
            }
            prev = arr[i];
        }
        System.out.println(first + " " + second);
    }
    public static void efficientSolution(Node root) {
        if(root == null) return;
        efficientSolution(root.left);
        if(prev != null && root.data < prev.data) {
            if(first ==  null) first = prev;
            second = root;
        }
        prev = root;
        efficientSolution(root.right);
    }
    private static void swapNodes() {
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
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
