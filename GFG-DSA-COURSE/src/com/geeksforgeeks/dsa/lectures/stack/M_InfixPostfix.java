/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Stack;

public class M_InfixPostfix {
    public static void main(String[] args) {
        String strPostfix1 = "a+b*c";
        String strPostfix2 = "a+b*(c^d-e)^(f+g*h)-i";
        String strEval = "10 2 * 3 +";
        InfixPostfix(strPostfix1);
        InfixPostfix(strPostfix2);
        System.out.println(EvaluationInfixPostfix(strEval));
    }
    public static void InfixPostfix(String str) {
        /**
         * 1. Create an empty stack
         * 2. Create an empty string = result
         * 3. Traverse through the string, If x is :
         *  (a) operand: append to result
         *  (b) open parenthesis : push to stack
         *  (c) closing parenthesis :
         *          i. Loop through stack until stack becomes empty and top element becomes
         *             opening parenthesis.
         *         ii. append popped element to result.
         *        iii. after loop termination, pop the opening parenthesis.
         *  (d) operator :
         *          i. Loop through stack until it becomes empty and current x precedence level is
         *             lower than top of the stack.
         *         ii. append popped element to result.
         *  4. pop remaining elements from stack and append to result.
         * */
        String result = "";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isLetterOrDigit(c)) result += c;
            else if(c == '(') stack.push(c);
            else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop(); // for removing the opening parenthesis
            } else {
                while( !stack.isEmpty() &&
                        ( precedenceLevel(String.valueOf(c))) <= precedenceLevel(String.valueOf(stack.peek()) )
                ) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            result += stack.peek();
            stack.pop();
        }
        System.out.println(result);
    }
    public static int EvaluationInfixPostfix(String str) {
        /**
         * 1. Create an empty stack
         * 2. Traverse through every symbol x of given postfix
         *  (a) If x is an operand, push to stack.
         *  (b) Else (x is an operator)
         *        i. op1 = stack.pop()
         *       ii. op2 = stack.pop()
         *      iii. compute op2 *^/- op1 and push the result to stack
         * 3. Return stack.pop()
         * */
        Stack<String> stack = new Stack<>();
        String[] arr = str.split(" ");
        String operatorRegex = "[-+*/^]";
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].matches(operatorRegex)) {
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                int value = switch (arr[i]) {
                    case "+" -> op1 + op2;
                    case "-" -> op1 - op2;
                    case "*" -> op1 * op2;
                    case "/" -> op1 / op2;
                    case "^" -> (int) Math.pow(op1,op2);
                    default -> 0;
                };
                stack.push(Integer.toString(value));
            } else {
                stack.push(arr[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    static int precedenceLevel(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> 0;
        };
    }
}
