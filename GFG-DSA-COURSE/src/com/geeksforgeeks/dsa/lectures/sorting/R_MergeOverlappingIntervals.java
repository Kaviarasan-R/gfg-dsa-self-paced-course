/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class R_MergeOverlappingIntervals {
    public static void main(String[] args) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(1,3);
        arr[1]=new Interval(2,4);
        arr[2]=new Interval(5,7);
        arr[3]=new Interval(6,8);
        // arr[] = {{1,3},{2,4},{5,7},{6,8}}
        // [1,3] & [2,4] can be merged because 2 lies in between [1,3]
        // [1,2,3,4],[5,6,7,8] --> [1,4],[5,8]
        efficientSolution(arr);
    }
    public static void efficientSolution(Interval[] arr) {
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[res].end >= arr[i].start) {
                arr[res].start = Math.min(arr[res].start,arr[i].start);
                arr[res].end = Math.max(arr[res].end,arr[i].end);
            } else {
                res++;
                arr[res] = arr[i];
            }
        }
        for (int i = 0; i <= res; i++) {
            System.out.println(arr[i].start + " " + arr[i].end);
        }
    }
    static class Interval {
        int start,end;
        Interval(int start, int end) {
            this.start=start;
            this.end=end;
        }
    }
}

