/**
 * Created By Kavi Arasan
 */

package com.geeksforgeeks.dsa.lectures.bits;

public class B_CountSetBits {
    public static void main(String[] args) {
        /**
        * n = 5 --> 0000....0101
        * output = 2
        */
        System.out.println(countSetNaiveApproach1(5));
        System.out.println(countSetNaiveApproach2(7));
        System.out.println(brianKerringamAlgorithm(40));
        System.out.println(lookupTableFor32BitNumber(13));
    }

    public static int countSetNaiveApproach1(int n) {
        int res = 0;
        while(n > 0) {
            if(n % 2 != 0) res++;  // check last bit is set or not.
            n = n / 2;  // remove last bit
        }
        return res;
    }
    public static int countSetNaiveApproach2(int n) {
        int res = 0;
        while(n > 0) {
            if((n & 1) == 1) res++;  // check last bit is set or not.
            n = n >> 1;  // remove last bit
        }
        return res;
    }
    // BRIAN KERRINGAM'S ALGORITHM -> THETA(SET BIT COUNT)
    public static int brianKerringamAlgorithm(int n) {
        /**
        * n = 40
        * 40 : 1 0 1 0 0 0
        * 39 : 1 0 0 1 1 1
        * ----------------
        *  & : 1 0 0 0 0 0 --> n = 32
        * ----------------
        * n = 32
        * 32 : 1 0 0 0 0 0
        * 31 : 0 1 1 1 1 1
        * ----------------
        *  & : 0 0 0 0 0 0 --> n = 0
        * ----------------
        */
        int res = 0;
        while(n > 0) {
            n = (n & (n-1));
            res++;
        }
        return res;
    }
    // LOOKUP TABLE METHOD FOR 32 BIT NUMBER
    public static int lookupTableFor32BitNumber(int n) {
        /** {count of total set bits for particular number}
        *               0 1 2 3 4 5 6 7 8 ... 256
        *               | | | | | | | | | ...  |
        * table[256] = [0,1,1,2,1,2,2,3,1,......]
        */
        int[] table = new int[256];
        table[0] = 0;
        for (int i = 0; i < 256; i++) {
            table[i] = (i & 1) + table[i/2];
        }
        return countBits(n, table);
    }
    private static int countBits(int n, int[] table) {
        /**
        * n = 13
        * 00000000 00000000 00000000 00001101
        * -------- -------- -------- --------
        *    8bit    8bit     8bit     8bit
        * 0xFF --> last 8 bits
        * STEP 1 : res = table[n & 0xFF] --> 0..1101 & 1..1111 --> 0..1101 (13)
        *          table[13] = 3
        *          res = 0 + 3
        * STEP 2 : right shift n by 8 and move on to next last 8 bits.
        * STEP 3 : res = table[n & 0xFF] --> 0..0000 & 1..1111 --> 0..0000 (0)
        *          table[0] = 0
        *          res = 3 + 0
        * STEP 4 : right shift n by 8 and move on to next last 8 bits.
        * REPEAT TILL LAST 8 BITS.
        */
        int res = table[n & 0xff];
        n = n >> 8;
        res = res + table[n & 0xff];
        n = n >> 8;
        res = res + table[n & 0xff];
        n = n >> 8;
        res = res + table[n & 0xff];
        return res;
    }
}
