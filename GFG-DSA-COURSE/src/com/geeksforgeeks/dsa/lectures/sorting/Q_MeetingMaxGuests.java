/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.util.Arrays;

public class Q_MeetingMaxGuests {
    public static void main(String[] args) {
        int[] arrival = {900,600,700};
        int[] departure = {1000,800,730};
        // 9:00 10:00 7:30
        /*
        * Sort the arrival & departure must be sorted.
        * 600 A 1
        * 700 A 2 --> maximum guests at 700 (return 2)
        * 730 D 1
        * 800 D 0
        * 900 A 1
        * 1000 D 0
        */
        System.out.println(efficientSolution(arrival,departure,arrival.length));
    }
    public static int efficientSolution(int[] arrival, int[] departure, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i = 1;
        int j = 0;
        int res = 1;
        int current = 1;
        while(i < n && j < n) {
            if(arrival[i] <= departure[j]) {
                current++;
                i++;
            }
            else {
                current--;
                j++;
            }
            res = Math.max(current,res);
        }
        return res;
    }
}
