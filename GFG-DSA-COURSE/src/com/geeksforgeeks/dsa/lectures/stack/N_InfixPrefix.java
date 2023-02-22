/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Stack;

public class N_InfixPrefix {
    public static void main(String[] args) {
        String strPrefix1 = "a+(b*c)"; //input should not have space
        String strPrefix2 = "(x+y*(z-w))";
        String strEval1 = "+ * 10 2 3";
        String strEval2 = "^ 10 ^ 2 3";
        InfixPrefix(strPrefix1);
        InfixPrefix(strPrefix2);
        System.out.println(EvaluationInfixPrefix(strEval1));
        System.out.println(EvaluationInfixPrefix(strEval2));
    }
    public static void InfixPrefix(String str) {
        /**
         * 1. Create a 2 empty stack for operators and operands
         * 2. Traverse through string, If c is :
         *    (a) Opening parenthesis : push to operator stack.
         *    (c) Closing parenthesis :
         *           i. Loop through operators until operator stack is empty and top element becomes
         *              opening parenthesis.
         *          ii. Pop 2 times from operand stack and Pop 1 time from operator stack.
         *         iii. Concat by operator + operand2 + operand1 and push to operand stack.
         *    (d) Operand : Push to operand stack.
         *    (d) Operator :
         *           i. Loop through operators  until it becomes empty and current x precedence level is
         *              lower than top of the operator stack.
         *          ii. Pop 2 times from operand stack and Pop 1 time from operator stack.
         *         iii. Concat by operator + operand2 + operand1 and push to operand stack.
         *          iv. push x to operator stack after loop ends.
         * 3. Pop everything from operator stack until it becomes empty.
         *      (a) Pop 2 times from operand stack and Pop 1 time from operator stack.
         *      (b) Concat by operator + operand2 + operand1 and push to operand stack.
         * 4. Return the top of operand stack.
         * */

        Stack<Character> operators = new Stack<Character>();
        Stack<String> operands = new Stack<String>();
        String operatorRegex = "[-+*^/]";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                operators.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                while(!operators.isEmpty() && operators.peek() != '(') {

                    String operand1 = operands.peek();
                    operands.pop();

                    String operand2 = operands.peek();
                    operands.pop();

                    char operator = operators.peek();
                    operators.pop();

                    String tmp = operator + operand2 + operand1;
                    operands.push(tmp);
                }
                operators.pop(); // Pop opening bracket from stack
            } else if (!String.valueOf(str.charAt(i)).matches(operatorRegex)) {
                operands.push(str.charAt(i) + "");
            } else {
                while( !operators.isEmpty() && (
                        precedenceLevel( String.valueOf(str.charAt(i)) ) <= precedenceLevel( String.valueOf(operators.peek()) )
                )) {
                    String op1 = operands.peek();
                    operands.pop();

                    String op2 = operands.peek();
                    operands.pop();

                    char op = operators.peek();
                    operators.pop();

                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }
                operators.push(str.charAt(i));
            }
        }
        while (!operators.empty())
        {
            String op1 = operands.peek();
            operands.pop();

            String op2 = operands.peek();
            operands.pop();

            char op = operators.peek();
            operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }
        System.out.println(operands.peek());

    }
    public static int EvaluationInfixPrefix(String str) {
        /**
         * 1. Create an empty stack
         * 2. Traverse through every symbol x of given postfix from right to left
         *  (a) If x is an operand, push to stack.
         *  (b) Else (x is an operator)
         *        i. op1 = stack.pop()
         *       ii. op2 = stack.pop()
         *      iii. compute op1 *^/- op2 and push the result to stack
         * 3. Return stack.pop()
         * */
        Stack<String> stack = new Stack<>();
        String[] arr = str.split(" ");
        String operatorRegex = "[-+*/^]";
        for (int i = arr.length - 1; i >= 0; i--) {
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
