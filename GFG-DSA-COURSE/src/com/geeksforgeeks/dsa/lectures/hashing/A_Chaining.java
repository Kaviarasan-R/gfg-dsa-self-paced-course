/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class A_Chaining {
    static int BUCKET;
    static ArrayList<LinkedList<Integer>> hashtable;

    public static void main(String[] args) {
        hashFunction();
        System.out.println(search(25));
        System.out.println(search(56));
        System.out.println(Arrays.toString(hashtable.toArray()));
    }
    static void hashFunction() {
        BUCKET = 7; // prime number
        hashtable = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < BUCKET; i++) {
            hashtable.add(new LinkedList<Integer>());
        }
        insert(50);
        insert(21);
        insert(58);
        insert(17);
        insert(15);
        insert(49);
        insert(56);
        insert(22);
        insert(23);
        insert(25);
        delete(56);
    }
    static void insert(int key) {
        int i = key % BUCKET;
        hashtable.get(i).add(key);
    }
    static boolean search(int key) {
        int i = key % BUCKET;
        return hashtable.get(i).contains(key);
    }
    static void delete(int key) {
        int i = key % BUCKET;
        int keyIdx = hashtable.get(i).indexOf((Integer) key);
        hashtable.get(i).remove(keyIdx);
    }

}
