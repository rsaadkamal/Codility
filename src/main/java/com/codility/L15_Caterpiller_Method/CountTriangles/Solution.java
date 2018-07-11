package com.codility.L15_Caterpiller_Method.CountTriangles;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        int result = 0;
        for (int first = 0; first < A.length; first++) {
            int third = first + 1;
            for (int second = first + 1; second < A.length; second++) {
                while (third < A.length && A[first] + A[second] > A[third])
                    third++;
                result += third - second - 1;
            }
        }
        return result;
    }
}
