/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

import java.util.*;

public class N_TopView {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        root.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        topView(root);
    }
    public static void topView(Node root) {
        Queue<Pair> queue = new LinkedList<Pair>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()) {
            /** GET THE CURRENT PAIR NODE & HD */
            Pair pair = queue.poll();
            Node curr = pair.node;
            int hd = pair.hd;
            /** ADD DATA VALUES IFF IT DOES NOT HAVE SAME HD */
            if(!map.containsKey(hd)) {
                map.put(hd,curr.data);
            }
            /** ADD TO QUEUE WITH CORRESPONDING HD */
            if(curr.left != null) queue.add(new Pair(curr.left,hd-1));
            if(curr.right != null) queue.add(new Pair(curr.right,hd+1));
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            System.out.print(e.getValue() + " ");
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
