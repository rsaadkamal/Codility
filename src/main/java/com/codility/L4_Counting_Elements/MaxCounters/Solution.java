package com.codility.L4_Counting_Elements.MaxCounters;

import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] A) {
        int[] table = new int[N];
        int max = 0;
        int currentMax = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                if (table[A[i] - 1] < currentMax) {
                    table[A[i] - 1] = currentMax + 1;
                } else {
                    table[A[i] - 1]++;
                }
                max = Math.max(table[A[i] - 1], max);
            } else if (A[i] == N + 1) {
                currentMax = max;
            }
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] < currentMax) {
                table[i] = currentMax;
            }
        }
        return table;
    }
}