/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.backtracking;

public class A_Permutation {
    public static void main(String[] args) {
        String str = "ABC";
        int l = 0;
        int r = str.length()-1;
        permute(str,l,r);
    }
    public static void permute(String str, int l, int r) {
        if(l == r) {
            System.out.println(str);
            return;
        } else {
            for (int i = l; i <= r; i++) {
                if(isSafe(str,i,l,r)) { // IT SHOULD NOT PRINT AB AS A SUBSTRING
                    str = swap(str, i, l);
                    permute(str, l + 1, r);
                    str = swap(str, i, l);
                }
            }
        }
    }
    public static boolean isSafe(String str,int i, int l, int r){
        if(l!=0 && str.charAt(l-1)=='A' && str.charAt(i)=='B') return false;
        if(r==(l+1) && str.charAt(i)=='A' && str.charAt(l)=='B') return false;
        return true;
    }

    public static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
