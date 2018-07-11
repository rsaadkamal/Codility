package com.codility.L6_Sorting.Distinct;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int counter = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                counter++;
            }
        }
        return counter;
    }
}