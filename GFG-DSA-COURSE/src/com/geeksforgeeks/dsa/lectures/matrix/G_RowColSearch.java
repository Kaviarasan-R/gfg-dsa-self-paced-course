/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.matrix;

public class G_RowColSearch {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int row = arr.length;
        int col = arr.length;
        int i = 0;
        int j = col - 1;
        int x = 11;
        while(i < row && j >= 0) {
            if(arr[i][j] == x) {
                System.out.println("Found at index : [" + i + "][" + j + "]");
                return;
            }else if(arr[i][j] > x) {
                j--;
            }else {
                i++;
            }
        }
        System.out.println("Couldn't find the given element in the array.");
    }
}
