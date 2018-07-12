package com.codility.L5_Prefix_Sums.MinAvgTwoSlice;

class Solution {
    public int solution(int[] A) {
        int[] df = new int[A.length];
        df[0] = A[0];
        //make pref sums array
        for (int i = 1; i < A.length; i++) {
            df[i] = df[i - 1] + A[i];
        }

        int minIndex = 0;
        double minAvg = Double.MAX_VALUE;
        //increase slice size start with 1
        for (int sliceSize = 1; sliceSize < A.length; sliceSize++) {
            double currentMin = Double.MAX_VALUE;
            int currentMinIndex = 0;
            for (int i = sliceSize; i < A.length; i++) {
                double currentAvg = getAVG(df, i - sliceSize, i);
                if (currentAvg < currentMin) {
                    currentMin = currentAvg;
                    currentMinIndex = i - sliceSize;
                }
            }
            if (minAvg <= currentMin) {
                break;
            }
            if (minAvg > currentMin) {
                minAvg = currentMin;
                minIndex = currentMinIndex;
            }
        }
        return minIndex;
    }

    public double getAVG(int[] df, int P, int Q) {
        int sub = 0;
        if (P - 1 >= 0) {
            sub = df[P - 1];
        }
        return (double) (df[Q] - sub) / (double) (Q - P + 1);
    }

    // its native solution n**2
    public int nativeSolution(int[] A) {
        double minAvg = Double.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = 0;
                int counter = 0;
                for (int k = i; k <= j; k++) {
                    sum += A[k];
                    counter++;
                }
                double avg = (double) sum / (double) counter;
                if (avg < minAvg) {
                    minAvg = avg;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}
