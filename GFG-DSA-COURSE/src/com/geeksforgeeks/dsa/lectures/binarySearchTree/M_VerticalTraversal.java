/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

import java.util.*;

public class M_VerticalTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        verticalTraversal(root);
    }
    public static void verticalTraversal(Node root) {
        Queue<Pair> queue = new LinkedList<Pair>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()) {
            /** GET THE CURRENT PAIR NODE & HD */
            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.hd;
            /** ADD ALL DATA VALUES IF BOTH HAS SAME HD */
            if(map.containsKey(hd)) {
                map.get(hd).add(curr.data);
            } else {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(curr.data);
                map.put(hd,arr);
            }
            /** ADD TO QUEUE WITH CORRESPONDING HD */
            if(curr.left != null) queue.add(new Pair(curr.left,hd-1));
            if(curr.right != null) queue.add(new Pair(curr.right,hd+1));
        }
        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            ArrayList<Integer> arr = e.getValue();
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
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
    static class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }
}
