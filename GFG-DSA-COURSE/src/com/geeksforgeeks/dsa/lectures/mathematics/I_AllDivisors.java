/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.mathematics;

public class I_AllDivisors {
    public static void main(String[] args) {
        /**
        * n = 15 -> 1 3 5 15
        * n = 100 -> 1 2 4 5 10 20 25 50 100
        */
        allDivisorsEfficient(100);
    }
    // NAIVE SOLUTION
    public static int allDivisorsNaive(int n) {
        if(n == 1) return n;
        for(int i = 2; i <= n; i++) {
            if(n % i == 0) System.out.println(i);
        }
        return n;
    }
    // EFFICIENT SOLUTION
    public static void allDivisorsEfficient(int n) {
        /**
        * loop 1 : n = 10
        * i = 1 < 10 : print
        * i = 2 < 10 : print
        * i = 3 < 10 :
        * i = 4 < 10 : print
        * i = 5 < 10 : print
        * i = 6 < 10 :
        * i = 7 < 10 :
        * i = 8 < 10 :
        * i = 9 < 10 :
        *
        * loop 2 :
        * i = 10 >= 1 : print(100/10) = 10
        * i = 9 >= 1 :
        * i = 8 >= 1 :
        * i = 7 >= 1 :
        * i = 6 >= 1 :
        * i = 5 >= 1 : print(100/5) = 20
        * i = 4 >= 1 : print(100/4) = 25
        * i = 3 >= 1 :
        * i = 2 >= 1 : print(100/2) = 50
        * i = 1 >= 1 : print(100/1) = 100
        */
        int i;
        for(i=1; i < Math.sqrt(n); i++) {
            if(n % i == 0) System.out.println(i);
        }
        for(; i>= 1; i--) {
            if(n % i == 0) System.out.println(n / i);
        }
    }
}
