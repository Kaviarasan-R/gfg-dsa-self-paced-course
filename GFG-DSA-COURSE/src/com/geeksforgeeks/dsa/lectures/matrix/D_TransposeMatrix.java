/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.matrix;

public class D_TransposeMatrix {
    static int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    public static void main(String[] args) {
        print();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                swap(i,j,j,i);
            }
        }
        System.out.println();
        print();
    }
    public static void swap(int sR, int sC, int dR, int dC) {
        int[][] temp = new int[arr.length][arr.length];
        temp[sR][sC] = arr[sR][sC];
        arr[sR][sC] = arr[dR][dC];
        arr[dR][dC] = temp[sR][sC];
    }
    public static void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
