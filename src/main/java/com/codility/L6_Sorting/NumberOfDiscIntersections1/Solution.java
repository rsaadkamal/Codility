package com.codility.L6_Sorting.NumberOfDiscIntersections1;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] A) {
        Slice[] slices = initSlices(A);
        return getIntersectionCount(slices);
    }

    public int getIntersectionCount(Slice[] slices) {
        //sort slices by ends
        Arrays.sort(slices, new Comparator<Slice>() {
            @Override
            public int compare(Slice o1, Slice o2) {
                if (o1.end < o2.end) {
                    return 1;
                } else if (o2.end == o1.end) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        int intersectionsCount = 0;
        for (int i = 0; i < slices.length; i++) {
            Slice currentSlice = slices[i];
            int j = i + 1;
            while (j < slices.length) {
                if (currentSlice.start <= slices[j].end) {
                    intersectionsCount++;
                    if (intersectionsCount > 1e7) {
                        return -1;
                    }
                } else {
                    break;
                }
                j++;
            }
        }
        return intersectionsCount;
    }

    public int nativeSolution(int[] A) {
        Slice[] slices = initSlices(A);
        int counter = 0;
        for (int i = 0; i < slices.length; i++) {
            for (int j = i + 1; j < slices.length; j++) {
                if (isIntersect(slices[i], slices[j])) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public boolean isIntersect(Slice a, Slice b) {
        return b.start <= a.end && b.end >= a.end || a.start <= b.end && a.end >= b.end;
    }

    public Slice[] initSlices(int[] A) {
        Slice[] slices = new Slice[A.length];
        for (int i = 0; i < A.length; i++) {
            long end = (long) i + A[i];
            long start = (long) i - A[i];
            slices[i] = new Slice(start, end);
        }
        return slices;
    }
}

class Slice {
    long start;
    long end;

    public Slice(long start, long end) {
        this.start = start;
        this.end = end;
    }
}