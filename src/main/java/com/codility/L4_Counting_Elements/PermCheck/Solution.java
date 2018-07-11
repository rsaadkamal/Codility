package com.codility.L4_Counting_Elements.PermCheck;

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        int[] map = new int[A.length];
        Arrays.fill(map, -1);
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A.length) {
                return 0;
            }
            if (map[A[i] - 1] == -1) {
                map[A[i] - 1] = A[i];
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == -1) {
                return 0;
            }
        }
        return 1;
    }
}