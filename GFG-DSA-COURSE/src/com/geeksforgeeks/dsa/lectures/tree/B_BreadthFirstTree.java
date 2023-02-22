/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class B_BreadthFirstTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.right = new Node(20);
        root.left.left = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);
        System.out.print("Level Order Traversal : "); levelOrderTraversal(root);
        System.out.println("\nLevel Order Traversal Line By Line (1) : ");
        levelOrderTraversalLineByLine1(root);
        System.out.println("\nLevel Order Traversal Line By Line (2) : ");
        levelOrderTraversalLineByLine2(root);
        System.out.print("Height : " + height(root));
        System.out.print("\nSize : " + size(root));
    }
    public static void levelOrderTraversal(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }
    }
    public static void levelOrderTraversalLineByLine1(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.size() > 1) {
            Node curr = queue.poll();
            if (curr == null) {
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(curr.data + " ");
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }
    }
    public static void levelOrderTraversalLineByLine2(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            System.out.println();
        }
    }
    public static int height(Node root) {
        if(root == null) return 0;
        else return Math.max(height(root.left),height(root.right)) + 1;
    }
    public static int size(Node root) {
        if(root == null) return 0;
        else return size(root.left) + size(root.right) + 1;
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
