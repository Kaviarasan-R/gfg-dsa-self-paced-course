/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.greedy;

import java.util.Arrays;
import java.util.Collections;

public class A_MinCoins {
    public static void main(String[] args) {
        Integer[] coins = {5,10,2,1};
        int amount = 57;
        Arrays.sort(coins, Collections.reverseOrder());
        int res = 0;
        for (Integer coin : coins) {
            if (coin <= amount) {
                int c = (int) Math.floor(amount / coin);
                res += c;
                amount -= c * coin;
            }
            if (amount == 0) break;
        }
        System.out.println(res);
    }
}
