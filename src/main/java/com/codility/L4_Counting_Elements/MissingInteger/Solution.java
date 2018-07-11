package com.codility.L4_Counting_Elements.MissingInteger;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {

        int[] map = new int[A.length];
        Arrays.fill(map, -1);
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length) {
                map[A[i] - 1] = A[i];
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == -1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}