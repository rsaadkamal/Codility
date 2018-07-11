package com.codility.L14_Binary_Search_Algorithm.MinMaxDivision;

import java.util.stream.IntStream;

class Solution {
    public int solution(int K, int M, int[] A) {
        int min = IntStream.of(A).max().getAsInt();
        int max = IntStream.of(A).sum();
        int result = max;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (check(A, mid, K - 1)) {
                max = mid - 1;
                result = mid;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }

    private boolean check(int[] A, int mid, int K) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > mid) {
                sum = A[i];
                K--;
            }
            if (K < 0) {
                return false;
            }
        }
        return true;
    }
}