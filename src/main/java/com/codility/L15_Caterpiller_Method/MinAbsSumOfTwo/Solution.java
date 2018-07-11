package com.codility.L15_Caterpiller_Method.MinAbsSumOfTwo;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int front = A.length - 1;
        int back = 0;
        int min = Integer.MAX_VALUE;
        while (back <= front) {
            int current = A[back] + A[front];
            min = Math.min(min, Math.abs(current));
            if (current <= 0) {
                back++;
            } else {
                front--;
            }

        }
        return min;
    }


    public int nativeSolution(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                min = Math.min(min, Math.abs(A[i] + A[j]));
            }
        }
        return min;
    }
}
