/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class H_MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arr = {{10,20,30},{5,15},{1,9,11,18}};
        H_MergeKSortedArrays efficientSolution = new H_MergeKSortedArrays();
        efficientSolution.efficientSolution(arr,arr.length);
    }
    public void efficientSolution(int[][] arr, int n) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new PairComparator());
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new Pair(arr[i][0],i,0));
        }
        while(!priorityQueue.isEmpty()) {
            int row = priorityQueue.peek().row;
            int col = priorityQueue.peek().col;
            res.add(priorityQueue.poll().value);
            if(col+1 < arr[row].length) {
                priorityQueue.add(new Pair(arr[row][col+1],row,col+1));
            }
        }
        System.out.println(res);
    }
    class Pair {
        int value;
        int row;
        int col;
        Pair(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    class PairComparator implements Comparator<H_MergeKSortedArrays.Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.value > o2.value) {
                return 1;
            } else if (o1.value < o2.value) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
