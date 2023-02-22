/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class F_DetectCycleDirected {
    public static void main(String[] args) {
        int v = 7;
        int[] indegree = new int[v-1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        System.out.println("DIRECTED GRAPH : ");
        addEdge(adj,0,1);
        addEdge(adj,2,1);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        addEdge(adj,5,3);
        printGraph(adj);
        System.out.println("Cycle Detection Using DFS : " + detectCycleDFS(adj,v));
        findIndegree(adj,indegree);
        System.out.println("INDEGREE : " + Arrays.toString(indegree));
        System.out.println("Cycle Detection Using Khan's BFS : " + KhansBFSAlgorithm(adj,v,indegree));
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size()-1; i++) {
            System.out.print(i + " --> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static boolean DFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recursiveCallStack) {
        /** We'll return true, when ancestors of recursive stack has already been true
            for the child fn calls.
            Here, at fn(5) --> the adjacent of 5 is 3. The 3 is already in a stack, so return true.
         */
        visited[s] = true;
        recursiveCallStack[s] = true;
        for(int u : adj.get(s)) {
            if(!visited[u] && DFS(adj,u,visited,recursiveCallStack)) return true;
            else if(recursiveCallStack[u]) return true;
        }
        recursiveCallStack[s] = false;
        return false;
    }
    public static boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        boolean[] stack = new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!visited[i]) {
                if(DFS(adj,i,visited,stack)) return true;
            }
        }
        return false;
    }
    public static void findIndegree(ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        for (int i = 0; i < adj.size()-1; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)]++;
            }
        }
    }
    public static boolean KhansBFSAlgorithm(ArrayList<ArrayList<Integer>> adj, int v, int[] indegree) {
        /**
         * 1. Store indegree of every vertex
         * 2. Create a Queue
         * 3. Add all 0 indegree vertices to the queue
         * 4. while(queue is not empty) :
         *      a)  u = q.poll()
         *      b) print u
         *      c) for every adjacent of v of u
         *          i)  reduce indegree of v by 1
         *          ii) If indegree of v becomes 0, add v to q
         * */
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v-1; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int x : adj.get(u)) {
                indegree[x]--;
                if(indegree[x] == 0) queue.add(x);
            }
            count++;
        }
        return count != (v-1);
    }
}
