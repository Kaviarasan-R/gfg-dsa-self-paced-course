/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.*;

public class G_TopologicalSorting {
    public static void main(String[] args) {
        int v = 6;
        int[] indegree = new int[v-1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        System.out.println("DIRECTED GRAPH : ");
        addEdge(adj,0,1,indegree);
        addEdge(adj,1,3,indegree);
        addEdge(adj,2,3,indegree);
        addEdge(adj,2,4,indegree);
        addEdge(adj,3,4,indegree);
        printGraph(adj);
        findIndegree(adj,indegree);
        System.out.println("INDEGREE : " + Arrays.toString(indegree));
        System.out.print("BFS : ");
        KhansBFSAlgorithm(adj,v,indegree);
        DFSIterative(adj,v);
    }
    public static void findIndegree(ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        for (int i = 0; i < adj.size()-1; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)]++;
            }
        }
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v, int[] indegree) {
        adj.get(u).add(v);
        //indegree[v]++;
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
    public static void KhansBFSAlgorithm(ArrayList<ArrayList<Integer>> adj, int v, int[] indegree) {
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
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v-1; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for(int x : adj.get(u)) {
                indegree[x]--;
                if(indegree[x] == 0) queue.add(x);
            }
        }
    }
    public static void DFSIterative(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v-1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v-1; i++) {
            if(!visited[i]) {
                DFSRecursive(adj,i,visited,stack);
            }
        }
        System.out.print("\nDFS : ");
        while(!stack.isEmpty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }
    public static void DFSRecursive(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if(!visited[v]) DFSRecursive(adj,v,visited,stack);
        }
        stack.push(u);
    }
}
