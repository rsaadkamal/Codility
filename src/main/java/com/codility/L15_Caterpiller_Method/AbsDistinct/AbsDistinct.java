package com.codility.L15_Caterpiller_Method.AbsDistinct;

import java.util.HashMap;

public class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int key = Math.abs(A[i]);
            if (map.containsKey(key)) {
                map.put(Math.abs(key), map.get(key) + 1);
            } else {
                map.put(key, 0);
            }
        }
        return map.size();
    }
}
