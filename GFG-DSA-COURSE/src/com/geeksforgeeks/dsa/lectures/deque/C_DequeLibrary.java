/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.deque;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class C_DequeLibrary {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(10); //addFirst() --> throws exception
        deque.offerLast(20);  //addLast()
        deque.offerFirst(5);
        deque.offerLast(15);
        System.out.println(deque.peekFirst()); //getFirst()
        System.out.println(deque.peekLast());  //getLast()
        deque.pollFirst(); //removeFirst()
        deque.pollLast();  //removeLast()
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        // print using iterator
        Iterator iterator = deque.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        // print using for each loop
        for (int x : deque) {
            System.out.print(x + " ");
        }
        System.out.println();
        // print deque in reverse
        Iterator it = deque.descendingIterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
