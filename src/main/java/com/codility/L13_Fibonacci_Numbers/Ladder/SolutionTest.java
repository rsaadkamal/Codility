package com.codility.L13_Fibonacci_Numbers.Ladder;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertArrayEquals(new int[]{5, 1, 8, 0, 1}, new Solution().solution(new int[]{4, 4, 5, 5, 1}, new int[]{3, 2, 4, 3, 1}));
    }
}