package com.codility.L12_Euclidean_Algorithm.ChocolatesByNumbers;

import java.util.HashMap;

class Solution {

    private long gcd(long p, long q) {
        if (q == 0) {
            return (int) p;
        }
        return gcd(q, p % q);
    }

    private long lcm(long p, long q) {
        return p * (q / gcd(p, q));
    }

    public int solution(int N, int M) {
        return (int) (lcm(N, M) / M);
    }

    public int nativeSolution(int N, int M) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        int position = 0;
        int result = 0;
        while (!visited.containsKey(position)) {
            visited.put(position, true);
            position = (position + M) % N;
            result++;
        }
        return result;
    }
}