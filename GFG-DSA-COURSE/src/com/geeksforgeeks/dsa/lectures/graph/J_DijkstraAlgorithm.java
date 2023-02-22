/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.Arrays;

public class J_DijkstraAlgorithm {
    public static void main(String[] args) {
        /** SHORTEST PATH FINDER WITH WEIGHTS */
        int[][] graph = {{0,50,100,0},{50,0,30,200},{100,30,0,20},{0,200,20,0}};
        int src = 0;
        int[] res = dijkstra(graph,src);
        System.out.println(Arrays.toString(res));
    }
    public static int[] dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        boolean[] fin = new boolean[V]; // finalized
        /**
         dist = {INF,INF,INF,INF}
         fin = {F,F,F,F}
         **/
        for (int count = 0; count < V-1; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if(!fin[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            fin[u] = true;
            for (int v = 0; v < V; v++) {
                if(!fin[v] && graph[u][v] != 0) {
                    dist[v] = Math.min(dist[v],dist[u] + graph[u][v]); // relax operation
                }
            }
        }
        return dist;
    }
}
