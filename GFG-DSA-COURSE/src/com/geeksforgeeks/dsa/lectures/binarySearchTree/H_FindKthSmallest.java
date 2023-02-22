/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

public class H_FindKthSmallest {
    static int count = 0;
    public static void main(String[] args) {
        /**
         * Design data structure that allows following operations efficiently
         * 1. search
         * 2. insert
         * 3. delete
         * 4. find kth smallest
         * */
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(30);
        naiveSolution(root,2);

        System.out.println();

        NodeEfficient rootEfficient = new NodeEfficient(10,1);
        rootEfficient.left = new NodeEfficient(5,0);
        rootEfficient.right = new NodeEfficient(15,1);
        rootEfficient.right.left = new NodeEfficient(12,0);
        rootEfficient.right.right = new NodeEfficient(30,0);
        System.out.println(efficientSolution(rootEfficient,2).data);
    }
    public static void naiveSolution(Node root, int k) {
        if(root != null) {
            naiveSolution(root.left,k);
            count++;
            if(count == k) {
                System.out.print(root.data);
                return;
            }
            naiveSolution(root.right,k);
        }
    }
    public static NodeEfficient efficientSolution(NodeEfficient root, int k) {
        if((root.lCount+1) == k) return root;
        if((root.lCount+1) > k) return efficientSolution(root.left,k);
        else return efficientSolution(root.right,k-root.lCount-1);
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
    static class NodeEfficient {
        int data;
        int lCount;
        NodeEfficient left;
        NodeEfficient right;
        NodeEfficient(int k, int count) {
            data = k;
            lCount = count;
        }
    }
}
