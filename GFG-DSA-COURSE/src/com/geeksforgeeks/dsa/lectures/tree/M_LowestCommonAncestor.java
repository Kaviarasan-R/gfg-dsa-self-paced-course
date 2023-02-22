/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

import java.util.ArrayList;

public class M_LowestCommonAncestor {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.left.left = new Node(60);
        root.right.right = new Node(50);
        root.right.right.left = new Node(70);
        root.right.right.right = new Node(80);
        int n1 = 60;
        int n2 = 70;
        System.out.println(naiveSolution(root,n1,n2).data);
        System.out.println(efficientSolution(root,n1,n2).data);
    }
    public static Node naiveSolution(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        if(!findPath(root,path1,n1) || !findPath(root,path2,n2)) return null;
        for (int i = 0; i < path1.size()-1 && i < path2.size()-1; i++) {
            if(path1.get(i+1) != path2.get(i+1)) {
                return path1.get(i);
            }
        }
        return null;
    }
    public static boolean findPath(Node root, ArrayList<Node> ref, int n) {
        if(root == null) return false;
        ref.add(root);
        if(root.data == n) return true;
        if(findPath(root.left,ref,n) || findPath(root.right,ref,n)) return true;
        ref.remove(ref.size()-1);
        return false;
    }
    public static Node efficientSolution(Node root, int n1, int n2) {
        /**
         * In recursive traversal,
         * 1. If it is same as n1 or n2
         * 2. If one of its subtree contains n1 and other contains n2
         * 3. If one of its subtree contains both n1 and n2
         * 4. If none of its subtree contains any of the n1 and n2
         * */
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;
        Node lca1 = efficientSolution(root.left,n1,n2);
        Node lca2 = efficientSolution(root.right,n1,n2);
        if(lca1 != null && lca2 != null) return root;
        if(lca1 != null) return lca1;
        else return lca2;
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
