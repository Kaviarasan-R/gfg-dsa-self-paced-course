/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.greedy;

import java.util.Arrays;

public class D_JobSequencing {
    public static void main(String[] args) {
        /*
        Job[] jobs = {
                new Job(4,50),
                new Job(1,5),
                new Job(1,20),
                new Job(5,10),
                new Job(5,80),
        };
        **/
        Job[] jobs = {
                new Job(2,100),
                new Job(1,50),
                new Job(2,10),
                new Job(1,20),
                new Job(3,30),
        };
        Arrays.sort(jobs);
        int n = Integer.MIN_VALUE;
        for (Job j : jobs) n = Math.max(n,j.deadline);
        int[] res = new int[n];
        res[jobs[0].deadline-1] = jobs[0].profit; // INITIALIZE FIRST SORTED VALUE TO RES
        for (int i = 1; i < jobs.length; i++) {
            int k = jobs[i].deadline-1;
            if(res[k] == 0) { // IF SPACE IS NOT OCCUPIED
                res[k] = jobs[i].profit;
            } else { // IF SPACE IS OCCUPIED
                for (int j = k; j >= 0; j--) {
                    if(res[j] == 0) {
                        res[j] = jobs[i].profit;
                        break;
                    }
                }
            }
        }
        int profit = 0;
        for (int i : res) profit += i;
        System.out.println(Arrays.toString(res));
        System.out.println(profit);
    }
    static class Job implements Comparable<Job> {
        int deadline;
        int profit;
        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
        public int compareTo(Job i) {
            return i.profit - this.profit;
        }
    }
}
