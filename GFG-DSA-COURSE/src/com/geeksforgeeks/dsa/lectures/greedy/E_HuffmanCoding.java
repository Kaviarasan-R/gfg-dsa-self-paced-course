/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.greedy;

import java.util.PriorityQueue;

public class E_HuffmanCoding {
    public static void main(String[] args) {
        char[] arr = {'a','d','e','f'};
        int[] freq = {30,40,80,60};
        printHuffManCodes(arr,freq);
    }
    static void printHuffManCodes(char[] arr, int[] freq) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
                (n1,n2) -> n1.freq - n2.freq
        );
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(new Node(arr[i],freq[i],null,null));
        }
        while(minHeap.size() > 1) {
            Node l = minHeap.poll();
            Node r = minHeap.poll();
            minHeap.add(new Node('$',l.freq+ r.freq,l,r));
        }
        printRecursive(minHeap.peek(),"");
    }
    static void printRecursive(Node root, String s) {
        if(root.ch != '$') {
            System.out.println(root.ch + " " + s);
            return;
        }
        printRecursive(root.left,s+"0");
        printRecursive(root.right,s+"1");
    }
    static class Node {
        char ch;
        int freq;
        Node left;
        Node right;
        Node(char c, int f, Node l, Node r) {
            ch = c;
            freq = f;
            left = l;
            right = r;
        }
    }
}
