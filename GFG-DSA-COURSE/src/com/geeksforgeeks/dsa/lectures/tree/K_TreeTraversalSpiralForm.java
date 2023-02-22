/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class K_TreeTraversalSpiralForm {
    public static void main(String[] args) {
        // print from root and in next level from right to left and left to right alternative.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.right.left.left = new Node(10);
        System.out.println("METHOD 1 : "); naiveSolution(root);
        System.out.println("METHOD 2 : "); efficientSolution(root);
    }
    public static void naiveSolution(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        /** LINES ADDED TO BFS TRAVERSAL */
        Stack<Integer> stack = new Stack<>();
        boolean reverse = false;
        /** END */
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node curr = queue.poll();
                /** LINES ADDED TO BFS TRAVERSAL */
                if(reverse) stack.push(curr.data);
                /** END */
                else System.out.print(curr.data + " ");
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            /** LINES ADDED TO BFS TRAVERSAL */
            if(reverse) {
                while(!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
            }
            reverse = !reverse;
            /** END */
            System.out.println();
        }
    }
    public static void efficientSolution(Node root) {
        /**
         * 1. Push root to the stack s1.
         * 2. While any of the two stacks is not empty
         *      while s1 is not empty :
         *          (a) Take out a node, print it.
         *          (b) Push children of the taken out node into s2.
         *      while s2 is not empty :
         *          (a) Take out a node, print it.
         *          (b) Push children of the taken out node into s1 in reverse order.
         * */
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                Node pop = stack1.pop();
                System.out.print(pop.data + " ");
                if(pop.left != null) stack2.push(pop.left);
                if(pop.right != null) stack2.push(pop.right);
            }
            while(!stack2.isEmpty()) {
                Node pop = stack2.pop();
                System.out.print(pop.data + " ");
                if(pop.right != null)stack1.push(pop.right);
                if(pop.left != null) stack1.push(pop.left);
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
