package com.codility.L6_Sorting.Distinct;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(3, new Solution().solution(new int[]{2, 1, 1, 2, 3, 1}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void solution3() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{}));
    }
}