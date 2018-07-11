package com.codility.L4_Counting_Elements.FrogRiverOne;

import java.util.Arrays;

class Solution {
    public int solution(int X, int[] A) {
        int path[] = new int[X];
        int sum = X * (X + 1) / 2;
        int pathSum = 0;
        Arrays.fill(path, -1);
        for (int i = 0; i < A.length; i++) {
            if (path[A[i] - 1] == -1) {
                path[A[i] - 1] = A[i];
                pathSum += A[i];
            }
            if (pathSum == sum) {
                return i;
            }
        }
        return -1;
    }
}