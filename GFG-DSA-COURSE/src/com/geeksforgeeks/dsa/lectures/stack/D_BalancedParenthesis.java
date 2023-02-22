/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Stack;

public class D_BalancedParenthesis {
    public static void main(String[] args) {
        String str1 = "([])";
        String str2 = "((())";
        String str3 = "([)]";
        String str4 = "{}([()])";
        String str5 = "(()))";
        System.out.println(naiveSolution(str3));
    }
    public static boolean naiveSolution(String str) {
        Stack<String> stack = new Stack<>();
        char[] characterArray = str.toCharArray();
        for(char c : characterArray) {
            if(!stack.isEmpty()) {
                String peek = stack.peek();
                String character = String.valueOf(c);
                if (
                    (peek.equals("(") && character.equals(")")) ||
                    (peek.equals("[") && character.equals("]")) ||
                    (peek.equals("{") && character.equals("}"))
                ) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(String.valueOf(c));
        }
        return stack.isEmpty();
    }
}
