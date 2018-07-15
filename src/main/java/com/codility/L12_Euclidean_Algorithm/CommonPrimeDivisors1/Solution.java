package com.codility.L12_Euclidean_Algorithm.CommonPrimeDivisors1;

class Solution {
    public int solution(int[] A, int[] B) {
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (hasCommonPrimeDivisors(A[i], B[i])) {
                counter++;
            }
        }
        return counter;
    }

    private boolean hasCommonPrimeDivisors(int A, int B) {
        long commonGCD = gcd(A, B);
        long divisorA = A / commonGCD;
        long gcdA = gcd(commonGCD, divisorA);
        while (gcdA != 1) {
            divisorA /= gcdA;
            gcdA = gcd(commonGCD, divisorA);
        }
        long divisorB = B / commonGCD;
        long gcdB = gcd(commonGCD, divisorB);
        while (gcdB != 1) {
            divisorB /= gcdB;
            gcdB = gcd(commonGCD, divisorB);
        }
        return divisorA == 1 && divisorB == 1;
    }

    private long gcd(long p, long q) {
        if (q == 0) {
            return (int) p;
        }
        return gcd(q, p % q);
    }

}