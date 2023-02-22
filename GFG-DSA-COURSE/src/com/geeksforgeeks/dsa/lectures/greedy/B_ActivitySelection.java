/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class B_ActivitySelection {
    public static void main(String[] args) {
        // IT CAN BE SOLVED USING LONGEST INCREASING SUBSEQUENCE
        /*
        ArrayList<Pair> arr = new ArrayList<>();
        arr.add(new Pair(3,8));
        arr.add(new Pair(2,4));
        arr.add(new Pair(1,3));
        arr.add(new Pair(10,11));
         **/
        ArrayList<Pair> arr = new ArrayList<>();
        arr.add(new Pair(12,25));
        arr.add(new Pair(10,20));
        arr.add(new Pair(20,30));
        Collections.sort(arr, new PairComparator());
        int n = arr.size();
        int index = 0;
        Pair[] solution = new Pair[n];
        solution[index] = arr.get(0);
        for (int i = 1; i < n; i++) {
            if(arr.get(i).start >= solution[index].finish) {
                index++;
                solution[index] = arr.get(i);
            }
        }
        for (Pair x : solution) {
            if(x != null) System.out.println("[ " + x.start + "," + x.finish + " ]");
        }
        System.out.println(index+1);
    }
    static class Pair {
        int start;
        int finish;
        public Pair(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    static class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            // SORT ACCORDING TO FINISH.
            return p1.finish - p2.finish;
        }
    }
}
