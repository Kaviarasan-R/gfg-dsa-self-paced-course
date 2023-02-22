/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.*;
import java.util.LinkedList;

class K_KosarajuAlgorithm {
    /** STRONGLY CONNECTED COMPONENTS */
    private int V;
    private LinkedList<Integer>[] adj;

    K_KosarajuAlgorithm(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v,boolean visited[]) {

        visited[v] = true;
        System.out.print(v + " ");

        int n;

        Iterator<Integer> i =adj[v].iterator(); // IT ACTUALLY CHECKS IN REVERSED GRAPH
        while (i.hasNext()) {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }

    public K_KosarajuAlgorithm getReverseDirection() {
        K_KosarajuAlgorithm g = new K_KosarajuAlgorithm(V);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack) {
        visited[v] = true;

        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if(!visited[n]) {
                fillOrder(n, visited, stack);
            }
        }

        stack.push(v);
    }

    void printSCCs() {
        Stack stack = new Stack();

        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++) visited[i] = false;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        K_KosarajuAlgorithm gr = getReverseDirection();

        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        while (stack.empty() == false) {
            int v = (int)stack.pop();

            if (visited[v] == false) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        K_KosarajuAlgorithm g = new K_KosarajuAlgorithm(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components in given graph");
        g.printSCCs();
    }
}

