package com.codility.L13_Fibonacci_Numbers.Ladder;

public class Solution {
    /**
     * Again it's a variant of the classical problem about coins and quantity of change variants.
     * Common recurrence function is:
     * F(n) = sum (j<=Coins.length) ( n - coins[j] )
     * In that case we will sum F(n) = F(n-1) + F(n-2)
     * That is exact fibonacci recurrence relation.
     * So we can use the fibonacci sequence
     */
    public int[] solution(int A[], int B[]) {
        int[] fibonacciSequence = getFibSequence(B.length + 2);
        int[] result = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            result[i] = fibonacciSequence[A[i]] % (1 << B[i]);
        }
        return result;
    }
    public int[] getFibSequence(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            //we don't care about a start of a number
            result[i] = (result[i - 1] + result[i - 2]) % 1073741824;
        }
        return result;
    }

}
