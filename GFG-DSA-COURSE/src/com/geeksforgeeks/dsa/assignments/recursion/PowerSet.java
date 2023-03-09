/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

import java.util.ArrayList;

public class PowerSet {
    /*
    You are given a string. You need to print the lexicographically sorted power-set of the string.
    Note: The string s contains lowercase letter of alphabet.

    Example 1:
    Input:
    s = a
    Output: a
    Explanation: empty string and a
    are only sets.

    Example 2:
    Input:
    s = abc
    Output: a ab abc ac b bc c
    Explanation: empty string,
    a, ab, abc, ac, b, bc, c
    are the sets.
     */
    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }
    public static ArrayList<String> powerSet(String s) {
        ArrayList<String> lexSort = new ArrayList<>();
        subsets(s,"",0,lexSort);
        return lexSort;
    }
    public static void subsets(String str, String current, int i, ArrayList<String> arrayList) {
        if(i == str.length()) {
            arrayList.add(current);
            return;
        }
        subsets(str, current, i+1, arrayList);
        subsets(str, current+str.charAt(i), i+1, arrayList);
    }
}
