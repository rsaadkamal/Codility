package com.codility.L3_Time_Complexity.PermMissingElem;

import java.math.BigInteger;

class Solution {
    public int solution(int[] A) {
        int n = A.length + 1;
        //https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF
        //BigInteger is cheating
        BigInteger formula = BigInteger.valueOf(n).multiply(BigInteger.valueOf((n + 1))).divide(BigInteger.valueOf(2));
        BigInteger sum = BigInteger.valueOf(0);
        for (int number : A) {
            sum = sum.add(BigInteger.valueOf(number));
        }
        return formula.subtract(sum).intValue();
    }
}