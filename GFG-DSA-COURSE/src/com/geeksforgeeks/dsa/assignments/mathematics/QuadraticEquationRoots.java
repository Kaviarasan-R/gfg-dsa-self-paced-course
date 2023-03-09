/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

import java.util.ArrayList;

public class QuadraticEquationRoots {
    /*
    Given a quadratic equation in the form ax2 + bx + c. Find its roots.
    Note: Return the maximum root followed by the minimum root.

    Example 1:
    Input:
    a = 1
    b = -2
    c = 1
    Output: 1 1
    Explanation:
    Roots of equation x2-2x+1 are 1 and 1.

    Example 2:
    Input:
    a = 1
    b = -7
    c = 12
    Output: 4 3
    Explanation: Roots of equation
    x2 - 7x + 12 are 4 and 3.

    Formula:
    x = (-b ± √ (b2 - 4ac) )/2a
    */
    public static void main(String[] args) {
        System.out.println(quadraticRoots(1,-7,12));
    }
    public static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> d = new ArrayList<Integer>();
        double det = ( (b*b) - (4.0 * a * c) );
        if( det < 0 ) { // check if no roots exist
            d.add(-1);
            return d;
        }
        det = Math.sqrt(det);
        double detPlus = Math.floor((-b+det)/(2.0*a));
        double detMinus = Math.floor((-b-det)/(2.0*a));
        if(detPlus < detMinus) {
            d.add((int)detMinus);
            d.add((int)detPlus);
        } else {
            d.add((int)detPlus);
            d.add((int)detMinus);
        }
        return d;
    }
}
