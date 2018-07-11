package com.codility.L8_Leader.Dominator;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solution() throws Exception {
        assertEquals(0, new Solution().solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
    }

    @Test
    public void solution2() throws Exception {
        assertEquals(-1, new Solution().solution(new int[]{2, 1, 1, 3}));
    }
}