package com.codility.L6_Sorting.NumberOfDiscIntersections;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void case1() throws Exception {
        assertEquals(11, new Solution().solution(new int[]{1, 5, 2, 1, 4, 0}));
    }

    @Test
    public void case2() throws Exception {
        assertEquals(3, new Solution().solution(new int[]{1, 1, 1}));
    }

    @Test
    public void case3() throws Exception {
        assertEquals(2, new Solution().solution(new int[]{1, 2147483647, 0}));
    }

    @Test
    public void nativeVsOptimized() {
        for (int i = 1; i < 1000; i++) {
            int[] data = getRandomArray(i);
            int[] data2 = data.clone();
            assertEquals(new Solution().nativeSolution(data), new Solution().solution(data2));
        }
    }

    private int[] getRandomArray(int length) {
        int[] result = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result[i] = random.nextInt(length);
        }
        return result;
    }
}