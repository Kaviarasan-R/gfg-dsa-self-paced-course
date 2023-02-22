/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.graph;

import java.util.Arrays;

public class I_PrimsAlgorithm {
    public static void main(String[] args) {
        /** MINIMUM SPANNING TREE */
        /** UNDIRECTED, CONNECTED AND WEIGHTED GRAPH */
        /** ADJACENCY MATRIX : O (V ^ 2) */
        int[][] graph = {{0,5,8,0},{5,0,10,15},{8,10,0,20},{0,15,20,0}};
        int v = 4;
        int[] key = new int[v];
        int res = 0;
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0] = 0;
        boolean[] mSet = new boolean[v];
        for (int count = 0; count < v; count++) {
            /**
                At count = 0,
                u = -1
                key = {0,INF,INF,INF}
                mSet = {F,F,F,F}
                    at i = 0 :
                    mSet[0] == false && (u == -1 || key[0] < key[-1]) :
                        u = 0
                    at i = 1 :
                    mSet[1] == false && (u == -1 || key[0] < key[0]) :
                    at i = 2 :
                    mSet[2] == false && (u == -1 || key[0] < key[0]) :
                    ...
                u = 0
                key = {0,INF,INF,INF}
                mSet = {T,F,F,F}
                -------------------------
                u = -1
                key = {0,5,8,INF}
                    at i = 1 :
                    mSet[1] == false && (u == -1 || key[1] < key[-1]) :
                        u = 1
                    ...
             **/
            int u = -1;
            for (int i = 0; i < v; i++) {
                if(!mSet[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }
            mSet[u] = true;
            res = res + key[u];
            /** GO THROUGH ALL ADJACENT OF u
                When u = 1,
                mSet = {T,T,F,F}
                key = {0,5,8,INF}
                    at x = 3 :
                    mSet[3] == false && graph[1][3] != 0 && graph[1][3] < key[3]
                            { false == false && 15 != 0 && 15 < INF }
             **/
            for (int x = 0; x < v; x++) {
                if(!mSet[x] && graph[u][x] != 0 && graph[u][x] < key[x]) {
                    key[x] = graph[u][x];
                }
            }
        }
        System.out.println(res);
    }
}
