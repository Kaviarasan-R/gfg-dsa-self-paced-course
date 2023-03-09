/**
 * Created By Kavi Arasan
 * Date : 05/03/23
 */
package com.geeksforgeeks.dsa.assignments.mathematics;

public class CelsiusToFahrenheit {
    /*
    Given a temperature in celsius C. You need to convert the given temperature to Fahrenheit.

    Example 1:
    Input:
    C = 32
    Output: 89
    Explanation: Using the conversion formula of celsius to fahrenheit , it can be calculated that,
    for 32 degree C, the temperature in Fahrenheit = 89.
    */
    public static void main(String[] args) {
        System.out.println(cToF(32));
    }
    public static double cToF(int C) {
        return (C * 9/5) + 32;
    }
}
