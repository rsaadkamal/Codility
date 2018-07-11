package com.codility.L10_Prime_Composite_Num.Peaks;

import java.util.ArrayList;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] A) {
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }
        if (peaks.size() == 0) {
            return 0;
        }
        for (int i = 1; i <= A.length; i++) {
            if (A.length % i != 0) {
                continue;
            }
            if (checkSlices(i, peaks, A.length)) {
                return (A.length / i);
            }
        }
        return peaks.size();
    }

    public boolean checkSlices(int sliceLength, ArrayList<Integer> peaks, int total) {
        int count = 0;
        for (int i = 0; i < peaks.size(); i++) {
            if (peaks.get(i) / sliceLength > count) {
                return false;
            }
            if (peaks.get(i) / sliceLength == count) {
                count++;
            }
        }
        if (count != total / sliceLength) {
            return false;
        }
        return true;
    }
}