/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class F_SquareRoot {
    public static void main(String[] args) {
        /**
         * Input : 4
         * 1,2,3,4
         * 1 sq. ≤ 1
         * 2 sq. ≤ 4
         * 3 sq. ≠ 4
         * 4 sq. ≠ 4
         * Output : 2
         **/
        int x = 9;
        System.out.println(naiveSolution(x));
        System.out.println(efficientSolution(x));
    }
    public static int naiveSolution(int x) {
        // O (¬N)
        int i = 1;
        while(i*i <= x) {
            i++;
        }
        return (i-1);
    }
    public static int efficientSolution(int x) {
        // O ( LOG N )
        int low = 1;
        int high = x;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int sq = mid * mid;
            if(sq == x) return mid;
            else if(sq > x) high = mid - 1;
            else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
