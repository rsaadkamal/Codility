package com.codility.L5_Prefix_Sums.PassingCars;

class Solution {
    private final static int MAXIMUM = 1000000000;

    public int solution(int[] A) {
        int zerosCount = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zerosCount++;
            } else {
                sum += zerosCount;
            }
            if (sum > MAXIMUM) {
                return -1;
            }
        }
        return sum;
    }
}