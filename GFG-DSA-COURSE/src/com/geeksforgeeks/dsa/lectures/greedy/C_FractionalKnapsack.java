/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.greedy;

import java.util.Arrays;

public class C_FractionalKnapsack {
    public static void main(String[] args) {
        Item[] arr = {
                new Item(10,60),
                new Item(40,40),
                new Item(20,100),
                new Item(30,120)
        };
        int W = 50;
        System.out.println(fractionalKnapsack(arr,W));
    }
    public static double fractionalKnapsack(Item[] arr, int W) {
        Arrays.sort(arr);
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].weight <= W) {
                res += arr[i].value;
                W -= arr[i].weight;
            } else {
                res += arr[i].value * (double) W/ (double) arr[i].weight;
                break;
            }
        }
        return res;
    }
    static class Item implements Comparable<Item> {
        int weight;
        int value;
        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        public int compareTo(Item i) {
            /*
                i.value         this.value
                -------    -    ----------
                i.weight        this.weight
            */
            return ((this.weight) * (i.value)) - ((i.weight) * (this.value));
        }
    }
}
