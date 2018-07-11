package com.codility.L3_Time_Complexity.TapeEquilibrium;

class Solution {
    public int solution(int[] A) {
        int[] df = new int[A.length];
        df[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            df[i] = A[i] + df[i - 1];
        }
        int[] df2 = new int[A.length];
        df2[df2.length - 1] = A[df2.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            df2[i] = df2[i + 1] + A[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            min = Math.min(min, Math.abs(df[i - 1] - df2[i]));
        }
        return min;
    }
}