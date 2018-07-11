package com.codility.L17_Dynamic_Programming.MinAbsSum;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
            max = Math.max(A[i], max);
        }
        int[] map = new int[sum + 1];
        int[] count = new int[max + 1];
        Arrays.fill(count, 0);
        Arrays.fill(map, -1);
        for (int i = 0; i < A.length; i++) {
            count[A[i]] += 1;
        }
        map[0] = 0;
        for (int a = 1; a <= max; a++) {
            if (count[a] > 0) {
                for (int j = 0; j <= sum; j++) {
                    if (map[j] >= 0) {
                        map[j] = count[a];
                    } else if (j >= a && map[j - a] > 0) {
                        map[j] = map[j - a] - 1;
                    }
                }
            }
        }

        int result = sum;
        for (int i = 0; i < sum / 2 + 1; i++) {
            if (map[i] >= 0) {
                result = Math.min(result, sum - 2 * i);
            }
        }
        return result;
    }
}