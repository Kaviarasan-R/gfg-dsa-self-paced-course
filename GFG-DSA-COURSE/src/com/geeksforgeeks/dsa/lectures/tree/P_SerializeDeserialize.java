/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

import java.util.ArrayList;

public class P_SerializeDeserialize {
    static ArrayList<Integer> arr = new ArrayList<>();
    static final int EMPTY = -1;
    static int index = 0;
    public static void main(String[] args) {
        /**
         * Tree to String or Array is called serialization
         * From String or Array to Tree is called deserialization
         * */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);
        serialize(root,arr);
        System.out.println(arr);
        System.out.println(deserialize(arr).data);
    }
    public static void serialize(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            arr.add(EMPTY);
            return;
        }
        arr.add(root.data);
        serialize(root.left,arr);
        serialize(root.right,arr);
    }
    public static Node deserialize(ArrayList<Integer> arr) {
        if(index == arr.size()) return null;
        int val = arr.get(index);
        index++;
        if(val == EMPTY) return null;
        Node root = new Node(val);
        root.left = deserialize(arr);
        root.right = deserialize(arr);
        return root;
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
