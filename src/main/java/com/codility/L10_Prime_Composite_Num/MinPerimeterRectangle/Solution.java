package com.codility.L10_Prime_Composite_Num.MinPerimeterRectangle;

class Solution {
    public int solution(int N) {

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                min = Math.min(min, 2 * (i + (N / i)));
            }
        }
        return min;
    }
}