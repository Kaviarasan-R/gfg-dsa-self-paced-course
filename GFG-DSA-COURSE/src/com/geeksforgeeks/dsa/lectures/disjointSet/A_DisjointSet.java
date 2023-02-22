/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.disjointSet;

public class A_DisjointSet {

    int[] rank, parent;
    int n;

    // Constructor
    public A_DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        initialization();
    }

    void initialization() {
        for (int i = 0; i < this.n; i++) {
            parent[i] = i;
        }
    }
    int find(int z) {
        if(parent[z] == z) return z;
        else return find(parent[z]);
    }
    int findWithPathCompressed(int z) {
        if(parent[z] == z) return z;
        parent[z] = findWithPathCompressed(parent[z]);
        return parent[z];
    }
    void union(int x, int y) {
        int x_rep = findWithPathCompressed(x);
        int y_rep = findWithPathCompressed(y);
        if(x_rep == y_rep) return;
        parent[y_rep] = x_rep;
    }
    void unionByRank(int x, int y) {
        int x_rep = findWithPathCompressed(x);
        int y_rep = findWithPathCompressed(y);
        if(x_rep == y_rep) return;
        // IF TREES HAVE DIFFERENT RANKS, THEN APPEND ONE TREE TO ANOTHER ACCORDING TO HEIGHT.
        if(rank[x_rep] < rank[y_rep]) parent[x_rep] = y_rep;
        else if(rank[y_rep] < rank[x_rep]) {
            /*
            AT UNION(0,1) :
                p[] = {0,1,0,3,0}
                r[] = {2,0,0,0,0}
                x_rep = 0
                y_rep = 1
                rank[1] = 0   <   rank[0] = 2
                p[1] = 0;
                p[] = {0,0,0,3,0}
            */
            parent[y_rep] = x_rep;
        }
        else {
            /*
            AT UNION(0,2) :
                p[] = {0,1,2,3,4}
                r[] = {0,0,0,0,0}
                x_rep = 0
                y_rep = 2
                ELSE CONDITION WILL TRIGGER:
                    we're taking x as parent node when both are equal.
                    p[2] = {0,1,0,3,4}
                    we're incrementing the rank only for parent node.
                    r[0] = {1,0,0,0,0}
            AT UNION(2,4) :
                x_rep = 0
                y_rep = 4
                ELSE CONDITION WILL TRIGGER:
                    p[4] = {0,1,0,3,0}
                    r[0] = {2,0,0,0,0}
            */
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        A_DisjointSet disjointSet = new A_DisjointSet(n);
        disjointSet.unionByRank(0,2); // SET 1
        disjointSet.unionByRank(2,4);
        disjointSet.unionByRank(0,1);
        disjointSet.unionByRank(1,3); // SET 2

        // Check if 4 is a friend of 0
        if (disjointSet.findWithPathCompressed(4) == disjointSet.findWithPathCompressed(0)) System.out.println("Yes");
        else System.out.println("No");

        // Check if 1 is a friend of 0
        if (disjointSet.findWithPathCompressed(1) == disjointSet.findWithPathCompressed(3)) System.out.println("Yes");
        else System.out.println("No");

    }
}
