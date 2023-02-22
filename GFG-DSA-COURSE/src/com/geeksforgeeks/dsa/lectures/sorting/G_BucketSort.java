/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class G_BucketSort {
    public static void main(String[] args) {
        int[] arr = {30,40,10,80,5,12,70};
        naiveSolution(arr,4);
    }
    public static void naiveSolution(int[] arr, int k) {
        int n = arr.length;
        int max_val = arr[0];
        // Get maximum value in the array
        for (int i = 1; i < n; i++) {
            max_val = Math.max(max_val,arr[i]);
        }
        max_val++;
        // Create empty bucket
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
        // Create required k buckets inside main bucket
        for (int i = 0; i < k; i++) {
            bucket.add(new ArrayList<Integer>());
        }
        // Fill the buckets with appropriate values
        // i = 0 : bucket = 4 * 30 / 81 = 1
        // Put 30 number (index 0) to bucket 1
        for (int i = 0; i < n; i++) {
            int bucketID = (k * arr[i]) / max_val;
            bucket.get(bucketID).add(arr[i]);
        }
        // Sort each buckets inside main bucket
        for (int i = 0; i < k; i++) {
            Collections.sort(bucket.get(i));
        }
        // Join all buckets together
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                arr[index++] = bucket.get(i).get(j);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
