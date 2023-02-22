/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.matrix;

public class C_PrintBoundaryElements {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int row = 4;
        int col = 4;
        if(row == 1) { // WHEN ONLY SINGLE ROW
            for (int i = 0; i < col; i++) {
                System.out.print(arr[0][i] + " ");
            }
        } else if (col == 1) { // WHEN ONLY SINGLE COLUMN
            for (int i = 0; i < row; i++) {
                System.out.print(arr[i][0] + " ");
            }
        } else {
            // TOP
            for (int i = 0; i < col; i++) {
                System.out.print(arr[0][i] + " ");
            }
            // RIGHT
            for (int i = 1; i < row; i++) {
                System.out.print(arr[i][col-1] + " ");
            }
            // BOTTOM
            for (int i = col-2; i >= 0; i--) {
                System.out.print(arr[row-1][i] + " ");
            }
            // LEFT
            for (int i = row-2; i >= 1; i--) {
                System.out.print(arr[i][0] + " ");
            }
        }
    }
}
