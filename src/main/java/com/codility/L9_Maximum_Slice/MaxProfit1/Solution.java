package com.codility.L9_Maximum_Slice.MaxProfit1;

class Solution {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[] df = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            df[i - 1] = A[i] - A[i - 1];
        }
        int maxEnding = 0;
        int maxSlice = 0;
        for (int i = 0; i < df.length; i++) {
            maxEnding = Math.max(maxEnding + df[i], 0);
            maxSlice = Math.max(maxEnding, maxSlice);
        }
        return Math.max(maxSlice, 0);
    }
}
