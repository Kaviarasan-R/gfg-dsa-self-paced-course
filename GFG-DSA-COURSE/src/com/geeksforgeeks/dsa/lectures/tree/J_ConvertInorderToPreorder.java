/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.tree;

public class J_ConvertInorderToPreorder {
    static int preIndex = 0;
    public static void main(String[] args) {
        int[] inorder = {20,10,40,30,50};
        int[] preorder = {10,20,30,40,50};
        int is = 0;
        int ie = inorder.length-1;
        System.out.println(convertInorderPreorder(inorder,preorder,is,ie).data);
    }
    public static Node convertInorderPreorder(int[] inorder, int[] preorder, int is, int ie) {
        if(is > ie) return null;
        Node root = new Node(preorder[preIndex++]);
        int idx = 0;
        for (int i = is; i <= ie; i++) {
            if(inorder[i] == root.data) {
                idx = i;
                break;
            }
        }
        root.left = convertInorderPreorder(inorder,preorder,is,idx-1);
        root.right = convertInorderPreorder(inorder,preorder,idx+1,ie);
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
