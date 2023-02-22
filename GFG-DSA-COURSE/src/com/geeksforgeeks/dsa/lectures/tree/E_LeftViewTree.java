/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class E_LeftViewTree {
    static int maxLevel = 0;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        recursive(root,1);
        System.out.println();
        iterative(root,1);
    }
    public static void recursive(Node root, int level) {
        if(root == null) return;
        if(maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        recursive(root.left,level+1);
        recursive(root.right,level+1);
    }
    public static void iterative(Node root, int level) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node curr = queue.poll();
                if(i == 0) System.out.print(curr.data + " ");
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
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
