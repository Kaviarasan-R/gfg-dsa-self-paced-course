/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.deque;

public class E_FirstCircularTour {
    public static void main(String[] args) {
        int[] petrol = {4,8,7,4};
        int[] distance = {6,5,3,5};
        /**
         * petrol pump's are 4, 8, 7, 4
         * petrol pump's distance from one to another petrol pump it is a circular array.
         * petrol[] = {4,8}
         * dist[] = {5,6}
         * {4,8} --> 5 (distance)
         * {8,4} --> 6 (distance)
         * at petrol pump (4) we can fill 4 liters of petrol, we should travel 5km distance with 4 liters.
         * 4 liters is not enough to travel from { 4 to 8 } because 4 liters is smaller than 5 km distance.
         * at petrol pump (8) we can fill 8 liters of petrol, we should travel from 8 to 4 with 8 liters.
         * now, the distance of {8,4} is 6. we can travel with 8 lts of petrol bcz the distance is 6km only.
         * return the possible way to start the travel. (return 2).
         * */
        System.out.println(naiveSolution(petrol,distance,petrol.length));
        System.out.println(efficientSolution(petrol,distance,petrol.length));
    }
    public static int naiveSolution(int[] petrol, int[] distance, int n) {
        for (int start = 0; start < n; start++) {
            int current_petrol = 0;
            int end = start;
            while(true) {
                current_petrol += (petrol[end] - distance[end]);
                if(current_petrol < 0) {
                    break;
                }
                end = (end+1) % n;
                if(end == start) {
                    return (start + 1);
                }
            }
        }
        return -1;
    }
    public static int efficientSolution(int[] petrol, int[] distance, int n) {
        int start = 0;
        int current_petrol = 0;
        int previous_petrol = 0;
        for (int i = 0; i < n; i++) {
            current_petrol += (petrol[i] - distance[i]);
            if(current_petrol < 0) {
                start = i+1;
                previous_petrol += current_petrol;
                current_petrol = 0;
            }
        }
        return (current_petrol + previous_petrol) >= 0 ? start+1 : -1;
    }
}
