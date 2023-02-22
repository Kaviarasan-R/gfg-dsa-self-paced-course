/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B_BFS {
    public static void main(String[] args) {
        BFSConnected();
        BFSDisconnected();
        /** COUNTING CONNECTED COMPONENTS IN AN UNDIRECTED GRAPH
            0     3     5
           / \    |    / \
          1---2   4   6   7
                          |
                          8
          There are 3 disconnected graph
          O (V + E)
        **/
        int v = 10;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        A_AdjacencyList.addEdge(adj,0,1); // FIRST GRAPH
        A_AdjacencyList.addEdge(adj,0,2);
        A_AdjacencyList.addEdge(adj,1,2);
        A_AdjacencyList.addEdge(adj,3,4); // SECOND GRAPH
        A_AdjacencyList.addEdge(adj,5,6); // THIRD GRAPH
        A_AdjacencyList.addEdge(adj,5,7);
        A_AdjacencyList.addEdge(adj,7,8);
        System.out.println("COUNTING DISCONNECTED GRAPH : ");
        A_AdjacencyList.printGraph(adj);

        System.out.println("\nCOUNT : " + CountGraph(adj,v));
    }
    public static void BFSConnected() {
        /** BFS CONNECTED ADJACENCY LIST **/
        int v = 6;
        int s = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        A_AdjacencyList.addEdge(adj,0,1);
        A_AdjacencyList.addEdge(adj,0,2);
        A_AdjacencyList.addEdge(adj,1,2);
        A_AdjacencyList.addEdge(adj,1,3);
        A_AdjacencyList.addEdge(adj,2,3);
        A_AdjacencyList.addEdge(adj,2,4);
        A_AdjacencyList.addEdge(adj,3,4);
        System.out.println("GRAPH : ");
        A_AdjacencyList.printGraph(adj);

        /** BFS ALGORITHM **/

        boolean[] visited = new boolean[v+1];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        System.out.print("BFS CONNECTED : ");
        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int x : adj.get(u)) {
                if(!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
        System.out.println("\n----------------------------------");
    }
    public static void BFSDisconnected() {
        /** BFS DISCONNECTED ADJACENCY LIST

         No Source and Graph is disconnected
             0       4
            / \     / \
           1   2   5   6
            \ /     \ /
             3       7

         **/
        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        A_AdjacencyList.addEdge(adj,0,1); // FIRST GRAPH
        A_AdjacencyList.addEdge(adj,0,2);
        A_AdjacencyList.addEdge(adj,1,3);
        A_AdjacencyList.addEdge(adj,2,3);
        A_AdjacencyList.addEdge(adj,4,5); // SECOND GRAPH
        A_AdjacencyList.addEdge(adj,4,6);
        A_AdjacencyList.addEdge(adj,5,7);
        A_AdjacencyList.addEdge(adj,6,7);
        System.out.println("DISCONNECTED GRAPH : ");
        A_AdjacencyList.printGraph(adj);

        /** BFS DISCONNECTED ALGORITHM **/

        boolean[] visited = new boolean[v+1];
        System.out.print("BFS DISCONNECTED : ");
        for (int i = 0; i < v-1; i++) {
            if(!visited[i]) {
                BFS(adj,i,visited);
            }
        }

        System.out.println("\n----------------------------------");
    }
    public static void BFS(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int x : adj.get(u)) {
                if(!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }
    public static int CountGraph(ArrayList<ArrayList<Integer>> adj, int v) {
        int count = 0;
        boolean[] visited = new boolean[v+1];
        System.out.print("BFS DISCONNECTED : ");
        for (int i = 0; i < v-1; i++) {
            if(!visited[i]) {
                count++;
                BFS(adj,i,visited);
            }
        }
        return count;
    }
}
