/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.backtracking;

public class C_NQueens {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        System.out.println(solveNQueens(board,0,n));
        /*
            SUPER NAIVE SOLUTION : GENERATE N^2 C N POSSIBLE CONFIGURATIONS
            NAIVE SOLUTION : GENERATE ALL PERMUTATIONS OF ROW NUMBERS
            BACKTRACKING : CUT DOWN RECURSION TREE AS SOON AS WE FIND INFEASIBILITY
        */
    }
    public static boolean solveNQueens(int[][] board, int col, int n) {
        if(!solveNQueensRec(board,col,n)) return false;
        else {
            printBoard(board);
            return true;
        }
    }
    public static boolean solveNQueensRec(int[][] board, int col, int n) {
        if(col == n) return true;
        for (int i = 0; i < n; i++) {
            if(isSafe(board,i,col,n)) {
                board[i][col] = 1;
                if(solveNQueensRec(board,col+1,n)) return true;
                board[i][col] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // PREVIOUSLY PLACED QUEENS IN CURRENT ROW
        for (int i = 0; i < col; i++) {
            if(board[row][i] == 1) return false;
        }
        // UPPER DIAGONAL
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) return false;
        }
        // LOWER DIAGONAL
        for (int i = row, j = col; j >= 0 && i < n; i++,j--) {
            if(board[i][j] == 1) return false;
        }
        return true;
    }
    public static void printBoard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
