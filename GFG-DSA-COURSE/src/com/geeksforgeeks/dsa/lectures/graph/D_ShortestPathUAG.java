/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D_ShortestPathUAG {
    public static void main(String[] args) {
        /**
                  |```````````|
            0 --- 1 --- 2 --- 3
            |___________|
         **/
        int v = 5;
        int s = 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        A_AdjacencyList.addEdge(adj,0,1);
        A_AdjacencyList.addEdge(adj,0,2);
        A_AdjacencyList.addEdge(adj,1,2);
        A_AdjacencyList.addEdge(adj,1,3);
        A_AdjacencyList.addEdge(adj,2,3);
        System.out.println("GRAPH : ");
        A_AdjacencyList.printGraph(adj);
        ShortestPath(adj,s,v);
    }
    public static void ShortestPath(ArrayList<ArrayList<Integer>> adj, int s, int v) {
        boolean[] visited = new boolean[v];
        int[] dist = new int[v-1];
        dist[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for (int x : adj.get(u)) {
                if(!visited[x]) {
                    dist[x] = dist[u]+1; // new line added to BFS
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
        System.out.println("SHORTEST PATH : " + Arrays.toString(dist));
    }
}
