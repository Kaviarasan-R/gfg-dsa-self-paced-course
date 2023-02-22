/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.backtracking;

public class B_RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1,0,1,0},
                {1,1,0,1},
                {0,1,0,1},
                {1,1,1,1}
        };
        int n = maze.length;
        int[][] sol = new int[n][n];
        System.out.println(solveMaze(maze,sol,n,0,0));
    }
    public static boolean solveMaze(int[][] maze, int[][] sol, int n,int i, int j) {
        if(!solveMazeRec(maze,sol,n,i,j)) return false;
        else {
            printMatrix(sol);
            return true;
        }
    }
    public static boolean solveMazeRec(int[][] maze, int[][] sol, int n,int i, int j) {
        if(i == n-1 && j == n-1) { // CHECK FOR DESTINATION
            sol[i][j] = 1;
            return true;
        }
        if(isSafe(maze,n,i,j)) {
            sol[i][j] = 1;
            if(solveMazeRec(maze,sol,n,i+1,j)) return true; // NEXT ROW SAME COLUMN
            else if(solveMazeRec(maze,sol,n,i,j+1)) return true; // SAME ROW NEXT COLUMN
            sol[i][j] = 0;
        }
        return false;
    }
    public static boolean isSafe(int[][] maze, int n, int i, int j) {
        return (i < n && j < n && maze[i][j] == 1);
    }
    public static void printMatrix(int[][] sol) {
        int n = sol.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}
