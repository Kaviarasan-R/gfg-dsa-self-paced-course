/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

public class K_LargestRectangleOnes {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        int row = 4;
        int col = 4;
        /**
         * full row or column should be 1, return the largest count ones.
         * [][] --> [[0,1,1,0],
         *           [1,1,1,1],  <--
         *           [1,1,1,1],  <--
         *           [1,1,0,0]]
         * OP : 8
         *              ^ ^
         * [][] --> [[0,1,1],
         *           [1,1,1],
         *           [0,1,1]]
         * Explanation : Here, 2nd row has only ones (1r * 3c) = 3. But also it has 2 columns having ones.
         * OP : 6
         * */
        System.out.println(efficientSolution(matrix,row,col));
    }
    public static int efficientSolution(int[][] arr, int row, int col) {
        /**
         *
         * O(r * c)
         arr =      [1 0 0 1 1]
                    [0 0 0 1 1]
                    [1 1 1 1 1]
                    [0 1 1 1 1]

         i = 1 :    [1 0 0 1 1]
                    [0 0 0 2 2]  <--- prev col cell + curr col sell (only if curr col cell starts from 1)
                    [1 1 1 1 1]
                    [0 1 1 1 1]

         i = 2 :    [1 0 0 1 1]
                    [0 0 0 2 2]
                    [1 1 1 3 3] <--- addition of original prev col until it becomes 0 + original curr col
                    [0 1 1 1 1]

         i = 3 :    [1 0 0 1 1]
                    [0 0 0 2 2]
                    [1 1 1 3 3]
                    [0 2 2 4 4] <--- addition of prev + curr column cell original array
         * */
        int res = J_LargestRectangularAreaHistogram.efficientSolution(arr[0],col);
        // res = 2
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] += arr[i-1][j];
                }
            }
            res = Math.max(res,J_LargestRectangularAreaHistogram.efficientSolution(arr[i],col));
        }
        return res;
    }
}
