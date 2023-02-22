/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.recursion;

public class E_GenerateSubsets {
    public static void main(String[] args) {
        String str = "ABC";
        subset(str,"",0);
    }
    public static void subset(String str, String current, int i) {
        /**
        * fn(AB,"",0)
        * |-----fn(AB,"",1)
        * |         |------fn(AB,"",2)
        * |         |           |------ ""
        * |         |------fn(AB,""+B,2)
        * |                     |------ B
        * |-----fn(AB,""+A,1)
        *           |------fn(AB,"A",2)
        *           |           |------ A
        *           |------fn(AB,"A"+B,2)
        *                       |------ AB
        *
        */
        if(i == str.length()) {
            System.out.println(current);
            return;
        }
        subset(str,current,i+1);
        subset(str,current+str.charAt(i),i+1);
    }
}
