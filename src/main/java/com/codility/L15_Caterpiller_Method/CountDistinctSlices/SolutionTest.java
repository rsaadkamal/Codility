package com.codility.L15_Caterpiller_Method.CountDistinctSlices;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(9, new Solution().solution(6, new int[]{3, 4, 5, 5, 2}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(15, new Solution().solution(9, new int[]{7, 8, 0, 2, 3}));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(12, new Solution().solution(9, new int[]{7, 6, 7, 2, 8}));
    }
}