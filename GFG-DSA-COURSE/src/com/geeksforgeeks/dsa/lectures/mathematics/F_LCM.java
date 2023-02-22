/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

public class F_LCM {
    public static void main(String[] args) {
        System.out.println(lcmNaive(4,6));
        System.out.println(lcmEfficient(4,6));
    }
    // NAIVE SOLUTION
    public static int lcmNaive(int a, int b) {
        int res = Math.max(a,b);
        while(true) {
            if(res % a == 0 && res % b == 0) {
                break;
            }
            res++;
        }
        return res;
    }
    // EFFICIENT SOLUTION
    public static int lcmEfficient(int a, int b) {
        return (a * b) / gcd(a,b);
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}
