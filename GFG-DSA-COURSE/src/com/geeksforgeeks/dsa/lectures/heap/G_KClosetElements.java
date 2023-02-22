/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class G_KClosetElements {
    public static void main(String[] args) {
        int[] arr = {10,15,7,3,4};
        int x = 8;
        int k = 2;
        // k closet number to x; if number itself present then, it is the first closet.
        naiveSolution(arr,x,k);
        G_KClosetElements kClosetElements = new G_KClosetElements();
        kClosetElements.efficientSolution(arr,x,k);
    }

    // Theta(nk)
    public static void naiveSolution(int[] arr, int x, int k) {
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < k; i++) {
            int min_difference = Integer.MAX_VALUE;
            int min_difference_idx = 0;
            for (int j = 0; j < arr.length; j++) {
                if(!visited[j] && Math.abs(arr[j]-x) <= min_difference) {
                    min_difference = Math.abs(arr[j]-x);
                    min_difference_idx = j;
                }
            }
            System.out.println(arr[min_difference_idx] + " ");
            visited[min_difference_idx] = true;
        }
    }

    //O (n logk)
    public void efficientSolution(int[] arr, int x, int k) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new PairComparator());
        // O (k logk)
        for (int i = 0; i < k; i++) {
            priorityQueue.add(new Pair(Math.abs(arr[i]-x),i));
        }
        // O ((n-k) * logk)
        for (int i = k; i < arr.length; i++) {
            int diff = Math.abs(arr[i]-x);
            if(priorityQueue.peek().diff > diff) {
                priorityQueue.poll();
                priorityQueue.add(new Pair(diff,i));
            }
        }
        // O (k logk)
        for (int i = 0; i < k; i++) {
            System.out.print(arr[priorityQueue.poll().index] + " ");
        }
    }
    class Pair {
        int diff;
        int index;
        Pair(int differ, int index) {
            this.diff = differ;
            this.index = index;
        }
    }

    class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.diff < o2.diff) {
                return 1;
            } else if (o1.diff > o2.diff) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

