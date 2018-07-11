package com.codility.L9_Maximum_Slice.MaxSliceSum;

class Solution {
    public int solution(int[] A) {
        int end = A[0];
        int start = A[0];
        for (int i = 1; i < A.length; i++) {
            end = Math.max(A[i], end + A[i]);
            start = Math.max(start, end);
        }
        return start;
    }
}