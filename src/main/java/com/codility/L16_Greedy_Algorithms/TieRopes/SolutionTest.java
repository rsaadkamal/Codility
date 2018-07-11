package com.codility.L16_Greedy_Algorithms.TieRopes;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(3, new Solution().solution(4, new int[]{1, 2, 3, 4, 1, 1, 3}));
    }
}