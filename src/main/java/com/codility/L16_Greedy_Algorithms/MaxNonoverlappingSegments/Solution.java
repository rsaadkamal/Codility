package com.codility.L16_Greedy_Algorithms.MaxNonoverlappingSegments;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int solution(int[] A, int[] B) {
        ArrayList<Segment> segments = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            segments.add(new Segment(A[i], B[i]));
        }
        Collections.sort(segments, (o1, o2) -> o1.getEnd() - o2.getEnd());
        if (segments.size() <= 0) {
            return 0;
        }
        Segment current = segments.get(0);
        int counter = 1;
        for (int i = 0; i < segments.size(); i++) {
            if (current.getEnd() < segments.get(i).getStart()) {
                current = segments.get(i);
                counter++;
            }
        }
        return counter;
    }
}

class Segment {
    int start;
    int end;

    public Segment(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}