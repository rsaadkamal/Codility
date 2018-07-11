package com.codility.L16_Greedy_Algorithms.MaxNonoverlappingSegments;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() {
        assertEquals(3, new Solution().solution(new int[]{1,3,7,9,9}, new int[]{5,6,8,9,10}));
    }

    @Test()
    public void solution1() {
        assertEquals(1, new Solution().solution(new int[]{1,1,1,1,1}, new int[]{1,1,1,1,1}));
    }
}