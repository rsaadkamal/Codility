package com.codility.L17_Dynamic_Programming.NumberSolitaire;

public class Solution {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = dp[i - 1];
            for (int minus = 2; minus <= 6; minus++) {
                if (i >= minus) {
                    dp[i] = Math.max(dp[i], dp[i - minus]);
                } else {
                    break;
                }
            }
            dp[i] += A[i];
        }
        return dp[A.length - 1];
    }

}
