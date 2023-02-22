/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

public class A_Search {
    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.right.left = new Node(18);
        root.right.right = new Node(80);
        root.right.left.left = new Node(16);
        System.out.println(searchRecursive(root,16));
        System.out.println(searchIterative(root,19));
    }
    public static boolean searchRecursive(Node root, int x) {
        if(root == null) return false;
        else if(root.data == x) return true;
        else if(x < root.data) return searchRecursive(root.left,x);
        else return searchRecursive(root.right,x);
    }
    public static boolean searchIterative(Node root, int x) {
        while(root != null) {
            if(root.data == x) return true;
            else if(x < root.data) root = root.left;
            else root = root.right;
        }
        return false;
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
