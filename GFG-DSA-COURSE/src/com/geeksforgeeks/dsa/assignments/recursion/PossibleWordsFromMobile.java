/**
 * Created By Kavi Arasan
 * Date : 06/03/23
 */
package com.geeksforgeeks.dsa.assignments.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class PossibleWordsFromMobile {
    /*
    Given a keypad as shown in the diagram, and an N digit number
    which is represented by array a[ ], the task is to list all words
    which are possible by pressing these numbers.

    Example 1:
    Input: N = 3, a[] = {2, 3, 4}
    Output:
    adg adh adi aeg aeh aei afg afh afi
    bdg bdh bdi beg beh bei bfg bfh bfi
    cdg cdh cdi ceg ceh cei cfg cfh cfi
    Explanation: When we press 2,3,4 then
    adg, adh, adi, ... cfi are the list of
    possible words.

    Example 2:
    Input: N = 3, a[] = {3, 4, 5}
    Output:
    dgj dgk dgl dhj dhk dhl dij dik dil
    egj egk egl ehj ehk ehl eij eik eil
    fgj fgk fgl fhj fhk fhl fij fik fil
    Explanation: When we press 3,4,5 then
    dgj, dgk, dgl, ... fil are the list of
    possible words.
    */
    static Character[][] numberToCharMap;
    static ArrayList<String> possibleWords(int a[], int N) {
        return phoneCombination(a);
    }
    private static ArrayList<String> printWords(int[] numbers, int len, int numIndex, String s) {
        if(len == numIndex) {
            return new ArrayList<>(Collections.singleton(s));
        }
        ArrayList<String> stringList = new ArrayList<>();
        for(int i = 0; i < numberToCharMap[numbers[numIndex]].length; i++) {
            String sCopy = String.copyValueOf(s.toCharArray());
            sCopy = sCopy.concat(numberToCharMap[numbers[numIndex]][i].toString());
            stringList.addAll(printWords(numbers, len, numIndex + 1, sCopy));
        }
        return stringList;
    }
    private static ArrayList<String> phoneCombination(int[] numbers) {
        generateNumberToCharMap();
        ArrayList<String> stringList =
                printWords(numbers, numbers.length, 0, "");
        return stringList;
    }

    private static void generateNumberToCharMap() {
        numberToCharMap = new Character[10][5];
        numberToCharMap[0] = new Character[]{'\0'};
        numberToCharMap[1] = new Character[]{'\0'};
        numberToCharMap[2] = new Character[]{'a','b','c'};
        numberToCharMap[3] = new Character[]{'d','e','f'};
        numberToCharMap[4] = new Character[]{'g','h','i'};
        numberToCharMap[5] = new Character[]{'j','k','l'};
        numberToCharMap[6] = new Character[]{'m','n','o'};
        numberToCharMap[7] = new Character[]{'p','q','r','s'};
        numberToCharMap[8] = new Character[]{'t','u','v'};
        numberToCharMap[9] = new Character[]{'w','x','y','z'};
    }

    public static void main(String[] args) {
        int N = 3;
        int[] arr = {2,3,4};
        System.out.println(possibleWords(arr,N));
    }
}
