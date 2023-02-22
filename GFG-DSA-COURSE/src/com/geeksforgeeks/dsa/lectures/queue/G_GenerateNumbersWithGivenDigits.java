/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class G_GenerateNumbersWithGivenDigits {
    public static void main(String[] args) {
        /**
         * Given a number n, print first n numbers (in increasing order) such that all these
         * numbers have digits in set {5,6} only.
         * input : 10
         * output : 5,6,55,56,65,66,555,556,565,566
         * input : 4
         * output : 5,6,55,56
         * */
        efficientSolution(10);
    }
    public static void efficientSolution(int n) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("5");
        queue.offer("6");
        for (int count = 0; count < n; count++) {
            String current = String.valueOf(queue.poll());
            System.out.print(current + " ");
            queue.offer(current+"5");
            queue.offer(current+"6");
        }
    }
}
