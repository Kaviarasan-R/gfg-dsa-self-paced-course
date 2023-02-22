/**
 * Created By Kavi Arasan
 */
package com.geeksforgeeks.dsa.lectures.stack;

import java.util.Objects;
import java.util.Stack;

public class L_GetMinFunction {
    static Stack<Integer> main = new Stack<>();
    static Stack<Integer> aux = new Stack<>();
    static Stack<Integer> stack = new Stack<>();
    static int min;
    public static void main(String[] args) {
        /**
         * Design a stack which supports getMin()
         * push(20) push(10) getMin() push(5) pop() getMin() pop() getMin()
         * getMin() returns the minimum element from the stack
         * */
        naiveSolution();
        System.out.println();
        efficientSolution();
    }

    public static void naiveSolution() {
        /** O (n) aux space
         * 1. create 2 stacks (main and auxiliary stack)
         * 2. for push(x) : every element should be pushed in main.
         * 3. after pushing to main, then if(aux.peek() >= main.peek()) aux.push(x)
         * 4. we compare elements of aux and main, when aux peek is greater than we push to aux.
         * 5. for pop() : only if(main.peek() == aux.peek()) aux.pop()
         * 6. then after, main.pop() should be performed.
         **/
        PushNaive(20);
        PushNaive(10);
        System.out.print(aux.peek() + " ");
        PushNaive(5);
        System.out.print(aux.peek() + " ");
        PopNaive();
        System.out.print(aux.peek() + " ");
        PopNaive();
        System.out.print(aux.peek() + " ");
    }
    private static void PushNaive(int x) {
        main.push(x);
        if(aux.isEmpty() || aux.peek() >= main.peek()) {
            aux.push(x);
        }
    }
    private static void PopNaive() {
        if(Objects.equals(main.peek(), aux.peek())) aux.pop();
        main.pop();
    }

    public static void efficientSolution() {
        /**
         * O (1) time & O (1) aux
         * Steps :
         * 1. assume all elements as positive
         * 2. when you see a greater element than current minimum then push it
         * 3. when you see a smaller element than current minimum then
         * (store difference ``smaller_element - current_minimum`` in stack)
         * and update the min to smaller element.
         * we're using 2 * to work even in  negative numbers
         */

        pushEffective(20);
        pushEffective(10);
        System.out.print(getMinEffective() + " ");
        pushEffective(5);
        System.out.print(getMinEffective() + " ");
        popEffective();
        System.out.print(getMinEffective() + " ");
        popEffective();
        System.out.print(getMinEffective() + " ");

    }
    private static int getMinEffective() {
        return min;
    }
    private static int peekEffective() {
        int temp = stack.peek();
        return Math.max(temp, min);
    }
    private static void pushEffective(int x) {
        if(stack.isEmpty()) {
            min = x;
            stack.push(x);
        } else if (x <= min) {
            stack.push(2*x - min);
            min = x;
        } else {
            stack.push(x);
        }
    }
    private static int popEffective() {
        int x = stack.pop();
        if(x <= min) { // check for negative, if negative then return (min + top)
            int res = min;
            min = 2*min - x;
            return res;
        }
        return x;
    }

}
