/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Stack;

public class J_LargestRectangularAreaHistogram {
    public static void main(String[] args) {
        /** if you plot these values as a histogram, then largest area should need to be printed

            6   |˜|                     |˜|
            5   | |     |˜|         |˜| | |
            4   | |     | | |˜|     | | | |
            3   | |     | | | |     | | | |
            2   | | |˜| | | | |     | | | |
            1   | | | | | | | | |˜| | | | |

         * now, largest is last two histograms. because continuous 2 histograms has >= 5 (5 * 2 = 10)
         * if we consider 1 cell, then all 7 histograms continuously having 1 cell (7 * 1 = 7)
         * return the maximum.
         * */

        int[] arr = {6,2,5,4,1,5,6};
        int n = arr.length;
        System.out.println(naiveSolution(arr,n));
        System.out.println(efficientSolution(arr,n));
    }
    public static int naiveSolution(int[] arr, int n) {
        /**
         * logic : find how many "previous bars ≥ current bars && upcoming bars ≥ current bars"
         * for example, [6,2,5,4,1,5,6]
         * --------------------------------------------
         * at index : 4
         * current = 4
         * in first loop it loops through previous (5,2,6)
         *      - (5 ≥ 4) --> curr += 4
         *      - break
         * in second loop it loops through next (1,5,6)
         *      - break
         * current = 8
         * --------------------------------------------
         * at index : 5
         * current = 5
         * in first loop it loops through previous (1,4,5,2,6)
         *      - break
         * in second loop it loops through next (6)
         *      - (6 ≥ 5) --> curr += 5
         * current = 10
         * */
        int res = 0;
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            // loop through all previous bars till reaches first bar
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] >= arr[i]) current += arr[i];
                else break;
            }
            // loop through all next bars till the end
            for (int j = i+1; j < n; j++) {
                if(arr[j] >= arr[i]) current += arr[i];
                else break;
            }
            res = Math.max(res,current);
        }
        return res;
    }
    public static int efficientSolution(int[] arr, int n) {
        /**
         * Theta(n) & O(1)
         * */
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int top = stack.pop();
                int curr = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() -1) );
                res = Math.max(res,curr);
            }
            stack.push(i);
        }
        // processing remaining elements of stack
        while(!stack.isEmpty()) {
            int top = stack.pop();
            int curr = arr[top] * (stack.isEmpty() ? n : (n - stack.peek() -1) );
            res = Math.max(res,curr);
        }
        return res;
    }
}
