package com.codility.L6_Sorting.Triangle;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {
            boolean isTriangle = A[i - 2] > A[i] - A[i - 1];
            if (isTriangle) {
                return 1;
            }
        }
        return 0;
    }
}