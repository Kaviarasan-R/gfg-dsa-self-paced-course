/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.trie;

public class A_Trie {
    static final int ALPHABET_SIZE = 26;
    static TrieNode root;
    public static void main(String[] args) {
        String[] str = {"bad","bat","geek","geeks","cat","cut","zoo"};
        root = new TrieNode();
        for (String s : str) {
            insert(s);
        }
        System.out.println("SEARCH : " + search("bad"));
        System.out.println("SEARCH : " + search("bat"));
        delete(root,"bat",0);
    }
    public static void insert(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
            }
            curr = curr.child[index];
        }
        curr.isEnd = true;
    }
    public static boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if(curr.child[index] == null) return false;
            curr = curr.child[index];
        }
        return curr.isEnd;
    }
    public static TrieNode delete(TrieNode root, String key, int i) {
        if(root == null) {
            return null;
        }
        if(i == key.length()) {
            root.isEnd = false;
            if(isEmpty(root)) root = null; // ONLY MAKES THE ROOT NULL IF ITS CHILD IS NULL
            System.out.println("DELETE : true");
            return root;
        }
        int index = key.charAt(i) - 'a';
        root.child[index] = delete(root.child[index], key, i+1);
        if(isEmpty(root) && !root.isEnd) root = null;
        return root;
    }
    public static boolean isEmpty(TrieNode root) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if(root.child[i] != null) return false;
        }
        return true;
    }
    static class TrieNode {
        TrieNode[] child = new TrieNode[ALPHABET_SIZE];
        boolean isEnd;
        TrieNode(){
            isEnd = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                child[i] = null;
        }
    }
}
