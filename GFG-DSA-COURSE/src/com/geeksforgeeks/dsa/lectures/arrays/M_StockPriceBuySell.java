/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.arrays;

public class M_StockPriceBuySell {
    public static void main(String[] args) {
        /**
         * [] -> {1,5,3,8,12}
         * OP : 13
         * buy at 1 & sell at 5 --> 5-1 = 4
         * buy at 3 & sell at 12 --> 12-3 = 9
         * maximum = 4 + 9 = 13
         **/
        int[] arr = {1,5,3,8,12};
        System.out.println(naiveSolution(arr,0,arr.length));
        System.out.println(efficientSolution(arr,arr.length));
    }
    public static int naiveSolution(int[] price, int start, int end) {
        if(end <= start) {
            return 0;
        }
        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i+1; j < end; j++) {
                if(price[j] > price[i]) {
                    int current_profit = price[j] - price[i] +
                            naiveSolution(price,start,i-1) + // left of i
                            naiveSolution(price,j+1,end); // right of j
                    profit = Math.max(profit,current_profit);
                }
            }
        }
        return profit;
    }
    public static int efficientSolution(int[] price, int n) {
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if(price[i] > price[i-1]) {
                profit += (price[i] - price[i-1]);
            }
        }
        return profit;
    }
}
