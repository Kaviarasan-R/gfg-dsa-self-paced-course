/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.*;

public class H_ShortestPathDAG {
    static HashMap<Integer,ArrayList<HashMap<Integer,Integer>>> weights = new HashMap<>();
    public static void main(String[] args) {
        int v = 7;
        int[] indegree = new int[v-1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        System.out.println("DIRECTED GRAPH : ");
        addEdge(adj,0,1,2);
        addEdge(adj,0,4,1);
        addEdge(adj,1,2,3);
        addEdge(adj,2,3,6);
        addEdge(adj,4,2,2);
        addEdge(adj,4,5,4);
        addEdge(adj,5,3,1);
        printGraph(adj);
        findIndegree(adj,indegree);
        topologicalSorting(adj,v,0,indegree);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v, int weight) {
        adj.get(u).add(v);
        if(weights.get(u) != null) {
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(v,weight);
            weights.get(u).add(map);
        } else {
            ArrayList<HashMap<Integer,Integer>> arr = new ArrayList<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(v,weight);
            arr.add(map);
            weights.put(u,arr);
        }
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        // PRINTING ADJACENT LIST
        for (int i = 0; i < adj.size()-1; i++) {
            int idx = 0;
            for (int j = 0; j < adj.get(i).size(); j++) {
                int v = adj.get(i).get(j);
                System.out.println("{ " + i + " , " + v + " } " +weights.get(i).get(idx).get(v));
                idx++;
            }
        }
    }
    public static int weight(int u, int v) {
        int idx = 0;
        while(true) {
            if(weights.get(u).get(idx).get(v) == null) {
                idx++;
            }
            else return weights.get(u).get(idx).get(v);
        }
    }
    public static void findIndegree(ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        for (int i = 0; i < adj.size()-1; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)]++;
            }
        }
        System.out.println("INDEGREE : " + Arrays.toString(indegree));
    }
    public static void topologicalSorting(ArrayList<ArrayList<Integer>> adj, int v, int s, int[] indegree) {
        ArrayList<Integer> sort = new ArrayList<>();
        int[] dist = new int[v-1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v-1; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int u = queue.poll();
            sort.add(u);
            for(int x : adj.get(u)) {
                indegree[x]--;
                if(indegree[x] == 0) queue.add(x);
            }
        }
        System.out.println("TOPOLOGICAL SORT : " + sort);
        for (int u : sort) {
            for (int x : adj.get(u)) {
                if(dist[x] > dist[u] + weight(u,x)) dist[x] = dist[u] + weight(u,x);
            }
        }
        System.out.println("SHORTEST PATH DAG : " + Arrays.toString(dist));
    }
}
