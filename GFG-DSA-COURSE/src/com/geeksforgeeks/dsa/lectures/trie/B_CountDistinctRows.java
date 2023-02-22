/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.trie;

public class B_CountDistinctRows {
    static final int BINARY_SIZE = 2;
    static TrieNode root;
    public static void main(String[] args) {
        int[][] matrix = {{1,0,0},{1,1,1},{1,0,1},{1,1,1}};
        int m = matrix.length;
        int n = matrix[0].length;
        root = new TrieNode();
        System.out.println("NAIVE : " + naiveSolution(matrix,m,n));
        System.out.println("EFFICIENT : " + efficientSolution(matrix,m,n));
    }
    public static int naiveSolution(int[][] mat, int m, int n) {
        int res = 0;
        for(int i = 0; i < m; i++) {
            int flag = 0;
            for(int j = 0; j < i; j++) {
                flag = 1;
                for(int k = 0; k < n; k++) { // ITERATE OVER COLUMN
                    if (mat[i][k] != mat[j][k]) {
                        flag = 0;
                    }
                }
                if (flag == 1) break;
            }
            if (flag == 0) res++; // If no row is similar
        }
        return res;
    }
    public static int efficientSolution(int[][] mat, int m, int n) {
        int res = 0;
        for (int i = 0; i < m; i++) {
            if(insert(mat,i,n)) res++;
        }
        return res;
    }
    public static boolean insert(int[][] mat, int row, int col) {
        TrieNode curr = root;
        boolean flag = false;
        for (int i = 0; i < col; i++) {
            int idx = mat[row][i];
            if (curr.child[idx] == null) { // IT WILL CREATE NEW CHILD NODE IF IT IS NOT PRESENT
                curr.child[idx] = new TrieNode();
                flag = true;
            }
            curr = curr.child[idx];
        }
        return flag;
    }
    static class TrieNode {
        TrieNode[] child = new TrieNode[BINARY_SIZE];
        TrieNode(){
            child[0] = null;
            child[1] = null;
        }
    }
}
