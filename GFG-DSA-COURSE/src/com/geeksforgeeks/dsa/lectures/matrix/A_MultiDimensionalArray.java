/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.matrix;

public class A_MultiDimensionalArray {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}};
        int[][] jagged = {{0},{1,2},{3,4,5}};
        normalMultiDimensionalArray(arr);
        jaggedMultiDimensionalArray(jagged);
        jaggedMultiDimensionalArray();
    }
    public static void normalMultiDimensionalArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void normalMultiDimensionalArray(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void jaggedMultiDimensionalArray() {
        int m = 3;
        int[][] arr = new int[m][];
        for (int i = 0; i < m; i++) {
            arr[i] = new int[i+1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void jaggedMultiDimensionalArray(int[][] arr) {
        int m = arr.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
