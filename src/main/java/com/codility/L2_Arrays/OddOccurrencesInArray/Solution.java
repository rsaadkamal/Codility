package com.codility.L2_Arrays.OddOccurrencesInArray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        for (Map.Entry pair : map.entrySet()) {
            if (1 == (int) pair.getValue() % 2) {
                return (int) pair.getKey();
            }
        }
        return -1;
    }
}