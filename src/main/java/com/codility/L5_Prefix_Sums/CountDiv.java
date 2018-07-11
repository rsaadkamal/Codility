package com.codility.L5_Prefix_Sums;

/*
* Write A function:

class Solution { public int solution1(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Assume that:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
Complexity:

expected worst-case time complexity is O(1);
expected worst-case space complexity is O(1).
* */

/**
 * Created by Chaklader on 6/23/18.
 */
public class CountDiv {


    /*
     * solution1 - A
     */
    public static int solution(int A, int B, int K) {

        if (A % K == 0) {
            return 1 + (B - A) / K;
        }
        return B / K - A / K;
    }


    /*
     * solution1 - B
     */
    public static int solution1(int A, int B, int K) {

        int b = B / K;
        int a = (A > 0 ? (A - 1) / K : 0);

        if (A == 0) {
            b++;
        }
        return b - a;
    }


    /*
     * solution1 - c
     */
    public int solution2(int a, int b, int k) {

        int result = b / k - a / k;

        if (a % k == 0) {
            result++;
        }

        return result;
    }
}
