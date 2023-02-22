/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.ArrayList;

public class C_DFS {
    public static void main(String[] args) {
        /** DFS CONNECTED
            0 -- 1 ----|
            |    |     4
            2 -- 3 ----|

            DFS(0)
                |--- DFS(1)
                        |---DFS(3)
                                |---DFS(2)
                                |---DFS(4)  checks if all adjacent are visited

            O (V + E)
         **/
        int v1 = 6;
        int s1 = 0;
        ArrayList<ArrayList<Integer>> adjConnected = new ArrayList<ArrayList<Integer>>(v1);
        for (int i = 0; i < v1; i++) {
            adjConnected.add(new ArrayList<Integer>());
        }
        A_AdjacencyList.addEdge(adjConnected,0,1);
        A_AdjacencyList.addEdge(adjConnected,0,2);
        A_AdjacencyList.addEdge(adjConnected,1,3);
        A_AdjacencyList.addEdge(adjConnected,1,4);
        A_AdjacencyList.addEdge(adjConnected,3,2);
        A_AdjacencyList.addEdge(adjConnected,3,4);
        System.out.println("DFS CONNECTED GRAPH : ");
        A_AdjacencyList.printGraph(adjConnected);
        boolean[] visited1 = new boolean[v1];
        System.out.print("OUTPUT : ");
        DFSConnected(adjConnected,s1,visited1);

        /** DFS DISCONNECTED
            0       3
             \      |
              2     4
             /
            1
         **/
        int v2 = 6;
        ArrayList<ArrayList<Integer>> adjDisconnected = new ArrayList<ArrayList<Integer>>(v2);
        for (int i = 0; i < v2; i++) {
            adjDisconnected.add(new ArrayList<Integer>());
        }
        A_AdjacencyList.addEdge(adjDisconnected,0,2); // GRAPH 1
        A_AdjacencyList.addEdge(adjDisconnected,2,1);
        A_AdjacencyList.addEdge(adjDisconnected,3,4); // GRAPH 2
        System.out.println("\n\nDFS DISCONNECTED GRAPH : ");
        A_AdjacencyList.printGraph(adjDisconnected);
        int count = 0;
        boolean[] visited2 = new boolean[v2];
        System.out.print("OUTPUT : ");
        for (int i = 0; i < v2-1; i++) {
            if(!visited2[i]) {
                count++;
                DFSDisconnected(adjDisconnected,i,visited2);
            }
        }
        System.out.println("\nCOUNT : " + count);
    }
    public static void DFSConnected(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int v : adj.get(s)) {
            if(!visited[v]) DFSConnected(adj,v,visited);
        }
    }
    public static void DFSDisconnected(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int v : adj.get(s)) {
            if(!visited[v]) DFSDisconnected(adj,v,visited);
        }
    }
}
