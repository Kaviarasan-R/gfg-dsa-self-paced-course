/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.matrix;

import java.util.Arrays;

public class H_MatrixMedian {
    public static void main(String[] args) {
        int[][] arr = {{1,10,20},{15,25,35},{5,30,40}};
        int row = arr.length;
        int col = arr.length;
        int min = arr[0][0];
        int max = arr[0][col-1];
        // Getting the min & max element in the sorted array
        for (int i = 1; i < row; i++) {
            // different rows & first column min
            if(arr[i][0] < min) {
                min = arr[i][0];
            }
            // different rows & last column max
            if(arr[i][col-1] > max) {
                max = arr[i][col-1];
            }
        }
        int medianPos = (row * col) / 2;
        while(min < max) {
            int mid = (min + max)/2;
            int midPos = 0;
            for (int i = 0; i < row; i++) {
                // it will return index of given element
                int pos = Arrays.binarySearch(arr[i],mid)+1;
                midPos += Math.abs(pos);
            }
            // Update low & high as usual like binary search
            if(midPos < medianPos) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(min);
    }
}
