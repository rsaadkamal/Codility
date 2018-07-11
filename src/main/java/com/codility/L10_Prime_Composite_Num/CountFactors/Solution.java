package com.codility.L10_Prime_Composite_Num.CountFactors;

class Solution {
    public int solution(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int counter = 0;
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                counter += 2;
            }
        }
        if (Math.sqrt(N) % 1 == 0.0) {
            counter--;
        }
        return counter;
    }
}