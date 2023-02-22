/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.recursion;

public class H_SubsetSum {
    public static void main(String[] args) {
        /**
         * [] = {1,2,3}
         * sum = 6
         * OP : return number of subsets match the sum.
         * Subsets = [ {}, {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3} ]
         * Find sum from subsets which equals given sum : 6
         * {1,2,3} is the only subset match the sum 6
         * OP : 1
         */
        int[] arr = {10,20,15};
        int sum = 25;
        System.out.println(countSubsets(arr,3,sum));
    }
    public static int countSubsets(int[] arr, int n, int sum) {
        /**
         *                               {}                                             ---> N = 3
         *             -------------------------------------
         *             |                                   |
         *            {}                                  {15}                          ---> N = 2
         *      -------------                         ------------------
         *     |            |                         |                |
         *    {}          {20}                      {15}            {15,20}             ---> N = 1
         *   -------     --------                 --------        -----------
         *  |      |    |       |                |       |        |         |
         * {}    {10}  {20}  {20,10}            {15}  {15,10}  {15,20}  {15,20,10}      ---> N = 0
         *
         */

        /**
         * fn(arr,3,25)
         * |----------fn(arr,2,25)
         * |                |------fn(arr,1,25)
         * |                |        |---fn(arr,0,25)  = return 0
         * |                |        |---fn(arr,0,25-10) = return 0 (sum = 15)
         * |                |
         * |                |------fn(arr,1,25-20) = sum(5)
         * |                         |---fn(arr,0,5) = return 0
         * |                         |---fn(arr,0,5-10) = return 0 (sum = -5)
         * |
         * |----------fn(arr,2,25-15) (sum = 10)
         *                  |------fn(arr,1,10)
         *                  |        |---fn(arr,0,10) = return 0
         *                  |        |---fn(arr,0,10-10) = return 1 (sum = 0)
         *                  |
         *                  |------fn(arr,1,10-15) (sum = -5)
         *                           |---fn(arr,0,-5) = return 0
         *                           |---fn(arr,0,-5-10) = return 0 (sum = -15)
         */
        if(n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        return countSubsets(arr,n-1,sum) + countSubsets(arr,n-1,sum-arr[n-1]);
    }
}
