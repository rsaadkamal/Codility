package com.codility.L9_Maximum_Slice.MaxDoubleSliceSum1;

class Solution {
    public int solution(int[] A) {
        int[] df = new int[A.length];
        int[] df2 = new int[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            df[i] = Math.max(df[i - 1] + A[i], 0);
        }

        for (int i = A.length - 2; i > 0; i--) {
            df2[i] = Math.max(df2[i + 1] + A[i], 0);
        }

        int max = 0;
        for(int i = 1; i < A.length-1; i++){
            max = Math.max(max, df[i-1]+df2[i+1]);
        }
        return max;
    }
}