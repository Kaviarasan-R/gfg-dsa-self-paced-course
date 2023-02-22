/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

import java.util.Map;
import java.util.TreeMap;

public class L_VerticalSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        verticalSumIterative(root);
    }
    public static void verticalSumRecursive(Node root, int horizontalDistance, TreeMap<Integer, Integer> map) {
        if(root == null) return;
        verticalSumRecursive(root.left,horizontalDistance-1,map);
        int pSum = map.get(horizontalDistance)==null ? 0 : map.get(horizontalDistance);
        map.put(horizontalDistance,pSum+root.data);
        verticalSumRecursive(root.right,horizontalDistance+1,map);
    }
    public static void verticalSumIterative(Node root) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        verticalSumRecursive(root,0,treeMap);
        for(Map.Entry<Integer,Integer> e : treeMap.entrySet()) {
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
}
