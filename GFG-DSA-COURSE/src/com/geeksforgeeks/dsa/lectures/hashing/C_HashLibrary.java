/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class C_HashLibrary {
    public static void main(String[] args) {
        System.out.println("------------------HASHSET------------------");
        hashSet();
        System.out.println("\n------------------HASHMAP------------------");
        hashMap();
    }
    public static void hashSet() {
        // it used to store keys
        HashSet<String> hashtable = new HashSet<>();
        hashtable.add("gfg");
        hashtable.add("courses");
        hashtable.add("dsa");
        Iterator<String> iterator = hashtable.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n"+hashtable);
        System.out.println(hashtable.contains("dsa"));
        System.out.println(hashtable.size());
        hashtable.remove("courses");
        for(String str : hashtable) {
            System.out.print(str + " ");
        }
        /** hashtable.clear(), hashtable.isEmpty() */
    }
    public static void hashMap() {
        // it used to store key value pairs
        HashMap<String, Integer> hashtable = new HashMap<>(10);
        hashtable.put("gfg",10);
        hashtable.put("courses",15);
        hashtable.put("dsa",20);
        System.out.println(hashtable);
        System.out.println(hashtable.size());
        for (Map.Entry<String, Integer> e : hashtable.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        if(hashtable.containsKey("dsa")) {
            System.out.println(hashtable.get("dsa"));
        } else {
            System.out.println("'dsa' key not found");
        }
        hashtable.remove("dsa");
    }
}
