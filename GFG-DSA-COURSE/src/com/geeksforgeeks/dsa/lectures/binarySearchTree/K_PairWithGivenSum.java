/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class K_PairWithGivenSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);
        int sum = 33;
        System.out.println(naiveSolution(root,sum));
        System.out.println(efficientSolution(root,sum,new HashSet<Integer>()));
    }
    public static boolean naiveSolution(Node root, int x) {
        /**
         * 1. store inorder traversal values in an  auxiliary array
         * 2. do two pointer approach to find sum
         * */
        /** Iterative inorder traversal */
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Node curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            arr.add(curr.data);
            curr = curr.right;
        }
        /** Two pointer approach */
        int i = 0;
        int j = arr.size() - 1;
        while(i < j) {
            if(arr.get(i) + arr.get(j) == x) {
                return true;
            } else if (arr.get(i) + arr.get(j) < x) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    public static boolean efficientSolution(Node root, int sum, HashSet<Integer> set) {
        if(root == null) return false;
        if(efficientSolution(root.left,sum,set)) return true;
        if(set.contains(sum-root.data)) return true;
        else set.add(root.data);
        return efficientSolution(root.right,sum,set);
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
