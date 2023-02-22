/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.*;
import java.util.LinkedList;

class N_FindBridges {
    /** If you remove an edge, then no of connected components is > 1 is called bridge. */
    private int V;

    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    N_FindBridges(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }


    void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext()) {
            int v = i.next();
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    System.out.println(u + " " + v);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    void bridge() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                bridgeUtil(i, visited, disc, low, parent);
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("Bridges in first graph ");
        N_FindBridges g = new N_FindBridges(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.bridge();
    }
}