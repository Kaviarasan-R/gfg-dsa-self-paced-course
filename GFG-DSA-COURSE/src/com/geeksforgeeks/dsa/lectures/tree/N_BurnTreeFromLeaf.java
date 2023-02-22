/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

public class N_BurnTreeFromLeaf {
    static int res = 0;
    public static void main(String[] args) {
        // Delete adjacent node's start from the leaf
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        int leaf = 50;
        System.out.println(burnTime(root,leaf,new Distance(-1)));
    }
    public static int burnTime(Node root, int leaf, Distance dist) {
        if(root == null) return 0;
        if(root.data == leaf) {
            dist.val = 0;
            return 1;
        }
        Distance lDist = new Distance(-1);
        Distance rDist = new Distance(-1);
        int lh = burnTime(root.left,leaf,lDist);
        int rh = burnTime(root.right,leaf,rDist);
        if(lDist.val != -1) {
            dist.val = lDist.val + 1;
            res = Math.max(res,rh+dist.val);
        } else if(rDist.val != -1) {
            dist.val = rDist.val + 1;
            res = Math.max(res,lh+dist.val);
        }
        return Math.max(lh,rh)+1;
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
    static class Distance {
        int val;
        Distance(int d) {
            val = d;
        }
    }
}
