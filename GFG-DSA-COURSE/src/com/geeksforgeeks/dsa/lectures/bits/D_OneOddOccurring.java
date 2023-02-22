/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.bits;

public class D_OneOddOccurring {
    public static void main(String[] args) {
        /**
        * [] = {4,3,4,4,4,5,5}
        * 4 appears 4 times, 5 appears 2 times and 3 appears 1 time.
        * OP : 3
        */
        int[] arr = {4,3,4,4,4,5,5};
        System.out.println(oneOddOccurringNaive(arr,arr.length));
        System.out.println(oneOddOccurringEfficient(arr,arr.length));
        System.out.println("--------------------------------");
        int[] range = {1,5,3,2};
        System.out.println(findMissingValueFromRange(range,range.length));
    }
    // NAIVE SOLUTION
    public static int oneOddOccurringNaive(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[i] == arr[j]) count++;
            }
            if(count % 2 != 0) return arr[i];
        }
        return -1;
    }
    // USING NOR OPERATOR
    public static int oneOddOccurringEfficient(int[] arr, int n) {
        /**
        * i = 0 : 0 ^ 4
        * i = 1 : 4 ^ 3
        * i = 2 : 4 ^ 3 ^ 4
        * i = 3 : 3 ^ 4
        * i = 4 : 3 ^ 4 ^ 4
        * i = 5 : 3 ^ 5
        * i = 6 : 3 ^ 5 ^ 5
        * res : 3
        */
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ arr[i];
        }
        return res;
    }
    // VARIATION QUESTION
    public static int findMissingValueFromRange(int[] arr, int n) {
        /**
        * [] = {1,5,3,2}
        * OP : 4 --> (missing from 1 to 5)
        *
        * find min and max from range.
        * start loop from min and loop until total length from arr.
        * add (NOR) remaining values from ranges to res.
        * i = 0 : 0 > 3 : 0 ^ 1 ^ 1 ---> 0
        * i = 1 : 1 > 3 : 0 ^ 2 ^ 5
        * i = 2 : 2 > 3 : 2 ^ 5 ^ 2 ^ 3 ---> 5 ^ 3
        * i = 3 : 3 > 3 : 5 ^ 3 ^ 3  ---> 5
        *
        * Add remaining values to res.
        * i = 4 : 5 ^ 4
        * i = 5 : 5 ^ 4 ^ 5 ---> 4
        *
        */
        int res = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
        }
        int i = min;
        for (; i <= max ; i++) {
            if(index > (n-1)) break;
            res = res ^ i ^ arr[index];
            index++;
        }
        while(i <= max) {
            res = res ^ i;
            i++;
        }
        return res;
    }
}
