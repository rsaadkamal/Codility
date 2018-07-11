package com.codility.L4_Counting_Elements.MissingInteger;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(5, new Solution().solution(new int[]{1, 3, 6, 4, 1, 2}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(2, new Solution().solution(new int[]{1}));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(100001, new Solution().solution(createArray(100000)));
    }

    private int[] createArray(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}