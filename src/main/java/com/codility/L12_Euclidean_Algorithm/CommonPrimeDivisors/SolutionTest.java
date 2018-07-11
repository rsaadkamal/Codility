package com.codility.L12_Euclidean_Algorithm.CommonPrimeDivisors;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(1, new Solution().solution(new int[]{15, 10, 3}, new int[]{75, 30, 5}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(2, new Solution().solution(new int[]{7, 17, 5, 3}, new int[]{7, 11, 5, 2}));
    }
}