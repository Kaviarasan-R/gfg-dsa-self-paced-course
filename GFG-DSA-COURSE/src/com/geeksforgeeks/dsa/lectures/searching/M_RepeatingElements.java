/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.searching;

public class M_RepeatingElements {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,6,5,7,3};
        System.out.println(efficientSolution(arr,arr.length-1));
    }
    // NAIVE SOLUTIONS ARE :
    // 1.   a. Sort the array
    //      b. Search if previous element is same as current element
    // 2.   a. Create boolean array of size n
    //      b. Set visited elements true & if it's already visited return the index
    public static int efficientSolution(int[] arr, int n) {
        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow != fast);
        slow = arr[0];
        while(slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}
