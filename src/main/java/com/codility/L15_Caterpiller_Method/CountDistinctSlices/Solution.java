package com.codility.L15_Caterpiller_Method.CountDistinctSlices;

public class Solution {

    public int solution(int M, int[] A) {
        boolean[] found = new boolean[M + 1];
        int count = 0;
        int back = 0;
        for (int front = 0; front < A.length; front++) {
            while (found[A[front]]) {
                found[A[back]] = false;
                back++;
            }
            found[A[front]] = true;
            count += front - back + 1;
            if (count > 1000000000) {
                return 1000000000;
            }
        }
        return count;
    }
}