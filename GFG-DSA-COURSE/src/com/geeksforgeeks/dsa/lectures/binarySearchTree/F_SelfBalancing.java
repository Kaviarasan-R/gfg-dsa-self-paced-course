/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.binarySearchTree;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class F_SelfBalancing {
    public static void main(String[] args) {
        treeSetString();
        System.out.println();
        treeSetInteger();
        treeMap();
    }
    public static void treeSetString() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("gfg");
        treeSet.add("courses");
        treeSet.add("ide");
        System.out.println(treeSet);
        treeSet.remove("courses");
        System.out.println(treeSet.contains("ide"));
        Iterator<String> setIterator = treeSet.iterator();
        while(setIterator.hasNext()) System.out.print(setIterator.next() + " ");
    }
    public static void treeSetInteger() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(15);
        System.out.println(treeSet);
        System.out.println(treeSet.lower(5));
        System.out.println(treeSet.higher(5));
        System.out.println(treeSet.floor(4));
        System.out.println(treeSet.ceiling(12));
    }
    public static void treeMap() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(10,"geeks");
        treeMap.put(15,"ide");
        treeMap.put(5,"courses");
        System.out.println(treeMap);
        System.out.println(treeMap.containsKey(10));
        System.out.println(treeMap.higherKey(10));
        System.out.println(treeMap.lowerKey(10));
        System.out.println(treeMap.floorKey(10));
        System.out.println(treeMap.ceilingKey(10));
        System.out.println(treeMap.higherEntry(10).getValue());
        System.out.println(treeMap.lowerEntry(10).getValue());
        System.out.println(treeMap.floorEntry(10).getValue());
        System.out.println(treeMap.ceilingEntry(10).getValue());
        for (Map.Entry<Integer,String> e : treeMap.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
