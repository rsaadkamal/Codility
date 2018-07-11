package com.codility.L6_Sorting.Triangle;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{10, 2, 5, 1, 8, 20}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{10, 50, 5, 1}));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }
}