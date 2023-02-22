/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.recursion;

public class F_TowerOfHanoi {
    public static void main(String[] args) {
        /**
        * A --> Src
        * B --> Aux
        * C --> Dest
        */
        TOH(3,'A','B','C');
    }
    public static void TOH(int n, char A, char B, char C) {
        if(n == 1) {
            System.out.println("Move 1 from " + A + " to " + C);
            return;
        }
        TOH(n-1,A,C,B); // Move all disks from a to b
        System.out.println("Move " + n + " from " + A + " to " + C);
        TOH(n-1,B,A,C); // Move all disks from b to c
    }
}
