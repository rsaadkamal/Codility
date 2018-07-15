package com.codility.L5_Prefix_Sums.CountDiv1;

class Solution {
    public int solution(int A, int B, int K) {
        return B / K - (A / K) + (A % K == 0 ? 1 : 0);
    }
}