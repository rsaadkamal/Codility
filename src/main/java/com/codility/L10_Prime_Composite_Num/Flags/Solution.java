package com.codility.L10_Prime_Composite_Num.Flags;

import java.util.ArrayList;

class Solution {
    public int solution(int[] A) {
        ArrayList<Integer> peaks = new ArrayList<>();
        if (A.length <= 2) {
            return 0;
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }
        if (peaks.size() == 1) {
            return 1;
        }
        if (peaks.size() == 0) {
            return 0;
        }

        int answer = 0;
        // for one peak we need minimum 3 points
        int to = A.length / 3;

        for (int i = 2; i < to; i++) {

            int current = 0;
            int flagsCount = 0;

            while (current != -1 && flagsCount != i) {
                flagsCount++;
                current = getNextPeak(current, peaks, i);
            }
            if (answer > flagsCount) {
                break;
            }
            answer = flagsCount;
        }
        return answer;
    }

    //binary search for next peak
    private int getNextPeak(int currentPeakIndex, ArrayList<Integer> peaks, int step) {
        int low = currentPeakIndex;
        int high = peaks.size() - 1;
        int key = peaks.get(currentPeakIndex) + step;
        int mid = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (key < peaks.get(mid)) {
                high = mid - 1;
            } else if (key > peaks.get(mid)) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        for (int i = mid; i < peaks.size(); i++) {
            if (peaks.get(i) >= key) {
                return i;
            }
        }
        return -1;
    }
}