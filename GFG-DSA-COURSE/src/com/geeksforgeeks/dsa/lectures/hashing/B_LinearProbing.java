/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.Arrays;

public class B_LinearProbing {
    static int[] arr;
    static int capacity;
    static int size;
    public static void main(String[] args) {
        hashInitFunction(7);
        insert(68);
        insert(49);
        insert(50);
        insert(63);
        insert(64);
        System.out.println("63" + " >> " +search(63));
        System.out.println("52" + " >> " +search(52));
        System.out.println("Before Deletion : " + Arrays.toString(arr));
        System.out.println("50" + " >> " +delete(50));
        System.out.println("After Deletion : " + Arrays.toString(arr));
    }
    static void hashInitFunction(int c) {
        capacity = c;
        size = 0;
        arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = -1;
        }
    }
    static int hashFunction(int key) {
        return key % capacity;
    }
    static boolean search(int key) {
        int h = hashFunction(key);
        int i = h;
        while(arr[i] != -1) {
            if(arr[i] == key) return true; // when key is matching
            i = (i+1) % capacity; // circularly searching
            if(i == h) return false; // when index again comes to hash value
        }
        return false;
    }
    static boolean insert(int key) {
        if(size == capacity) {
            return false;
        }
        int i = hashFunction(key);
        // -1 --> empty
        // -2 --> deleted
        // third condition is when key is already present
        while(arr[i] != -1 && arr[i] != -2 && arr[i] != key) {
            i = (i+1) % capacity;
        }
        if(arr[i] == key) {
            return false;
        } else {
            // inserting the keys & increase the size
            arr[i] = key;
            size++;
            return true;
        }
    }
    static boolean delete(int key) {
        int h = hashFunction(key);
        int i = h;
        while(arr[i] != -1) {
            if(arr[i] == key) {
                arr[i] = -2;
            }
            i = (i+1) % capacity;
            if(i == h) return false;
        }
        return false;
    }
}
