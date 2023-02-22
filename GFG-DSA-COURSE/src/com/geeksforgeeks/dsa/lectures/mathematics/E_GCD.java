/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

public class E_GCD {
    public static void main(String[] args) {
        System.out.println(gcdNaive(10,15));
        System.out.println(gcdEfficient(10,15));
        System.out.println(gcdRecursion(12,15));
    }
    // NAIVE SOLUTION
    public static int gcdNaive(int a, int b) {
        int res = Math.min(a,b);
        while(res > 0) {
            if(a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }
        return res;
    }
    // EFFICIENT SOLUTION
    public static int gcdEfficient(int a, int b) {
        /**
        * a = 10, b = 15
        * b > a ====> b = 15 - 10 = 5
        * a = 10, b = 5
        * a > b ====> a = 10 - 5 = 5
        * return a
        * */
        while(a != b) {
            if(a > b) a = a - b;
            else b = b - a;
        }
        return a;
    }
    // USING RECURSION
    public static int gcdRecursion(int a, int b) {
        /**
        * gcd(12,15)
        * --> gcd(15,12)
        * ------> gcd(12,3)
        * ----------> gcd(3,0)
        * */
        if (b == 0) return a;
        else return gcdRecursion(b, a % b);
    }
}
