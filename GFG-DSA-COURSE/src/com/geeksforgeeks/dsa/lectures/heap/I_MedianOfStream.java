/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class I_MedianOfStream {
    public static void main(String[] args) {
        int[] arr = {25,7,10,15,20};
        /**
         * sequence         :   median
         * {25}             :   25
         * {25,7}           :   (25+7) / 2 = 16
         * {25,7,10}        :   10 --> {when arr is odd, sorted arr [7,10,25] return the middle}
         * {25,7,10,15}     :   sort the arr [7,10,15,25] --> return avg of middle two (10+15) / 2 = 12.5
         * {25,7,10,15,20}  :   sort the arr [7,10,15,20,25] --> return middle 15

         * output : [25,16,10,12.5,15]
         **/
        naiveSolution(arr,arr.length);
        System.out.println("\n");
        efficientSolution(arr,arr.length);
    }
    // O (n * n)
    public static void naiveSolution(int[] arr, int n) {
        int size = 0;
        for (int i = 0; i < n; i++) {
            int[] temp = new int[i+1];
            for (int j = 0; j <= i; j++) {
                temp[j] = arr[j];
            }
            Arrays.sort(temp);
            size = temp.length;
            //System.out.println(Arrays.toString(temp) + " " + size);
            if((size%2) != 0) {
                System.out.print((double) temp[size/2] + " ");
            } else {
                System.out.print((double) (temp[size/2] + temp[(size-1)/2]) / 2 + " ");
            }
        }
    }
    // O (n logn)
    public static void efficientSolution(int[] arr, int n) {
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> greater = new PriorityQueue<>();
        smaller.add(arr[0]);
        System.out.print(smaller.peek() + " ");
        for (int i = 1; i < n; i++) {
            int x = arr[i];
            if(smaller.size() > greater.size()) {
                if(smaller.peek() > x) {
                    greater.add(smaller.poll());
                    smaller.add(x);
                } else {
                    greater.add(x);
                }
                System.out.print((double) ((smaller.peek() + greater.peek())/2) + " ");
            } else {
                if(x <= smaller.peek()) {
                    smaller.add(x);
                } else {
                    greater.add(x);
                    smaller.add(greater.poll());
                }
                System.out.print(smaller.peek() + " ");
            }
        }
    }
}
