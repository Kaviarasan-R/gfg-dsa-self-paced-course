/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.linkedlist;

import java.util.*;

public class S_LRUCacheDesign {

    private Deque<Integer> doublyQueue;
    private HashSet<Integer> hashSet;
    private final int CACHE_SIZE;
    S_LRUCacheDesign(int capacity) {
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    public void refer(int page) {
        if (!hashSet.contains(page)) { // if data is miss, then add it to head of DLL
            if (doublyQueue.size() == CACHE_SIZE) { // if cache size exceeds then delete last node
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        }
        else { // if data is hit, remove the data at any position
            doublyQueue.remove(page);
        }
        // add the data to the head of the DLL
        doublyQueue.push(page);
        hashSet.add(page);
    }

    public void display() {
        Iterator<Integer> itr = doublyQueue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args) {
        S_LRUCacheDesign cache = new S_LRUCacheDesign(4);
        cache.refer(10);
        cache.refer(20);
        cache.refer(10);
        cache.refer(30);
        cache.refer(40);
        cache.refer(50);
        cache.refer(30);
        cache.refer(40);
        cache.refer(60);
        cache.refer(30);
        cache.display();
    }
}
