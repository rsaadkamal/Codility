package com.codility.L8_Leader.Dominator1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int maxElement = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxElement = entry.getKey();
            }
        }
        if (A.length / 2 >= max) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == maxElement) {
                return i;
            }
        }
        return -1;
    }
}