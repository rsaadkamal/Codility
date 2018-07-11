package com.codility.L14_Binary_Search_Algorithm.NailingPlanks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public int solution(int[] A, int[] B, int[] C) {
        ArrayList<Plank> planks = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            planks.add(new Plank(A[i], B[i]));
        }
        Collections.sort(planks, (o1, o2) -> o1.getStart() - o2.getStart());
        ArrayList<Integer> starts = this.toArrayList(A);
        ArrayList<Integer> ends = this.toArrayList(B);
        Collections.sort(starts);
        Collections.sort(ends);
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            int startsQuantity = this.getStartsQuantity(starts, C[i]);
            int endsQuantity = this.getEndsQuantity(ends, C[i]);
            ArrayList<Integer> planksToRemove = new ArrayList<>();
            for (int j = endsQuantity; j < startsQuantity; j++) {
                if (!planks.get(j).isNailed() && planks.get(j).getStart() <= C[i] && planks.get(j).getEnd() >= C[i]) {
                    planks.get(j).nail();
                    planksToRemove.add(j);
                    count++;
                    if (A.length - count == 0) {
                        return i + 1;
                    }
                }
            }
            for (int j = 0; j < planksToRemove.size(); j++) {
                int startIndex = Collections.binarySearch(starts, planks.get(planksToRemove.get(j)).getStart());
                if (startIndex >= 0) {
                    starts.remove(startIndex);
                }
                int endIndex = Collections.binarySearch(ends, planks.get(planksToRemove.get(j)).getEnd());
                if (endIndex >= 0) {
                    ends.remove(endIndex);
                }
            }
            for (int j = 0; j < planksToRemove.size(); j++) {
                planks.remove(planksToRemove.get(j) - j);
            }

        }
        return -1;
    }

    private ArrayList<Integer> toArrayList(int[] data) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            result.add(i, data[i]);
        }
        return result;
    }

    public int getMid(ArrayList<Integer> data, int key) {
        int right = 0;
        int left = data.size() - 1;
        int mid = -1;
        while (right <= left) {
            mid = right + (left - right) / 2;
            if (key < data.get(mid)) {
                left = mid - 1;
            } else if (key > data.get(mid)) {
                right = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public int getEndsQuantity(ArrayList<Integer> ends, int point) {
        int mid = getMid(ends, point);
        if (mid != ends.size() - 1) {
            mid++;
        }
        if (mid == ends.size() - 1 && ends.get(mid) < point) {
            return ends.size();
        }
        for (int i = mid; i > 0; i--) {
            if (ends.get(i - 1) < point && ends.get(i) >= point) {
                return i;
            }
        }
        return 0;
    }

    public int getStartsQuantity(ArrayList<Integer> starts, int point) {
        int mid = getMid(starts, point) - 1;
        if (mid < 0) mid = 0;
        int count = mid;
        for (int i = mid; i < starts.size(); i++) {
            if (starts.get(i) <= point) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public int nativeSolution(int[] A, int[] B, int[] C) {
        ArrayList<Plank> planks = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            Plank plank = new Plank(A[i], B[i]);
            planks.add(plank);
        }
        int counter = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < planks.size(); j++) {
                if (planks.get(j).isNailed()) {
                    continue;
                }
                if (planks.get(j).getStart() <= C[i] && planks.get(j).getEnd() >= C[i]) {
                    planks.get(j).nail();
                    counter++;
                }
                if (A.length - counter == 0) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

}

class Plank {
    private int start;
    private int end;
    private boolean isNailed = false;

    public Plank(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean isNailed() {
        return isNailed;
    }

    public void nail() {
        this.isNailed = true;
    }
}