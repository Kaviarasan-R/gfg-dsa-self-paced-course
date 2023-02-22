/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class E_DetectCycleUndirected {
    public static void main(String[] args) {
        int v = 6;
        int s = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        /** NO CYCLE **/
        /*A_AdjacencyList.addEdge(adj,0,1);
        A_AdjacencyList.addEdge(adj,1,4);
        A_AdjacencyList.addEdge(adj,1,2);
        A_AdjacencyList.addEdge(adj,2,3);*/
        /** CYCLE **/
        A_AdjacencyList.addEdge(adj,0,1);
        A_AdjacencyList.addEdge(adj,1,2);
        A_AdjacencyList.addEdge(adj,1,3);
        A_AdjacencyList.addEdge(adj,2,3);
        A_AdjacencyList.addEdge(adj,2,4);
        A_AdjacencyList.addEdge(adj,4,5);
        System.out.println("GRAPH : ");
        A_AdjacencyList.printGraph(adj);
        System.out.println("Cycle Detection : " + detectCycleBFS(adj,v,s));
        System.out.println("Cycle Detection : " + detectCycleDFS(adj,v));
    }
    public static boolean detectCycleBFS(ArrayList<ArrayList<Integer>> adj, int v, int s) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for (int x : adj.get(u)) {
                if(!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                } else {
                    if(queue.size() > 0) {
                        if(queue.peek() == x) return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!visited[i]) {
                if(DFS(adj,i,visited,-1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean DFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int parent) {
        visited[s] = true;
        for(int u : adj.get(s)) {
            if(!visited[u]) {
                if(DFS(adj,u,visited,s)) return true;
            } else if(u != parent) return true;
        }
        return false;
    }
}
