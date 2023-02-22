/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.segmentTree;

public class A_SegmentTree {
    static int[] arr = {10,20,30,40};
    static int n = arr.length;
    static int[] tree = new int[4*n];
    public static void main(String[] args) {
        int new_value = 25;
        int index = 1;
        int diff = new_value - arr[index];
        System.out.println("SEGMENT TREE : " + constructST(0,n-1,0));
        System.out.println("GET SUM BEFORE UPDATE : " + getSum(0,1,0,n-1,0));
        update(0,n-1,index,0,diff);
        System.out.println("GET SUM AFTER UPDATE : " + getSum(0,1,0,n-1,0));
    }
    public static int constructST(int ss, int se, int si) {
        if(ss == se) {
            tree[si] = arr[ss];
            return arr[ss];
        }
        int mid = (ss + se) / 2;
        tree[si] =
                constructST(ss,mid,2*si+1) +
                constructST(mid+1,se,2*si+2);
        return tree[si];
    }
    public static int getSum(int qs, int qe, int ss, int se, int si) {
        if(se < qs || ss > qe) return 0;
        if(qs <= ss && qe >= se) return tree[si];
        int mid = (ss + se) / 2;
        return getSum(qs,qe,ss,mid,2*si+1) + getSum(qs,qe,mid+1,se,2*si+2);
    }
    public static void update(int ss, int se, int i, int si, int diff) {
        if(i < ss || i > se) return;
        tree[si] = tree[si] + diff;
        if(se > ss) {
            int mid = (ss + se) / 2;
            update(ss,mid,i,2*si+1,diff);
            update(mid+1,se,i,2*si+2,diff);
        }
    }
}
